package com.ai.slp.user.api.seq.interfaces;

import com.ai.opt.base.exception.BusinessException;
import com.ai.opt.base.exception.SystemException;
import com.ai.slp.user.api.seq.param.PhoneMsgSeqResponse;

public interface ICreateSeqSV {
	/**
	 * 获取短信信息seq
	 * @return PhoneMsgSeqResponse
	 * @author jiaxs
     * @ApiDocMethod
     * @ApiCode UAC_0011
	 */
	PhoneMsgSeqResponse createPhoneMsgSeq() throws BusinessException,SystemException;
}
