package com.dzjk.qzgw.endpoint.cache;

import com.dzjk.qzgw.dal.dataobject.QzgwKeyManagerDO;
import com.dzjk.qzgw.facade.model.vo.QzgwKeyManagerVo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * Created by daixiaohu on 2018/5/30.
 */
public class QzgwKeyCache {
    private static Map<String, QzgwKeyManagerVo> cache = new HashMap<String, QzgwKeyManagerVo>();
    /** 读写锁 */
    private static final ReadWriteLock lock  = new ReentrantReadWriteLock();
    /**
     * 刷新缓存
     *
     * @param
     */
    public static void putAll(List<QzgwKeyManagerVo> qzgwKeyManagerVos) {
        Lock writelock = lock.writeLock();
        writelock.lock();
        try {
            // 临时映射信息，方便通过模板ID找到模板信息
            Map<String, QzgwKeyManagerVo> qzgwKeyManagerDOMap = new HashMap<String, QzgwKeyManagerVo>();

            // 初始化渠道返回码缓存
            for (QzgwKeyManagerVo qzgwKeyManagerVo : qzgwKeyManagerVos) {
                qzgwKeyManagerDOMap.put(qzgwKeyManagerVo.getOrgCode(), qzgwKeyManagerVo);
            }
            cache = qzgwKeyManagerDOMap;
        } finally {
            writelock.unlock();
        }

    }
    /**
     * 根据渠道查询渠道
     *
     * @param
     * @return
     *
     */
    public static QzgwKeyManagerVo get(String key) {
        Lock readlock = lock.readLock();
        readlock.lock();
        try {
            return cache.get(key);
        } finally {
            readlock.unlock();
        }
    }

    public static String getCacheInfo() {
        StringBuffer infoBuffer = new StringBuffer();
        infoBuffer.append("size:").append(cache.values().size());
        return infoBuffer.toString();
    }


}
