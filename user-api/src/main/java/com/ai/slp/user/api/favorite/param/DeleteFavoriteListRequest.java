package com.ai.slp.user.api.favorite.param;

import java.util.List;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.ai.opt.base.vo.BaseInfo;
import com.ai.slp.user.api.favorite.interfaces.IUserFavoriteSV;

/**
 * 批量删除入参 Date: 2016年4月25日 <br>
 * Copyright (c) 2016 asiainfo.com <br>
 * 
 * @author zhangqiang7
 */
public class DeleteFavoriteListRequest extends BaseInfo {

    private static final long serialVersionUID = 1L;

    /**
     * 用户ID NOT NULL
     */
    @NotNull(message = "用户Id不能为空", groups = { IUserFavoriteSV.DeleteFavorite.class })
    @Size(min = 18, max = 18, message = "用户Id长度不是18位", groups = { IUserFavoriteSV.DeleteFavorite.class })
    private String userId;

    /**
     * 收藏ID列表 NOT NULL
     */
    @NotNull(message = "收藏ID列表不能为空", groups = { IUserFavoriteSV.DeleteFavorite.class })
    private List<String> favoriteReqIdList;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public List<String> getFavoriteReqIdList() {
        return favoriteReqIdList;
    }

    public void setFavoriteReqIdList(List<String> favoriteReqIdList) {
        this.favoriteReqIdList = favoriteReqIdList;
    }

}
