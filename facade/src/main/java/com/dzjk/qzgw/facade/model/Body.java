package com.dzjk.qzgw.facade.model;

/**
 * Created by daixiaohu on 2018/5/17.
 */
public class Body extends AbstractRequest{
    private String encryData;
    private String signData;

    public String getEncryData() {
        return encryData;
    }

    public void setEncryData(String encryData) {
        this.encryData = encryData;
    }

    public String getSignData() {
        return signData;
    }

    public void setSignData(String signData) {
        this.signData = signData;
    }
}
