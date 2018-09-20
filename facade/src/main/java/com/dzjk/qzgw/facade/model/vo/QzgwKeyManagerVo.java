package com.dzjk.qzgw.facade.model.vo;

import com.basic.framework.core.base.AbstractModel;

import java.util.Date;

/**
 * Created by daixiaohu on 2018/5/31.
 */
public class QzgwKeyManagerVo extends AbstractModel{
    /**
     * id ID.
     */
    private Long id;
    /**
     * creator CREATOR.
     */
    private String creator;
    /**
     * orgCode ORG_CODE.
     */
    private String orgCode;
    /**
     * modifier MODIFIER.
     */
    private String modifier;
    /**
     * publicKey PUBLIC_KEY.
     */
    private String publicKey;
    /**
     * createTime CREATE_TIME.
     */
    private Date createTime;
    /**
     * privateKey PRIVATE_KEY.
     */
    private String privateKey;
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

    public String getModifier() {
        return modifier;
    }

    public void setModifier(String modifier) {
        this.modifier = modifier;
    }

    public String getPublicKey() {
        return publicKey;
    }

    public void setPublicKey(String publicKey) {
        this.publicKey = publicKey;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getPrivateKey() {
        return privateKey;
    }

    public void setPrivateKey(String privateKey) {
        this.privateKey = privateKey;
    }

    public Date getModifiedTime() {
        return modifiedTime;
    }

    public void setModifiedTime(Date modifiedTime) {
        this.modifiedTime = modifiedTime;
    }
}
