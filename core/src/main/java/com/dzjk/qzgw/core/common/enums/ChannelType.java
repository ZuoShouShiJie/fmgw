package com.dzjk.qzgw.core.common.enums;

/**
 * Created by daixiaohu on 2018/3/18.
 */
public enum ChannelType {
    CUOHE_SYS("CUOHE","撮合系统"),
    ACCOUNT_SYS("AMS","账务系统"),
    PRODUCT_SYS("PRODUCT","产品系统")
    ;
    private String code;
    private String msg;

    ChannelType(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
