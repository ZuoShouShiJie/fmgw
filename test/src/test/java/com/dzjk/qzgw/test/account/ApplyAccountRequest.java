package com.dzjk.qzgw.test.account;

import java.util.List;

/**
 * Created by daixiaohu on 2018/5/21.
 */
public class ApplyAccountRequest {
    private String serialNo;
    private String appletime;
    private String name               ;
    private String idType             ;
    private String idNo               ;
    private String birthdate          ;
    private String gender             ;
    private String cellphone          ;
    private String bankCode           ;
    private String bankCardNo        ;
    private String homePhone          ;
    private String email              ;
    private String abodeDetail        ;
    private String abodeZipcode       ;
    private String conAddress         ;
    private String conZipcode         ;
    private String empPhone           ;
    private String empProvince        ;
    private String empCity            ;
    private String empZone            ;
    private String empAdd             ;
    private String unitName           ;
    private String empStructure       ;
    private String empType            ;
    private String yearsOfWork        ;
    private String empPost            ;
    private String empTitle           ;
    private String maritalStatus      ;
    private String childStatus        ;
    private String socialIdentity     ;
    private String qualification      ;
    private String degree             ;
    private String salary             ;
    private String houseCondition     ;
    private String appLmt             ;
    private String periodType         ;
    private String period             ;
    private List<ContactInfos> ContactInfos;
    private List<FileInfos> fileInfos;

    public List<FileInfos> getFileInfos() {
        return fileInfos;
    }

    public void setFileInfos(List<FileInfos> fileInfos) {
        this.fileInfos = fileInfos;
    }

    public List<com.dzjk.qzgw.test.account.ContactInfos> getContactInfos() {
        return ContactInfos;
    }

    public void setContactInfos(List<com.dzjk.qzgw.test.account.ContactInfos> contactInfos) {
        ContactInfos = contactInfos;
    }

    public String getSerialNo() {
        return serialNo;
    }

    public void setSerialNo(String serialNo) {
        this.serialNo = serialNo;
    }

    public String getAppletime() {
        return appletime;
    }

    public void setAppletime(String appletime) {
        this.appletime = appletime;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIdType() {
        return idType;
    }

    public void setIdType(String idType) {
        this.idType = idType;
    }

    public String getIdNo() {
        return idNo;
    }

    public void setIdNo(String idNo) {
        this.idNo = idNo;
    }

    public String getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getCellphone() {
        return cellphone;
    }

    public void setCellphone(String cellphone) {
        this.cellphone = cellphone;
    }

    public String getBankCode() {
        return bankCode;
    }

    public void setBankCode(String bankCode) {
        this.bankCode = bankCode;
    }

    public String getBankCardNo() {
        return bankCardNo;
    }

    public void setBankCardNo(String bankCardNo) {
        this.bankCardNo = bankCardNo;
    }

    public String getHomePhone() {
        return homePhone;
    }

    public void setHomePhone(String homePhone) {
        this.homePhone = homePhone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAbodeDetail() {
        return abodeDetail;
    }

    public void setAbodeDetail(String abodeDetail) {
        this.abodeDetail = abodeDetail;
    }

    public String getAbodeZipcode() {
        return abodeZipcode;
    }

    public void setAbodeZipcode(String abodeZipcode) {
        this.abodeZipcode = abodeZipcode;
    }

    public String getConAddress() {
        return conAddress;
    }

    public void setConAddress(String conAddress) {
        this.conAddress = conAddress;
    }

    public String getConZipcode() {
        return conZipcode;
    }

    public void setConZipcode(String conZipcode) {
        this.conZipcode = conZipcode;
    }

    public String getEmpPhone() {
        return empPhone;
    }

    public void setEmpPhone(String empPhone) {
        this.empPhone = empPhone;
    }

    public String getEmpProvince() {
        return empProvince;
    }

    public void setEmpProvince(String empProvince) {
        this.empProvince = empProvince;
    }

    public String getEmpCity() {
        return empCity;
    }

    public void setEmpCity(String empCity) {
        this.empCity = empCity;
    }

    public String getEmpZone() {
        return empZone;
    }

    public void setEmpZone(String empZone) {
        this.empZone = empZone;
    }

    public String getEmpAdd() {
        return empAdd;
    }

    public void setEmpAdd(String empAdd) {
        this.empAdd = empAdd;
    }

    public String getUnitName() {
        return unitName;
    }

    public void setUnitName(String unitName) {
        this.unitName = unitName;
    }

    public String getEmpStructure() {
        return empStructure;
    }

    public void setEmpStructure(String empStructure) {
        this.empStructure = empStructure;
    }

    public String getEmpType() {
        return empType;
    }

    public void setEmpType(String empType) {
        this.empType = empType;
    }

    public String getYearsOfWork() {
        return yearsOfWork;
    }

    public void setYearsOfWork(String yearsOfWork) {
        this.yearsOfWork = yearsOfWork;
    }

    public String getEmpPost() {
        return empPost;
    }

    public void setEmpPost(String empPost) {
        this.empPost = empPost;
    }

    public String getEmpTitle() {
        return empTitle;
    }

    public void setEmpTitle(String empTitle) {
        this.empTitle = empTitle;
    }

    public String getMaritalStatus() {
        return maritalStatus;
    }

    public void setMaritalStatus(String maritalStatus) {
        this.maritalStatus = maritalStatus;
    }

    public String getChildStatus() {
        return childStatus;
    }

    public void setChildStatus(String childStatus) {
        this.childStatus = childStatus;
    }

    public String getSocialIdentity() {
        return socialIdentity;
    }

    public void setSocialIdentity(String socialIdentity) {
        this.socialIdentity = socialIdentity;
    }

    public String getQualification() {
        return qualification;
    }

    public void setQualification(String qualification) {
        this.qualification = qualification;
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public String getHouseCondition() {
        return houseCondition;
    }

    public void setHouseCondition(String houseCondition) {
        this.houseCondition = houseCondition;
    }

    public String getAppLmt() {
        return appLmt;
    }

    public void setAppLmt(String appLmt) {
        this.appLmt = appLmt;
    }

    public String getPeriodType() {
        return periodType;
    }

    public void setPeriodType(String periodType) {
        this.periodType = periodType;
    }

    public String getPeriod() {
        return period;
    }

    public void setPeriod(String period) {
        this.period = period;
    }
}
