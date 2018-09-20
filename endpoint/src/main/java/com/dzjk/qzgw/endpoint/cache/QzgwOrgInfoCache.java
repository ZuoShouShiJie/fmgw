package com.dzjk.qzgw.endpoint.cache;

import com.dzjk.qzgw.facade.model.vo.QzgwOrgInfoVo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * Created by daixiaohu on 2018/5/31.
 */
public class QzgwOrgInfoCache {
    private static Map<String, QzgwOrgInfoVo> cache = new HashMap<String, QzgwOrgInfoVo>();
    /**
     * 读写锁
     */
    private static final ReadWriteLock lock = new ReentrantReadWriteLock();

    /**
     * 刷新缓存
     *
     * @param
     */
    public static void putAll(List<QzgwOrgInfoVo> qzgwOrgInfoVos) {
        Lock writelock = lock.writeLock();
        writelock.lock();
        try {
            // 临时映射信息，方便通过模板ID找到模板信息
            Map<String, QzgwOrgInfoVo> qzgwOrgInfoVoHashMap = new HashMap<String, QzgwOrgInfoVo>();

            // 初始化渠道返回码缓存
            for (QzgwOrgInfoVo qzgwOrgInfoVo : qzgwOrgInfoVos) {
                qzgwOrgInfoVoHashMap.put(genKey(qzgwOrgInfoVo.getOrgCode(),qzgwOrgInfoVo.getOrgUser(),qzgwOrgInfoVo.getOrgPwd()), qzgwOrgInfoVo);
            }
            cache = qzgwOrgInfoVoHashMap;
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
    public static QzgwOrgInfoVo get(String orgCode,String orgUser,String orgPwd) {
        Lock readlock = lock.readLock();
        readlock.lock();
        try {
            return cache.get(genKey(orgCode,orgUser,orgPwd));
        } finally {
            readlock.unlock();
        }
    }

    public static String getCacheInfo() {
        StringBuffer infoBuffer = new StringBuffer();
        infoBuffer.append("size:").append(cache.values().size());
        return infoBuffer.toString();
    }

    private static String genKey(String orgCode, String orgUser, String orgPwd) {
        StringBuffer keyBuf = new StringBuffer();
        keyBuf.append(orgCode);
        keyBuf.append("_");
        keyBuf.append(orgUser);
        keyBuf.append("_");
        keyBuf.append(orgPwd);
        return keyBuf.toString();
    }

}
