package com.dzjk.qzgw.dal.dataobject;

import java.io.Serializable;
import java.util.Date;

/**
 * The table QZGW_ORG_INFO
 */
public class QzgwOrgInfoDO implements Serializable{

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

    /**
     * Set id ID.
     */
    public void setId(Long id){
        this.id = id;
    }

    /**
     * Get id ID.
     *
     * @return the string
     */
    public Long getId(){
        return id;
    }

    /**
     * Set orgPwd ORG_PWD.
     */
    public void setOrgPwd(String orgPwd){
        this.orgPwd = orgPwd;
    }

    /**
     * Get orgPwd ORG_PWD.
     *
     * @return the string
     */
    public String getOrgPwd(){
        return orgPwd;
    }

    /**
     * Set status STATUS.
     */
    public void setStatus(String status){
        this.status = status;
    }

    /**
     * Get status STATUS.
     *
     * @return the string
     */
    public String getStatus(){
        return status;
    }

    /**
     * Set creator CREATOR.
     */
    public void setCreator(String creator){
        this.creator = creator;
    }

    /**
     * Get creator CREATOR.
     *
     * @return the string
     */
    public String getCreator(){
        return creator;
    }

    /**
     * Set orgCode ORG_CODE.
     */
    public void setOrgCode(String orgCode){
        this.orgCode = orgCode;
    }

    /**
     * Get orgCode ORG_CODE.
     *
     * @return the string
     */
    public String getOrgCode(){
        return orgCode;
    }

    /**
     * Set orgUser ORG_USER.
     */
    public void setOrgUser(String orgUser){
        this.orgUser = orgUser;
    }

    /**
     * Get orgUser ORG_USER.
     *
     * @return the string
     */
    public String getOrgUser(){
        return orgUser;
    }

    /**
     * Set modifier MODIFIER.
     */
    public void setModifier(String modifier){
        this.modifier = modifier;
    }

    /**
     * Get modifier MODIFIER.
     *
     * @return the string
     */
    public String getModifier(){
        return modifier;
    }

    /**
     * Set createTime CREATE_TIME.
     */
    public void setCreateTime(Date createTime){
        this.createTime = createTime;
    }

    /**
     * Get createTime CREATE_TIME.
     *
     * @return the string
     */
    public Date getCreateTime(){
        return createTime;
    }

    /**
     * Set modifiedTime MODIFIED_TIME.
     */
    public void setModifiedTime(Date modifiedTime){
        this.modifiedTime = modifiedTime;
    }

    /**
     * Get modifiedTime MODIFIED_TIME.
     *
     * @return the string
     */
    public Date getModifiedTime(){
        return modifiedTime;
    }
}
