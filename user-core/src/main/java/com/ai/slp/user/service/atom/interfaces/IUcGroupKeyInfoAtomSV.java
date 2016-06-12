package com.ai.slp.user.service.atom.interfaces;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ai.slp.user.dao.mapper.bo.UcGroupKeyInfo;
import com.ai.slp.user.dao.mapper.bo.UcGroupKeyInfoCriteria;

public interface IUcGroupKeyInfoAtomSV {

    int insert(UcGroupKeyInfo record);

    List<UcGroupKeyInfo> selectByExample(UcGroupKeyInfoCriteria example);

    int updateByExampleSelective(@Param("record") UcGroupKeyInfo record, @Param("example") UcGroupKeyInfoCriteria example);
}
