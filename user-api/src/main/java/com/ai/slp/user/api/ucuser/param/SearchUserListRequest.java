package com.ai.slp.user.api.ucuser.param;

import org.hibernate.validator.constraints.Email;

import com.ai.opt.base.vo.BaseInfo;
import com.ai.opt.validator.constraints.MobilePhone;
import com.ai.slp.user.api.ucuser.intefaces.IUcUserListSV;

/**
 * 查询用户入参 Date: 2016年5月3日 <br>
 * Copyright (c) 2016 asiainfo.com <br>
 * 
 * @author zhangqiang7
 */
public class SearchUserListRequest extends BaseInfo {

    private static final long serialVersionUID = 1L;

    /**
     * 注册来源
     */
    private String registerSource;

    /**
     * 用户VIP等级
     */
    private String vipLevel;

    /**
     * 用户登录名
     */
    private String userLoginName;

    /**
     * 户绑定手机号码
     */
    @MobilePhone(message = "手机号码格式不正确", groups = { IUcUserListSV.SearchUserList.class })
    private String userMp;

    /**
     * 用户绑定邮箱
     */
    @Email(message = "邮箱格式不正确", groups = { IUcUserListSV.SearchUserList.class })
    private String userEmail;

    /**
     * 用户状态
     */
    private String userState;

    /**
     * 开始时间
     */
    private String beginTime;

    /**
     * 结束时间
     */
    private String endTime;

    /**
     * pageSize
     */
    private Integer pageSize;

    /**
     * pageNo
     */
    private Integer pageNo;

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getPageNo() {
        return pageNo;
    }

    public void setPageNo(Integer pageNo) {
        this.pageNo = pageNo;
    }

    public String getVipLevel() {
        return vipLevel;
    }

    public void setVipLevel(String vipLevel) {
        this.vipLevel = vipLevel;
    }

    public String getUserLoginName() {
        return userLoginName;
    }

    public void setUserLoginName(String userLoginName) {
        this.userLoginName = userLoginName;
    }

    public String getUserMp() {
        return userMp;
    }

    public void setUserMp(String userMp) {
        this.userMp = userMp;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getRegisterSource() {
        return registerSource;
    }

    public void setRegisterSource(String registerSource) {
        this.registerSource = registerSource;
    }

    public String getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(String beginTime) {
        this.beginTime = beginTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getUserState() {
        return userState;
    }

    public void setUserState(String userState) {
        this.userState = userState;
    }

}
