package com.dzjk.qzgw.endpoint.common;

import com.solar.framework.core.enums.ServiceCode;

/**
 * Created by daixiaohu on 2018/5/30.
 */
public class QzgwServiceCode extends ServiceCode {
    public static final QzgwServiceCode qzgw = new QzgwServiceCode("qzgw", "001", "前置网关");

    public QzgwServiceCode() {
    }

    public QzgwServiceCode(String name, String code, String desc) {
        super(name, code, desc);
    }
}
