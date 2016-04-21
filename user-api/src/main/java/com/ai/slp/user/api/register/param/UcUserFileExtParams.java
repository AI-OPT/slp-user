package com.ai.slp.user.api.register.param;

import java.io.Serializable;

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
public class UcUserFileExtParams implements Serializable {

    
    @NotNull(message="租户id不能为空",groups={IRegisterSV.InsertUcUser.class})
    private String tenantId;
    
    private Integer userId;
    
    private String extendinfo;

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

    public String getExtendinfo() {
        return extendinfo;
    }

    public void setExtendinfo(String extendinfo) {
        this.extendinfo = extendinfo;
    }
    
    
    
    
}
