package com.dzjk.qzgw.dal.dataobject;

import java.io.Serializable;
import java.util.Date;

/**
 * The table BMGW_KEY_MANAGER
 */
public class BmgwKeyManagerDO implements Serializable{

    /**
     * id ID.
     */
    private Long id;
    /**
     * creator CREATOR.
     */
    private String creator;
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
    /**
     * channelSystemId CHANNEL_SYSTEM_ID.
     */
    private String channelSystemId;

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
     * Set publicKey PUBLIC_KEY.
     */
    public void setPublicKey(String publicKey){
        this.publicKey = publicKey;
    }

    /**
     * Get publicKey PUBLIC_KEY.
     *
     * @return the string
     */
    public String getPublicKey(){
        return publicKey;
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
     * Set privateKey PRIVATE_KEY.
     */
    public void setPrivateKey(String privateKey){
        this.privateKey = privateKey;
    }

    /**
     * Get privateKey PRIVATE_KEY.
     *
     * @return the string
     */
    public String getPrivateKey(){
        return privateKey;
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
}
