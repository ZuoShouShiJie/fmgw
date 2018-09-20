package com.dzjk.qzgw.endpoint.cache;

import com.dzjk.qzgw.facade.model.vo.QzgwServiceInfoVo;
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
public class QzgwServiceInfoCache {
    private static Map<String, QzgwServiceInfoVo> cache = new HashMap<String, QzgwServiceInfoVo>();
    private static final ReadWriteLock lock = new ReentrantReadWriteLock();

    /**
     * 刷新缓存
     *
     * @param
     */
    public static void putAll(List<QzgwServiceInfoVo> qzgwServiceOrgVos) {
        Lock writelock = lock.writeLock();
        writelock.lock();
        try {
            // 临时映射信息，方便通过模板ID找到模板信息
            Map<String, QzgwServiceInfoVo> qzgwServiceInfoVoHashMap = new HashMap<String, QzgwServiceInfoVo>();

            // 初始化服务接口缓存
            for (QzgwServiceInfoVo qzgwServiceInfoVo : qzgwServiceOrgVos) {
                qzgwServiceInfoVoHashMap.put(genKey(qzgwServiceInfoVo.getServiceCode(),qzgwServiceInfoVo.getBelongSystem()), qzgwServiceInfoVo);
            }
            cache = qzgwServiceInfoVoHashMap;
        } finally {
            writelock.unlock();
        }

    }

    /**
     * 根据
     *
     * @param
     * @return
     */
    public static QzgwServiceInfoVo get(String serviceCode,String belongSystem) {
        Lock readlock = lock.readLock();
        readlock.lock();
        try {
            return cache.get(genKey(serviceCode,belongSystem));
        } finally {
            readlock.unlock();
        }
    }

    public static String getCacheInfo() {
        StringBuffer infoBuffer = new StringBuffer();
        infoBuffer.append("size:").append(cache.values().size());
        return infoBuffer.toString();
    }

    private static String genKey(String serviceCode, String belongSystem) {
        StringBuffer keyBuf = new StringBuffer();
        keyBuf.append(serviceCode);
        keyBuf.append("_");
        keyBuf.append(belongSystem);
        return keyBuf.toString();
    }

}
