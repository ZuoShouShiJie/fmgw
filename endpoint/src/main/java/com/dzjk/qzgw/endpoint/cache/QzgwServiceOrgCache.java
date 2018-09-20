package com.dzjk.qzgw.endpoint.cache;

import com.dzjk.qzgw.facade.model.vo.QzgwOrgInfoVo;
import com.dzjk.qzgw.facade.model.vo.QzgwServiceOrgVo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * Created by daixiaohu on 2018/5/31.
 */
public class QzgwServiceOrgCache {
    private static Map<String, QzgwServiceOrgVo> cache = new HashMap<String, QzgwServiceOrgVo>();
    private static final ReadWriteLock lock = new ReentrantReadWriteLock();

    /**
     * 刷新缓存
     *
     * @param
     */
    public static void putAll(List<QzgwServiceOrgVo> qzgwServiceOrgVos) {
        Lock writelock = lock.writeLock();
        writelock.lock();
        try {
            // 临时映射信息，方便通过模板ID找到模板信息
            Map<String, QzgwServiceOrgVo> qzgwServiceOrgVoHashMap = new HashMap<String, QzgwServiceOrgVo>();

            // 初始化服务接口缓存
            for (QzgwServiceOrgVo qzgwServiceOrgVo : qzgwServiceOrgVos) {
                qzgwServiceOrgVoHashMap.put(genKey(qzgwServiceOrgVo.getServiceCode(),qzgwServiceOrgVo.getBelongOrgCode()), qzgwServiceOrgVo);
            }
            cache = qzgwServiceOrgVoHashMap;
        } finally {
            writelock.unlock();
        }

    }

    /**
     * 根据机构号，机构用户，机构密码
     *
     * @param
     * @return
     */
    public static QzgwServiceOrgVo get(String serviceCode,String belongOrgCode) {
        Lock readlock = lock.readLock();
        readlock.lock();
        try {
            return cache.get(genKey(serviceCode,belongOrgCode));
        } finally {
            readlock.unlock();
        }
    }

    public static String getCacheInfo() {
        StringBuffer infoBuffer = new StringBuffer();
        infoBuffer.append("size:").append(cache.values().size());
        return infoBuffer.toString();
    }

    private static String genKey(String serviceCode, String belongOrgCode) {
        StringBuffer keyBuf = new StringBuffer();
        keyBuf.append(serviceCode);
        keyBuf.append("_");
        keyBuf.append(belongOrgCode);
        return keyBuf.toString();
    }

}
