package com.dzjk.qzgw.facade.model.vo;


import com.basic.framework.core.base.AbstractModel;

import java.util.Date;

/**
 * Created by daixiaohu on 2018/5/31.
 */
public class QzgwServiceOrgVo extends AbstractModel {
    private Long id;

    private String status;

    private String serviceCode;

    private String belongOrgCode;

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

    public void setServiceCode(String serviceCode) {
        this.serviceCode = serviceCode;
    }

    public String getBelongOrgCode() {
        return belongOrgCode;
    }

    public void setBelongOrgCode(String belongOrgCode) {
        this.belongOrgCode = belongOrgCode;
    }
}
