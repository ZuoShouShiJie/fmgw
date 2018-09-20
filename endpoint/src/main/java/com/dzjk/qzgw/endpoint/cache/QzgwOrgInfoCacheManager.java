package com.dzjk.qzgw.endpoint.cache;

import com.dzjk.qzgw.dal.dao.QzgwOrgInfoDAO;
import com.dzjk.qzgw.dal.dataobject.QzgwOrgInfoDO;
import com.dzjk.qzgw.endpoint.common.QzgwCacheName;
import com.dzjk.qzgw.endpoint.convert.QzgwOrgInfoConvert;
import com.solar.framework.cache.local.enums.CacheName;
import com.solar.framework.cache.local.manager.AbstractLocalCacheManager;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by daixiaohu on 2018/5/31.
 */
public class QzgwOrgInfoCacheManager extends AbstractLocalCacheManager {
    @Resource
    private QzgwOrgInfoDAO qzgwOrgInfoDAO;
    @Override
    protected void loadingCacheInfo() {
        loadingCache();
    }

    @Override
    public CacheName getCacheName() {
        return QzgwCacheName.QzgwOrgInfo;
    }

    @Override
    public String getCacheInfo() {
        return QzgwOrgInfoCache.getCacheInfo();
    }

    protected void loadingCache() {
        List<QzgwOrgInfoDO> qzgwOrgInfoDOS = qzgwOrgInfoDAO.loadAll();
        QzgwOrgInfoCache.putAll(QzgwOrgInfoConvert.reConvert(qzgwOrgInfoDOS));
    }
}
