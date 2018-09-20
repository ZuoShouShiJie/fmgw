package com.dzjk.qzgw.dal.dataobject;

import java.io.Serializable;
import java.util.Date;

/**
 * The table QZGW_CACHE_REFRESH_SYNC
 */
public class QzgwCacheRefreshSyncDO implements Serializable{

    /**
     * name NAME.
     */
    private String name;
    /**
     * latestNo LATEST_NO.
     */
    private Integer latestNo;
    /**
     * createTime CREATE_TIME.
     */
    private Date createTime;
    /**
     * modifyTime MODIFY_TIME.
     */
    private Date modifyTime;
    /**
     * serviceCode SERVICE_CODE.
     */
    private String serviceCode;

    /**
     * Set name NAME.
     */
    public void setName(String name){
        this.name = name;
    }

    /**
     * Get name NAME.
     *
     * @return the string
     */
    public String getName(){
        return name;
    }

    /**
     * Set latestNo LATEST_NO.
     */
    public void setLatestNo(Integer latestNo){
        this.latestNo = latestNo;
    }

    /**
     * Get latestNo LATEST_NO.
     *
     * @return the string
     */
    public Integer getLatestNo(){
        return latestNo;
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
     * Set modifyTime MODIFY_TIME.
     */
    public void setModifyTime(Date modifyTime){
        this.modifyTime = modifyTime;
    }

    /**
     * Get modifyTime MODIFY_TIME.
     *
     * @return the string
     */
    public Date getModifyTime(){
        return modifyTime;
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
}
