package com.ai.slp.user.api.keyinfo.param;

import java.sql.Timestamp;

import javax.validation.constraints.NotNull;

import com.ai.opt.base.vo.BaseInfo;
import com.ai.slp.user.api.keyinfo.interfaces.IUcKeyInfoSV;

public class InsertGroupKeyInfoRequest extends BaseInfo {

    private static final long serialVersionUID = 1L;

    @NotNull(message = "用户ID不能为空", groups = { IUcKeyInfoSV.insertGroupKeyInfo.class })
    private String userId;

    private String userType;

    private String certNum;

    private String custName;

    private String provinceCode;

    private String cityCode;

    private String countyCode;

    private String certAddr;

    private Timestamp certIssueDate;

    private Long registeredCapitals;

    private Timestamp certValidDate;

    private Timestamp certInvalidDate;

    private String webFlag;

    private String groupWebsite;

    private String groupMemberScale;

    private String groupType;

    private String groupIndustry;

    private String groupBusinessScope;

    private String groupProduct;

    private String legalPerson;

    private String legalCertNum;

    private String orgCode;

    private String taxpayerCode;

    private String taxpayerType;

    private String taxpayerTypeCode;

    private String groupInfo;

    private String createChlId;

    private Long createOperId;

    private String contractId;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public String getCertNum() {
        return certNum;
    }

    public void setCertNum(String certNum) {
        this.certNum = certNum;
    }

    public String getCustName() {
        return custName;
    }

    public void setCustName(String custName) {
        this.custName = custName;
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

    public Long getRegisteredCapitals() {
        return registeredCapitals;
    }

    public void setRegisteredCapitals(Long registeredCapitals) {
        this.registeredCapitals = registeredCapitals;
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

    public String getWebFlag() {
        return webFlag;
    }

    public void setWebFlag(String webFlag) {
        this.webFlag = webFlag;
    }

    public String getGroupWebsite() {
        return groupWebsite;
    }

    public void setGroupWebsite(String groupWebsite) {
        this.groupWebsite = groupWebsite;
    }

    public String getGroupMemberScale() {
        return groupMemberScale;
    }

    public void setGroupMemberScale(String groupMemberScale) {
        this.groupMemberScale = groupMemberScale;
    }

    public String getGroupType() {
        return groupType;
    }

    public void setGroupType(String groupType) {
        this.groupType = groupType;
    }

    public String getGroupIndustry() {
        return groupIndustry;
    }

    public void setGroupIndustry(String groupIndustry) {
        this.groupIndustry = groupIndustry;
    }

    public String getGroupBusinessScope() {
        return groupBusinessScope;
    }

    public void setGroupBusinessScope(String groupBusinessScope) {
        this.groupBusinessScope = groupBusinessScope;
    }

    public String getGroupProduct() {
        return groupProduct;
    }

    public void setGroupProduct(String groupProduct) {
        this.groupProduct = groupProduct;
    }

    public String getLegalPerson() {
        return legalPerson;
    }

    public void setLegalPerson(String legalPerson) {
        this.legalPerson = legalPerson;
    }

    public String getLegalCertNum() {
        return legalCertNum;
    }

    public void setLegalCertNum(String legalCertNum) {
        this.legalCertNum = legalCertNum;
    }

    public String getOrgCode() {
        return orgCode;
    }

    public void setOrgCode(String orgCode) {
        this.orgCode = orgCode;
    }

    public String getTaxpayerCode() {
        return taxpayerCode;
    }

    public void setTaxpayerCode(String taxpayerCode) {
        this.taxpayerCode = taxpayerCode;
    }

    public String getTaxpayerType() {
        return taxpayerType;
    }

    public void setTaxpayerType(String taxpayerType) {
        this.taxpayerType = taxpayerType;
    }

    public String getTaxpayerTypeCode() {
        return taxpayerTypeCode;
    }

    public void setTaxpayerTypeCode(String taxpayerTypeCode) {
        this.taxpayerTypeCode = taxpayerTypeCode;
    }

    public String getGroupInfo() {
        return groupInfo;
    }

    public void setGroupInfo(String groupInfo) {
        this.groupInfo = groupInfo;
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

    public String getContractId() {
        return contractId;
    }

    public void setContractId(String contractId) {
        this.contractId = contractId;
    }

}
