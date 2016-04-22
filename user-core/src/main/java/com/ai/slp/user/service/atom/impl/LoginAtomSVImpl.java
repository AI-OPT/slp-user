package com.ai.slp.user.service.atom.impl;

import org.springframework.stereotype.Component;

import com.ai.opt.base.exception.SystemException;
import com.ai.slp.user.dao.mapper.bo.UcUserCriteria;
import com.ai.slp.user.dao.mapper.factory.MapperFactory;
import com.ai.slp.user.service.atom.interfaces.ILoginAtomSV;

@Component
public class LoginAtomSVImpl implements ILoginAtomSV {

    @Override
    public int countByExample(UcUserCriteria example) throws SystemException {
        return MapperFactory.getUcUserMapper().countByExample(example);
    }
       
}
