package com.dzjk.qzgw.core.common.enums;

/**
 * Created by daixiaohu on 2018/5/2.
 */
public enum ResultEnum {
    IpIllegal("001001", "域名不合法"),
    VerifyFail("001002", "验签失败"),
    NoFindKey("001003", "没有找到对应的key"),
    UNKONW_ERROR("001999", "未知错误"),
    ORG_ERROR("001004", "机构信息错误"),
    SERVICE_ORG_ERROR("001005","该机构没有接口权限"),
    SERVICE_CHAL_ERROR("001006","系统没有此接口");
    private String code;
    private String msg;

    private ResultEnum(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public String getCode() {
        return this.code;
    }

    public String getMsg() {
        return this.msg;
    }
}
