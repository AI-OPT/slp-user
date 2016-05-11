package com.ai.slp.user.api.contactsinfo.param;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;

import com.ai.opt.base.vo.BaseInfo;
import com.ai.opt.validator.constraints.MobilePhone;
import com.ai.slp.user.api.bankinfo.interfaces.IUcBankInfoSV;
import com.ai.slp.user.api.contactsinfo.interfaces.IUcContactsInfoSV;

/**
 * 创建用户联系人入参 Date: 2016年4月29日 <br>
 * Copyright (c) 2016 asiainfo.com <br>
 * 
 * @author zhangqiang7
 */
public class InsertContactsInfoRequest extends BaseInfo {

    private static final long serialVersionUID = 1L;

    /**
     * 用户Id NOT NULL
     */
    @NotNull(message = "userId不能为空", groups = { IUcContactsInfoSV.InsertContactsInfo.class })
    @Size(min = 18, max = 18, message = "用户Id长度不是18位", groups = { IUcContactsInfoSV.InsertContactsInfo.class })
    private String userId;

    /**
     * 唯一标识
     */
    @NotNull(message = "唯一标识不能为空", groups = { IUcContactsInfoSV.InsertContactsInfo.class })
    @Size(min = 18, max = 18, message = "唯一标识长度不是18位", groups = { IUcBankInfoSV.InsertBankInfo.class })
    private String contactSeqId;

    /**
     * 状态
     */
    private String state;

    /**
     * 联系人姓名
     */
    private String contactName;

    /**
     * 联系人证件类型
     */
    private String contactCertType;

    /**
     * 联系人证件号码
     */
    private String contactCertNum;

    /**
     * 联系人微信Id
     */
    private String contactWxId;

    /**
     * 联系人电话
     */
    @MobilePhone(message = "手机号码格式不正确", groups = { IUcContactsInfoSV.InsertContactsInfo.class})
    private String contactMp;

    /**
     * 联系人邮箱
     */
    @Email(message = "邮箱格式不正确",groups = {IUcContactsInfoSV.InsertContactsInfo.class})
    private String contactEmail;

    /**
     * 联系人地址
     */
    private String contactAddress;

    /**
     * 联系人邮政编码
     */
    private String groupZip;

    /**
     * 联系人工作部门
     */
    private String contactDept;

    /**
     * 备注
     */
    private String remark;

    /**
     * 创建渠道
     */
    private String createChlId;

    /**
     * 创建员工
     */
    private Long createOperId;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getContactSeqId() {
        return contactSeqId;
    }

    public void setContactSeqId(String contactSeqId) {
        this.contactSeqId = contactSeqId;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public String getContactCertType() {
        return contactCertType;
    }

    public void setContactCertType(String contactCertType) {
        this.contactCertType = contactCertType;
    }

    public String getContactCertNum() {
        return contactCertNum;
    }

    public void setContactCertNum(String contactCertNum) {
        this.contactCertNum = contactCertNum;
    }

    public String getContactWxId() {
        return contactWxId;
    }

    public void setContactWxId(String contactWxId) {
        this.contactWxId = contactWxId;
    }

    public String getContactMp() {
        return contactMp;
    }

    public void setContactMp(String contactMp) {
        this.contactMp = contactMp;
    }

    public String getContactEmail() {
        return contactEmail;
    }

    public void setContactEmail(String contactEmail) {
        this.contactEmail = contactEmail;
    }

    public String getContactAddress() {
        return contactAddress;
    }

    public void setContactAddress(String contactAddress) {
        this.contactAddress = contactAddress;
    }

    public String getGroupZip() {
        return groupZip;
    }

    public void setGroupZip(String groupZip) {
        this.groupZip = groupZip;
    }

    public String getContactDept() {
        return contactDept;
    }

    public void setContactDept(String contactDept) {
        this.contactDept = contactDept;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
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

}