package com.dzjk.qzgw.test.account;

import org.junit.Test;

public class Account {
    private String certType;
    private String certId;
    private String custBankMobile;
    private String custAcctNo;
    private String otp;
    private String fullName;
    private String mobileNo;

    public void setCertType(String certType) {
        this.certType = certType;
    }

    public void setCertId(String certId) {
        this.certId = certId;
    }

    public void setCustBankMobile(String custBankMobile) {
        this.custBankMobile = custBankMobile;
    }

    public void setCustAcctNo(String custAcctNo) {
        this.custAcctNo = custAcctNo;
    }

    public void setOtp(String otp) {
        this.otp = otp;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    public String getCertType() {
        return certType;
    }

    public String getCertId() {
        return certId;
    }

    public String getCustBankMobile() {
        return custBankMobile;
    }

    public String getCustAcctNo() {
        return custAcctNo;
    }

    public String getOtp() {
        return otp;
    }

    public String getFullName() {
        return fullName;
    }

    public String getMobileNo() {
        return mobileNo;
    }
}
