package com.dzjk.qzgw.dal.dataobject;

import java.io.Serializable;
import java.util.Date;

/**
 * The table BMGW_COMMUNICATION
 */
public class BmgwCommunicationDO implements Serializable{

    /**
     * id ID.
     */
    private Integer id;
    /**
     * url URL.
     */
    private String url;
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
     * httpReqType HTTP_REQ_TYPE.
     */
    private String httpReqType;
    /**
     * modifiedTime MODIFIED_TIME.
     */
    private Date modifiedTime;
    /**
     * exchangeTypeId EXCHANGE_TYPE_ID.
     */
    private String exchangeTypeId;
    /**
     * channelSystemId CHANNEL_SYSTEM_ID.
     */
    private String channelSystemId;
    /**
     * exchangeTypeName EXCHANGE_TYPE_NAME.
     */
    private String exchangeTypeName;

    /**
     * Set id ID.
     */
    public void setId(Integer id){
        this.id = id;
    }

    /**
     * Get id ID.
     *
     * @return the string
     */
    public Integer getId(){
        return id;
    }

    /**
     * Set url URL.
     */
    public void setUrl(String url){
        this.url = url;
    }

    /**
     * Get url URL.
     *
     * @return the string
     */
    public String getUrl(){
        return url;
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
     * Set httpReqType HTTP_REQ_TYPE.
     */
    public void setHttpReqType(String httpReqType){
        this.httpReqType = httpReqType;
    }

    /**
     * Get httpReqType HTTP_REQ_TYPE.
     *
     * @return the string
     */
    public String getHttpReqType(){
        return httpReqType;
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

    /**
     * Set exchangeTypeId EXCHANGE_TYPE_ID.
     */
    public void setExchangeTypeId(String exchangeTypeId){
        this.exchangeTypeId = exchangeTypeId;
    }

    /**
     * Get exchangeTypeId EXCHANGE_TYPE_ID.
     *
     * @return the string
     */
    public String getExchangeTypeId(){
        return exchangeTypeId;
    }

    /**
     * Set channelSystemId CHANNEL_SYSTEM_ID.
     */
    public void setChannelSystemId(String channelSystemId){
        this.channelSystemId = channelSystemId;
    }

    /**
     * Get channelSystemId CHANNEL_SYSTEM_ID.
     *
     * @return the string
     */
    public String getChannelSystemId(){
        return channelSystemId;
    }

    /**
     * Set exchangeTypeName EXCHANGE_TYPE_NAME.
     */
    public void setExchangeTypeName(String exchangeTypeName){
        this.exchangeTypeName = exchangeTypeName;
    }

    /**
     * Get exchangeTypeName EXCHANGE_TYPE_NAME.
     *
     * @return the string
     */
    public String getExchangeTypeName(){
        return exchangeTypeName;
    }
}
