package com.ai.slp.user.api.register.param;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.ai.slp.user.api.register.interfaces.IRegisterSV;

/**
 * 用户信息 <br>
 * Date: 2016年4月18日 <br>
 * Copyright (c) 2016 asiainfo.com <br>
 * 
 * @author zhaogw
 */
public class UcCustKeyInfoParams implements Serializable {

    
    @NotNull(message="租户id不能为空",groups={IRegisterSV.InsertUcUser.class})
    private String tenantId;
    
    private Integer userId;
    
    @NotNull(message="用户类型不能为空",groups={IRegisterSV.InsertUcUser.class})
    private String userType;

    private String custName;

    private String certType;

    private String certNum;

    private String provinceCode;

    private String cityCode;

    private String countyCode;

    private String certAddr;

    private Timestamp certIssueDate;

    private String certIssueOrg;

    private Timestamp certValidDate;

    private Timestamp certInvalidDate;

    private String custSex;

    private Timestamp custBirthday;

    private String custProvinceCode;

    private String custCityCode;

    private String custCountyCode;

    private String custAddr;

    private String incomeLevel;

    private String custIndustry;

    private String custEducation;

    private Timestamp createTime;

    private String createChlId;

    private Long createOperId;

    private Timestamp updateTime;

    private String updateChlId;

    private Long updateOperId;

    public String getTenantId() {
        return tenantId;
    }

    public void setTenantId(String tenantId) {
        this.tenantId = tenantId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public String getCustName() {
        return custName;
    }

    public void setCustName(String custName) {
        this.custName = custName;
    }

    public String getCertType() {
        return certType;
    }

    public void setCertType(String certType) {
        this.certType = certType;
    }

    public String getCertNum() {
        return certNum;
    }

    public void setCertNum(String certNum) {
        this.certNum = certNum;
    }

    public String getProvinceCode() {
        return provinceCode;
    }

    public void setProvinceCode(String provinceCode) {
        this.provinceCode = provinceCode;
    }

    public String getCityCode() {
        return cityCode;
    }

    public void setCityCode(String cityCode) {
        this.cityCode = cityCode;
    }

    public String getCountyCode() {
        return countyCode;
    }

    public void setCountyCode(String countyCode) {
        this.countyCode = countyCode;
    }

    public String getCertAddr() {
        return certAddr;
    }

    public void setCertAddr(String certAddr) {
        this.certAddr = certAddr;
    }

    public Timestamp getCertIssueDate() {
        return certIssueDate;
    }

    public void setCertIssueDate(Timestamp certIssueDate) {
        this.certIssueDate = certIssueDate;
    }

    public String getCertIssueOrg() {
        return certIssueOrg;
    }

    public void setCertIssueOrg(String certIssueOrg) {
        this.certIssueOrg = certIssueOrg;
    }

    public Timestamp getCertValidDate() {
        return certValidDate;
    }

    public void setCertValidDate(Timestamp certValidDate) {
        this.certValidDate = certValidDate;
    }

    public Timestamp getCertInvalidDate() {
        return certInvalidDate;
    }

    public void setCertInvalidDate(Timestamp certInvalidDate) {
        this.certInvalidDate = certInvalidDate;
    }

    public String getCustSex() {
        return custSex;
    }

    public void setCustSex(String custSex) {
        this.custSex = custSex;
    }

    public Timestamp getCustBirthday() {
        return custBirthday;
    }

    public void setCustBirthday(Timestamp custBirthday) {
        this.custBirthday = custBirthday;
    }

    public String getCustProvinceCode() {
        return custProvinceCode;
    }

    public void setCustProvinceCode(String custProvinceCode) {
        this.custProvinceCode = custProvinceCode;
    }

    public String getCustCityCode() {
        return custCityCode;
    }

    public void setCustCityCode(String custCityCode) {
        this.custCityCode = custCityCode;
    }

    public String getCustCountyCode() {
        return custCountyCode;
    }

    public void setCustCountyCode(String custCountyCode) {
        this.custCountyCode = custCountyCode;
    }

    public String getCustAddr() {
        return custAddr;
    }

    public void setCustAddr(String custAddr) {
        this.custAddr = custAddr;
    }

    public String getIncomeLevel() {
        return incomeLevel;
    }

    public void setIncomeLevel(String incomeLevel) {
        this.incomeLevel = incomeLevel;
    }

    public String getCustIndustry() {
        return custIndustry;
    }

    public void setCustIndustry(String custIndustry) {
        this.custIndustry = custIndustry;
    }

    public String getCustEducation() {
        return custEducation;
    }

    public void setCustEducation(String custEducation) {
        this.custEducation = custEducation;
    }

    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    public String getCreateChlId() {
        return createChlId;
    }

    public void setCreateChlId(String createChlId) {
        this.createChlId = createChlId;
    }

    public Long getCreateOperId() {
        return createOperId;
    }

    public void setCreateOperId(Long createOperId) {
        this.createOperId = createOperId;
    }

    public Timestamp getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Timestamp updateTime) {
        this.updateTime = updateTime;
    }

    public String getUpdateChlId() {
        return updateChlId;
    }

    public void setUpdateChlId(String updateChlId) {
        this.updateChlId = updateChlId;
    }

    public Long getUpdateOperId() {
        return updateOperId;
    }

    public void setUpdateOperId(Long updateOperId) {
        this.updateOperId = updateOperId;
    }
    
    
    
    
    
}
