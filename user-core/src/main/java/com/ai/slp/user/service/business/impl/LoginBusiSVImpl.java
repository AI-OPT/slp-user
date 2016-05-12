package com.ai.slp.user.service.business.impl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ai.opt.base.exception.BusinessException;
import com.ai.opt.sdk.util.StringUtil;
import com.ai.slp.user.api.login.param.LoginRequest;
import com.ai.slp.user.api.login.param.LoginResponse;
import com.ai.slp.user.dao.mapper.bo.UcUser;
import com.ai.slp.user.dao.mapper.bo.UcUserCriteria;
import com.ai.slp.user.dao.mapper.interfaces.UcUserMapper;
import com.ai.slp.user.service.business.interfaces.ILoginBusiSV;

/**
 * 登录服务 Date: 2016年4月22日 <br>
 * Copyright (c) 2016 asiainfo.com <br>
 * 
 * @author zhangqiang7
 */
@Service
@Transactional
public class LoginBusiSVImpl implements ILoginBusiSV {

    static final Log LOG = LogFactory.getLog(LoginBusiSVImpl.class);

    @Autowired
    private transient UcUserMapper userMapper;
    
    @Override
    public LoginResponse login(LoginRequest loginRequest) {

        UcUserCriteria example = new UcUserCriteria();
        UcUserCriteria.Criteria criteria = example.createCriteria();
        criteria.andTenantIdEqualTo(loginRequest.getTenantId());
        criteria.andUserTypeEqualTo(loginRequest.getUserType());
        LoginResponse response = new LoginResponse();
        List<UcUser> userList = userMapper.selectByExample(example);

        if (!StringUtil.isBlank(loginRequest.getUserLoginName())) {
            criteria.andUserLoginNameEqualTo(loginRequest.getUserLoginName());
            userList = userMapper.selectByExample(example);
            if (userList.isEmpty()) {
                throw new BusinessException("USER-ERR-001","用户不存在");
            } else {
                response.setUserLoginName(loginRequest.getUserLoginName());
                response.setUserLoginPwd(userList.get(0).getUserLoginPwd());
            }
        }
        if (!StringUtil.isBlank(loginRequest.getUserEmail())) {
            criteria.andUserEmailEqualTo(loginRequest.getUserEmail());
            criteria.andEmailValidateFlagEqualTo("11");
            userList = userMapper.selectByExample(example);
            if (userList.isEmpty()) {
                throw new BusinessException("USER-ERR-002","邮箱未验证");
            } else {
                response.setUserEmail(loginRequest.getUserEmail());
                response.setUserLoginPwd(loginRequest.getUserLoginPwd());
            }
        }
        if (!StringUtil.isBlank(loginRequest.getUserMp())) {
            criteria.andUserMpEqualTo(loginRequest.getUserMp());
            userList = userMapper.selectByExample(example);
            if (userList.isEmpty()) {
                throw new BusinessException("USER-ERR-003","手机号未绑定");
            } else {
                response.setUserMp(loginRequest.getUserMp());
                response.setUserLoginPwd(userList.get(0).getUserLoginPwd());
            }
        }
        return response;
    }
}
