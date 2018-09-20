package com.dzjk.qzgw.facade.model;

import com.basic.framework.core.base.AbstractModel;

/**
 * Created by daixiaohu on 2018/5/2.
 */
public class DataObject extends AbstractModel {
    private String signData;
    private String data;

    public String getSignData() {
        return signData;
    }

    public void setSignData(String signData) {
        this.signData = signData;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
