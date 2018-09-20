package com.dzjk.qzgw.facade.model;

import com.basic.framework.core.base.AbstractModel;

import java.util.Map;

/**
 * Created by daixiaohu on 2018/3/5.
 */
public class BaseVo extends AbstractModel {
    protected String exchangeTypeId;
    protected String channelSystemId;
    protected Map<String, String> outExtMap;

    public String getExchangeTypeId() {
        return exchangeTypeId;
    }

    public void setExchangeTypeId(String exchangeTypeId) {
        this.exchangeTypeId = exchangeTypeId;
    }

    public String getChannelSystemId() {
        return channelSystemId;
    }

    public void setChannelSystemId(String channelSystemId) {
        this.channelSystemId = channelSystemId;
    }

    public Map<String, String> getOutExtMap() {
        return outExtMap;
    }

    public void setOutExtMap(Map<String, String> outExtMap) {
        this.outExtMap = outExtMap;
    }
}
