package com.dzjk.qzgw.facade.model.vo;


import com.basic.framework.core.base.AbstractModel;

import java.util.Date;

/**
 * Created by daixiaohu on 2018/5/31.
 */
public class QzgwOrgInfoVo extends AbstractModel {
    /**
     * id ID.
     */
    private Long id;
    /**
     * orgPwd ORG_PWD.
     */
    private String orgPwd;
    /**
     * status STATUS.
     */
    private String status;
    /**
     * creator CREATOR.
     */
    private String creator;
    /**
     * orgCode ORG_CODE.
     */
    private String orgCode;
    /**
     * orgUser ORG_USER.
     */
    private String orgUser;
    /**
     * modifier MODIFIER.
     */
    private String modifier;
    /**
     * createTime CREATE_TIME.
     */
    private Date createTime;
    /**
     * modifiedTime MODIFIED_TIME.
     */
    private Date modifiedTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOrgPwd() {
        return orgPwd;
    }

    public void setOrgPwd(String orgPwd) {
        this.orgPwd = orgPwd;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public String getOrgCode() {
        return orgCode;
    }

    public void setOrgCode(String orgCode) {
        this.orgCode = orgCode;
    }

    public String getOrgUser() {
        return orgUser;
    }

    public void setOrgUser(String orgUser) {
        this.orgUser = orgUser;
    }

    public String getModifier() {
        return modifier;
    }

    public void setModifier(String modifier) {
        this.modifier = modifier;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getModifiedTime() {
        return modifiedTime;
    }

    public void setModifiedTime(Date modifiedTime) {
        this.modifiedTime = modifiedTime;
    }
}
