package com.dzjk.qzgw.endpoint.cache;

import com.dzjk.qzgw.dal.dao.QzgwServiceInfoDAO;
import com.dzjk.qzgw.dal.dao.QzgwServiceOrgDAO;
import com.dzjk.qzgw.dal.dataobject.QzgwServiceInfoDO;
import com.dzjk.qzgw.dal.dataobject.QzgwServiceOrgDO;
import com.dzjk.qzgw.endpoint.common.QzgwCacheName;
import com.dzjk.qzgw.endpoint.convert.QzgwServiceInfoConvert;
import com.dzjk.qzgw.endpoint.convert.QzgwServiceOrgConvert;
import com.solar.framework.cache.local.enums.CacheName;
import com.solar.framework.cache.local.manager.AbstractLocalCacheManager;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by daixiaohu on 2018/5/31.
 */
public class QzgwServiceInfoCacheManager extends AbstractLocalCacheManager{
    @Resource
    private QzgwServiceInfoDAO qzgwServiceInfoDAO;
    @Override
    protected void loadingCacheInfo() {
        loadingCache();
    }

    @Override
    public CacheName getCacheName() {
        return QzgwCacheName.QzgwServiceInfo;
    }

    @Override
    public String getCacheInfo() {
        return QzgwServiceInfoCache.getCacheInfo();
    }

    protected void loadingCache() {
        List<QzgwServiceInfoDO> qzgwServiceInfoDOS = qzgwServiceInfoDAO.loadAll();
        QzgwServiceInfoCache.putAll(QzgwServiceInfoConvert.reConvert(qzgwServiceInfoDOS));
    }
}
