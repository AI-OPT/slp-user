package com.ai.slp.user.api.keyinfo.param;

import javax.validation.constraints.NotNull;

import com.ai.opt.base.vo.BaseInfo;
import com.ai.slp.user.api.keyinfo.interfaces.IUcCustKeyInfoSV;

public class SearchCustKeyInfoRequest extends BaseInfo {

    private static final long serialVersionUID = 1L;

    @NotNull(message = "用户ID不能为空", groups = { IUcCustKeyInfoSV.insertCustKeyInfo.class })
    private String userId;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

}