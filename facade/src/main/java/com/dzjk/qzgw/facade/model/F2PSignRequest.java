package com.dzjk.qzgw.facade.model;

/**
 * @version $Id: F2PSignRequest.java, v 0.0.1 2016/11/5 15:28 callie Exp $
 */
public class F2PSignRequest extends AbstractRequest {

    /**
     * 会员号
     */
    private String userId;

    /**
     * 银行卡号
     */
    private String cardName;

    /**
     * 证件类型
     */
    private String certType;

    /**
     * 证件号
     */
    private String certNo;

    /**
     * 卡索引号
     */
    private String cardIdxNo;

    /**
     * 开户手机号
     */
    private String mobile;


    private String riskLevel;


    /**
     * 短信验证码
     */
    private String verifyCode;

    private String fundAcctNo;

    public String getCardName() {
        return cardName;
    }

    public void setCardName(String cardName) {
        this.cardName = cardName;
    }

    public String getCertType() {
        return certType;
    }

    public void setCertType(String certType) {
        this.certType = certType;
    }


    public String getCardIdxNo() {
        return cardIdxNo;
    }

    public void setCardIdxNo(String cardIdxNo) {
        this.cardIdxNo = cardIdxNo;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getVerifyCode() {
        return verifyCode;
    }

    public void setVerifyCode(String verifyCode) {
        this.verifyCode = verifyCode;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }


    public String getFundAcctNo() {
        return fundAcctNo;
    }

    public void setFundAcctNo(String fundAcctNo) {
        this.fundAcctNo = fundAcctNo;
    }

    public String getCertNo() {
        return certNo;
    }

    public void setCertNo(String certNo) {
        this.certNo = certNo;
    }

    public String getRiskLevel() {
        return riskLevel;
    }

    public void setRiskLevel(String riskLevel) {
        this.riskLevel = riskLevel;
    }
}
