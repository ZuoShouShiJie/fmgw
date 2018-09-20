package com.dzjk.qzgw.dal.dataobject;

import java.io.Serializable;
import java.util.Date;

/**
 * The table QZGW_SERVICE_INFO
 */
public class QzgwServiceInfoDO implements Serializable{

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
     * modifier MODIFIER.
     */
    private String modifier;
    /**
     * createTime CREATE_TIME.
     */
    private Date createTime;
    /**
     * serviceCode SERVICE_CODE.
     */
    private String serviceCode;
    private String serviceName;
    /**
     * belongSystem BELONG_SYSTEM.
     */
    private String belongSystem;
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

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
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
     * Set belongSystem BELONG_SYSTEM.
     */
    public void setBelongSystem(String belongSystem){
        this.belongSystem = belongSystem;
    }

    /**
     * Get belongSystem BELONG_SYSTEM.
     *
     * @return the string
     */
    public String getBelongSystem(){
        return belongSystem;
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
