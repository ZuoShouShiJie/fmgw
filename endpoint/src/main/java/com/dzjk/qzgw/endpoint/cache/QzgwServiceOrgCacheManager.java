package com.dzjk.qzgw.endpoint.cache;

import com.dzjk.qzgw.dal.dao.QzgwServiceOrgDAO;
import com.dzjk.qzgw.dal.dataobject.QzgwOrgInfoDO;
import com.dzjk.qzgw.dal.dataobject.QzgwServiceOrgDO;
import com.dzjk.qzgw.endpoint.common.QzgwCacheName;
import com.dzjk.qzgw.endpoint.convert.QzgwOrgInfoConvert;
import com.dzjk.qzgw.endpoint.convert.QzgwServiceOrgConvert;
import com.solar.framework.cache.local.enums.CacheName;
import com.solar.framework.cache.local.manager.AbstractLocalCacheManager;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by daixiaohu on 2018/5/31.
 */
public class QzgwServiceOrgCacheManager extends AbstractLocalCacheManager{
    @Resource
    private QzgwServiceOrgDAO qzgwServiceOrgDAO;
    @Override
    protected void loadingCacheInfo() {
        loadingCache();
    }

    @Override
    public CacheName getCacheName() {
        return QzgwCacheName.QzgwServiceOrg;
    }

    @Override
    public String getCacheInfo() {
        return QzgwServiceOrgCache.getCacheInfo();
    }

    protected void loadingCache() {
        List<QzgwServiceOrgDO> qzgwServiceOrgDOS = qzgwServiceOrgDAO.loadAll();
        QzgwServiceOrgCache.putAll(QzgwServiceOrgConvert.reConvert(qzgwServiceOrgDOS));
    }
}
