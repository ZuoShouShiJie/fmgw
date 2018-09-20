package com.dzjk.qzgw.facade.model.vo;

import com.basic.framework.core.base.AbstractModel;

/**
 * Created by daixiaohu on 2018/5/31.
 */
public class QzgwServiceInfoVo extends AbstractModel {
    private Long id;
    private String status;
    private String serviceCode;
    private String serviceName;
    private String belongSystem;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getServiceCode() {
        return serviceCode;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public void setServiceCode(String serviceCode) {
        this.serviceCode = serviceCode;
    }

    public String getBelongSystem() {
        return belongSystem;
    }

    public void setBelongSystem(String belongSystem) {
        this.belongSystem = belongSystem;
    }
}
