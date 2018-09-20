package com.dzjk.qzgw.core.common.enums;

/**
 * Created by daixiaohu on 2018/5/2.
 */
public enum TransType {
    QueryAccount("1000"," 账务查询"),
    QueryRepayPlan("1001","还款计划查询"),
    QueryPlatEarnings("1002","撮合平台收益计划查询"),
    AccountTrial("1003","借款前账务试算"),
    CreateAccount("1004","审贷建账"),
    PrePrpayTry("1005","提前还款试算"),
    ManualRepay("1006","还款交易"),
    AccountUpdate("1007","账务变更"),
    QueryAccountStatus("1008","查询建账是否成功"),

    Cuohe_CapitalApply("2000","资金申请"),
    Cuohe_MoneySelect("2001","资金申请查询"),
    Cuohe_Credit("2002","征信查询"),
    Cuohe_Message("2003","短信发送"),
    Cuohe_Account("2004","开户");

    private String code;
    private String msg;

    TransType(String code, String msg) {
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
