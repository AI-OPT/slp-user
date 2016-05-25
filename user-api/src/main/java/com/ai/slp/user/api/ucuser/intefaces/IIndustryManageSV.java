package com.ai.slp.user.api.ucuser.intefaces;

import java.util.List;

import com.ai.opt.base.exception.BusinessException;
import com.ai.opt.base.exception.SystemException;
import com.ai.slp.user.api.ucuser.param.IndustryQueryResponse;

public interface IIndustryManageSV {
    /**
     * 查询所有行业类型
     * @return
     * @throws BusinessException
     * @throws SystemException
     * @author zhanglh
     * @ApiCode UAC_0012
     */
    List<IndustryQueryResponse> queryIndustryList() throws BusinessException,SystemException;
    /**
     * 根据行业编码查询单个行业类型
     * @return 
     * @throws BusinessException
     * @throws SystemException
     * @author zhanglh
     * @ApiCode UAC_0013
     */
    IndustryQueryResponse queryByIndustryCode(String industryCode)throws BusinessException,SystemException;
}
