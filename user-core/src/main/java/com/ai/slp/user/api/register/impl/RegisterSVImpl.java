package com.ai.slp.user.api.register.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.ai.opt.base.vo.BaseResponse;
import com.ai.slp.user.api.register.interfaces.IRegisterSV;
import com.ai.slp.user.api.register.param.RegisterParamsRequest;
import com.ai.slp.user.api.register.param.RegisterParamsResponse;
import com.ai.slp.user.api.register.param.UcBankKeyInfoParams;
import com.ai.slp.user.api.register.param.UcContactInfoParams;
import com.ai.slp.user.api.register.param.UcCustKeyInfoParams;
import com.ai.slp.user.api.register.param.UcGroupKeyInfoParams;
import com.ai.slp.user.api.register.param.UcUserFileExtParams;
import com.ai.slp.user.api.register.param.UcUserParams;
import com.ai.slp.user.service.business.interfaces.IRegisterBusiSV;
import com.alibaba.dubbo.config.annotation.Service;

@Service(validation = "true")
public class RegisterSVImpl implements IRegisterSV {

    @Autowired
    public IRegisterBusiSV registerBusiSv;
    
    @Override
    public BaseResponse insertUcUser(RegisterParamsRequest registerParamsRequest) {
        registerBusiSv.insertUserInfo(registerParamsRequest);
        BaseResponse result = new BaseResponse();
        return result;
    }

  /*  @Override
    public RegisterParamsResponse updateUserInfo(UpdateUserParams updateUserParams) {
        registerBusiSv.updateUserInfo(updateUserParams);
        ResponseHeader responseHeader = new ResponseHeader(true, ExceptCodeConstants.SUCCESS, "成功");
        RegisterParamsResponse result = new RegisterParamsResponse();
        result.setResponseHeader(responseHeader);
        return result;
    }*/

    @Override
    public RegisterParamsResponse searchUserInfo(UcUserParams ucUser) {
        return null;
    }

    @Override
    public BaseResponse searchUserIList(UcUserParams ucUser) {
        return null;
    }

    @Override
    public BaseResponse insertUcCustInfo(UcCustKeyInfoParams ucCust) {
        return null;
    }

    @Override
    public BaseResponse searchUcCustInfo(UcCustKeyInfoParams ucCust) {
        return null;
    }

    @Override
    public BaseResponse updateUcCustInfo(UcCustKeyInfoParams ucCust) {
        return null;
    }

    @Override
    public BaseResponse insertUcGroupInfo(UcGroupKeyInfoParams ucGroup) {
        return null;
    }

    @Override
    public BaseResponse searchUcGroupInfo(UcGroupKeyInfoParams ucGroup) {
        return null;
    }

    @Override
    public BaseResponse updateUcGroupInfo(UcGroupKeyInfoParams ucGroup) {
        return null;
    }

    @Override
    public BaseResponse insertUcContactInfo(UcContactInfoParams ucContact) {
        return null;
    }

    @Override
    public BaseResponse searchUcContactInfo(UcContactInfoParams ucContact) {
        return null;
    }

    @Override
    public BaseResponse updateUcContactInfo(UcContactInfoParams ucContact) {
        return null;
    }

    @Override
    public BaseResponse insertUcBankInfo(UcBankKeyInfoParams ucBank) {
        return null;
    }

    @Override
    public BaseResponse searchUcBankInfo(UcBankKeyInfoParams ucBank) {
        return null;
    }

    @Override
    public BaseResponse updateUcBankInfo(UcBankKeyInfoParams ucBank) {
        return null;
    }

    @Override
    public BaseResponse insertUcUserFileExtInfo(UcUserFileExtParams ucUserFileExt) {
        return null;
    }

    @Override
    public BaseResponse searchUcUserFileExtInfo(UcUserFileExtParams ucUserFileExt) {
        return null;
    }

    @Override
    public BaseResponse updateUcUserFileExtInfo(UcUserFileExtParams ucUserFileExt) {
        return null;
    }

}
