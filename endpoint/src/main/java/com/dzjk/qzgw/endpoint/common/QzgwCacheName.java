package com.dzjk.qzgw.endpoint.common;


import com.solar.framework.cache.local.enums.CacheName;
import com.solar.framework.core.base.AbstractEnum;
import com.solar.framework.core.enums.ServiceCode;

/**
 * 
 * @author callie
 *
 */
public class QzgwCacheName extends CacheName {

    public static final CacheName QzgwKey =new QzgwCacheName("QzgwKey", QzgwServiceCode.qzgw,"机构秘钥缓存");
    public static final CacheName QzgwOrgInfo =new QzgwCacheName("QzgwOrgInfo", QzgwServiceCode.qzgw,"机构信息缓存");
    public static final CacheName QzgwServiceOrg =new QzgwCacheName("QzgwServiceOrg", QzgwServiceCode.qzgw,"服务机构权限缓存");
    public static final CacheName QzgwServiceInfo =new QzgwCacheName("QzgwServiceInfo", QzgwServiceCode.qzgw,"服务信息缓存");

    public QzgwCacheName() {
    }

    public QzgwCacheName(String name, ServiceCode serviceCode, String desc) {
        super(name, serviceCode, desc);
    }

    @Override
    protected Class<? extends AbstractEnum> getEnumType() {
        return QzgwCacheName.class;
    }
}
