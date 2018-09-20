package com.dzjk.qzgw.endpoint.cache;

import com.dzjk.qzgw.dal.dao.QzgwKeyManagerDAO;
import com.dzjk.qzgw.dal.dataobject.QzgwKeyManagerDO;
import com.dzjk.qzgw.endpoint.common.QzgwCacheName;
import com.dzjk.qzgw.endpoint.convert.QzgwKeyManagerConvert;
import com.solar.framework.cache.local.enums.CacheName;
import com.solar.framework.cache.local.manager.AbstractLocalCacheManager;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by daixiaohu on 2018/5/30.
 */
public class QzgwKeyCacheManager extends AbstractLocalCacheManager {
    @Resource
    private QzgwKeyManagerDAO qzgwKeyManagerDAO;

    @Override
    protected void loadingCacheInfo() {
        loadingCache();
    }

    @Override
    public CacheName getCacheName() {
        return QzgwCacheName.QzgwKey;
    }

    @Override
    public String getCacheInfo() {
        return QzgwKeyCache.getCacheInfo();
    }

    protected void loadingCache() {
        List<QzgwKeyManagerDO> qzgwKeyManagerDOs = qzgwKeyManagerDAO.loadAll();
        QzgwKeyCache.putAll(QzgwKeyManagerConvert.reConvert(qzgwKeyManagerDOs));
    }
}
