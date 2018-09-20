package com.dzjk.qzgw.dal.dataobject;

import java.io.Serializable;
import java.util.Date;

/**
 * The table QZGW_TRANS_INFO
 */
public class QzgwTransInfoDO implements Serializable{

    /**
     * id ID.
     */
    private Long id;
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
     * transNo TRANS_NO.
     */
    private String transNo;
    /**
     * modifier MODIFIER.
     */
    private String modifier;
    /**
     * createTime CREATE_TIME.
     */
    private Date createTime;
    /**
     * requestMsg REQUEST_MSG.
     */
    private String requestMsg;
    /**
     * systemCode SYSTEM_CODE.
     */
    private String systemCode;
    /**
     * responseMsg RESPONSE_MSG.
     */
    private String responseMsg;
    /**
     * serviceCode SERVICE_CODE.
     */
    private String serviceCode;
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
     * Set transNo TRANS_NO.
     */
    public void setTransNo(String transNo){
        this.transNo = transNo;
    }

    /**
     * Get transNo TRANS_NO.
     *
     * @return the string
     */
    public String getTransNo(){
        return transNo;
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
     * Set requestMsg REQUEST_MSG.
     */
    public void setRequestMsg(String requestMsg){
        this.requestMsg = requestMsg;
    }

    /**
     * Get requestMsg REQUEST_MSG.
     *
     * @return the string
     */
    public String getRequestMsg(){
        return requestMsg;
    }

    /**
     * Set systemCode SYSTEM_CODE.
     */
    public void setSystemCode(String systemCode){
        this.systemCode = systemCode;
    }

    /**
     * Get systemCode SYSTEM_CODE.
     *
     * @return the string
     */
    public String getSystemCode(){
        return systemCode;
    }

    /**
     * Set responseMsg RESPONSE_MSG.
     */
    public void setResponseMsg(String responseMsg){
        this.responseMsg = responseMsg;
    }

    /**
     * Get responseMsg RESPONSE_MSG.
     *
     * @return the string
     */
    public String getResponseMsg(){
        return responseMsg;
    }

    /**
     * Set serviceCode SERVICE_CODE.
     */
    public void setServiceCode(String serviceCode){
        this.serviceCode = serviceCode;
    }

    /**
     * Get serviceCode SERVICE_CODE.
     *
     * @return the string
     */
    public String getServiceCode(){
        return serviceCode;
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
