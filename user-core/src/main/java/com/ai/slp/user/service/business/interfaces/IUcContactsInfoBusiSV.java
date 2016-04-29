package com.ai.slp.user.service.business.interfaces;

import com.ai.opt.base.exception.BusinessException;
import com.ai.opt.base.exception.SystemException;
import com.ai.opt.base.vo.BaseResponse;
import com.ai.opt.base.vo.PageInfo;
import com.ai.slp.user.api.contactsinfo.param.InsertContactsInfoRequest;
import com.ai.slp.user.api.contactsinfo.param.QueryContactsInfoRequest;
import com.ai.slp.user.api.contactsinfo.param.QueryContactsInfoResponse;
import com.ai.slp.user.api.contactsinfo.param.UpdateContactsInfoRequest;

public interface IUcContactsInfoBusiSV {

    public BaseResponse insertContactsInfo(InsertContactsInfoRequest contactsInfoRequest)
            throws BusinessException, SystemException;

    public BaseResponse updateContactsInfo(UpdateContactsInfoRequest contactsInfoRequest)
            throws BusinessException, SystemException;

    public PageInfo<QueryContactsInfoResponse> queryContactsInfo(
            QueryContactsInfoRequest contactsInfoRequest) throws BusinessException, SystemException;
}
