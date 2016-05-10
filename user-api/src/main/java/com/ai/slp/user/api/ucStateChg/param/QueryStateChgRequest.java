package com.ai.slp.user.api.ucStateChg.param;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.ai.opt.base.vo.BaseInfo;
import com.ai.slp.user.api.ucStateChg.interfaces.IUcStateChgSV;

public class QueryStateChgRequest extends BaseInfo {

    private static final long serialVersionUID = 1L;

    @NotNull(message = "userId不能为空", groups = { IUcStateChgSV.InsertUcStateChgInfo.class })
    @Size(min = 18, max = 18, message = "用户Id长度不是18位", groups = { IUcStateChgSV.InsertUcStateChgInfo.class })
    private String userId;

    private String stateChgId;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getStateChgId() {
        return stateChgId;
    }

    public void setStateChgId(String stateChgId) {
        this.stateChgId = stateChgId;
    }

}
