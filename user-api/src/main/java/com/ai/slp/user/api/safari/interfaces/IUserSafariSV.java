package com.ai.slp.user.api.safari.interfaces;

import com.ai.opt.base.exception.BusinessException;
import com.ai.opt.base.exception.SystemException;
import com.ai.opt.base.vo.PageInfo;
import com.ai.slp.user.api.safari.param.CreateUserSafariRequest;
import com.ai.slp.user.api.safari.param.CreateUserSafariResponse;
import com.ai.slp.user.api.safari.param.DeleteSafariRequest;
import com.ai.slp.user.api.safari.param.UserSafariInfoRequest;
import com.ai.slp.user.api.safari.param.UserSafariInfoResponse;

/**
 * 用户查看商品足迹服务<br>
 * Date: 2016年4月20日 <br>
 * Copyright (c) 2016 asiainfo.com <br>
 * 
 * @author zhangqiang7
 */

public interface IUserSafariSV {

    @interface InsertUserSafari {
    }

    /**
     * 用户浏览商品信息创建
     * 
     * @param createUserSafariRequest
     * @return
     * @throws BusinessException
     * @throws SystemException
     * @author zhangqiang7
     * @UCUSER_010
     */
    CreateUserSafariResponse insertUserSafari(CreateUserSafariRequest createUserSafariRequest)
            throws BusinessException, SystemException;

    @interface DeleteUserSafari {
    }

    /**
     * 用户浏览商品信息删除
     * 
     * @param ucUserSafariParams
     * @throws BusinessException
     * @throws SystemException
     * @author zhangqiang7
     * @UCUSER_011
     */
    void deleteUserSafari(DeleteSafariRequest deleetSafariRequest)
            throws BusinessException, SystemException;

    @interface QueryUserSafari {
    }

    /**
     * 用户浏览商品信息查询
     * 
     * @param userSafariInfoRequest
     * @return
     * @throws BusinessException
     * @throws SystemException
     * @author zhangqiang7
     * @UCUSER_012
     */
    PageInfo<UserSafariInfoResponse> queryUserSafari(UserSafariInfoRequest userSafariInfoRequest)
            throws BusinessException, SystemException;
}