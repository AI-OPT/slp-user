package com.ai.slp.user.api.contactsinfo.param;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.ai.opt.base.vo.BaseInfo;
import com.ai.slp.user.api.contactsinfo.interfaces.IUcContactsInfoSV;

/**
 * 获取联系人入参 Date: 2016年4月29日 <br>
 * Copyright (c) 2016 asiainfo.com <br>
 * 
 * @author zhangqiang7
 */
public class QueryContactsInfoRequest extends BaseInfo {

    private static final long serialVersionUID = 1L;

    /**
     * 用户ID NOT NULL
     */
    @NotNull(message = "userId不能为空", groups = { IUcContactsInfoSV.QueryContactsInfo.class })
    @Size(min = 18, max = 18, message = "用户Id长度不是18位", groups = { IUcContactsInfoSV.QueryContactsInfo.class })
    private String userId;

    /**
     * pageNo
     */
    private Integer pageNo;

    /**
     * pageSize
     */
    private Integer pageSize;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Integer getPageNo() {
        return pageNo;
    }

    public void setPageNo(Integer pageNo) {
        this.pageNo = pageNo;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

}
