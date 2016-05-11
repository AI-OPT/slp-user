package com.ai.slp.user.service.business.impl;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ai.opt.base.vo.BaseResponse;
import com.ai.opt.base.vo.ResponseHeader;
import com.ai.opt.sdk.util.BeanUtils;
import com.ai.opt.sdk.util.StringUtil;
import com.ai.slp.user.api.contactsinfo.param.UcContactsInfoParams;
import com.ai.slp.user.api.register.param.UcBankKeyInfoParams;
import com.ai.slp.user.api.register.param.UcContactInfoParams;
import com.ai.slp.user.api.register.param.UcCustKeyInfoParams;
import com.ai.slp.user.api.register.param.UcGroupKeyInfoParams;
import com.ai.slp.user.api.register.param.UcUserAgreeParams;
import com.ai.slp.user.api.register.param.UcUserParams;
import com.ai.slp.user.api.register.param.UserParams;
import com.ai.slp.user.api.register.param.UserResponse;
import com.ai.slp.user.dao.mapper.bo.UcBankInfo;
import com.ai.slp.user.dao.mapper.bo.UcBankInfoCriteria;
import com.ai.slp.user.dao.mapper.bo.UcContactsInfo;
import com.ai.slp.user.dao.mapper.bo.UcContactsInfoCriteria;
import com.ai.slp.user.dao.mapper.bo.UcCustKeyInfo;
import com.ai.slp.user.dao.mapper.bo.UcCustKeyInfoCriteria;
import com.ai.slp.user.dao.mapper.bo.UcGroupKeyInfo;
import com.ai.slp.user.dao.mapper.bo.UcGroupKeyInfoCriteria;
import com.ai.slp.user.dao.mapper.bo.UcStateChg;
import com.ai.slp.user.dao.mapper.bo.UcUser;
import com.ai.slp.user.dao.mapper.bo.UcUserAgree;
import com.ai.slp.user.dao.mapper.bo.UcUserCriteria;
import com.ai.slp.user.service.atom.interfaces.IRegisterAtomSV;
import com.ai.slp.user.service.atom.interfaces.IUcBankInfoAtomSV;
import com.ai.slp.user.service.atom.interfaces.IUcContactsInfoAtomSV;
import com.ai.slp.user.service.business.interfaces.IRegisterBusiSV;

@Service
@Transactional
public class RegisterBusiSVImpl implements IRegisterBusiSV {

    private static final Log LOG = LogFactory.getLog(RegisterBusiSVImpl.class);
    @Autowired
    public IRegisterAtomSV registerAtomSv;
    
    @Autowired
    public IUcContactsInfoAtomSV iUcContactsInfoAtomSV;
    
    @Autowired
    public IUcBankInfoAtomSV iUcBankInfoAtomSV;
    
    
    //注册
    public String REGISTER_STATE = "11";
    //正常
    public String NORMAL_STATE="10";
    //冻结
    public String FREEZE_STATE="12";
    
    //个人注册代码
    public String USER_REGISTER="10";
    //企业注册代码
    public String COMPANY_REGISTER="11";
    //代理商注册代码
    public String AGENT_REGISTER="12";
    //供应商注册代码
    public String PROVIDER_REGISTER="13";
    
    /**
     * 个人用户、企业注册、代理商、供应商注册
     */
    
    @Override
    public BaseResponse insertUserInfo(UcUserParams userParams, UcUserAgreeParams agreeInfo,
            UcContactInfoParams contactParams) {
            BaseResponse response = new BaseResponse();
            ResponseHeader responseHeader = null;
            /**
             * 用户名、手机号、邮箱是不是唯一
             */
            List<UcUser> list = getUserInfoBycondition(userParams);
            boolean flag = list.size()>0?false:true;
            if(flag){
                responseHeader = new ResponseHeader(false,"fail","请输入有效信息");
                response.setResponseHeader(responseHeader);
                return response;
            }
            
            try{
                UcUser ucUser = new UcUser();
                BeanUtils.copyProperties(ucUser, userParams);
                //插入user主表
                ucUser.setUserType(REGISTER_STATE);
                int userId = registerAtomSv.insertUserInfo(ucUser);
                
                //用户状态变更
                insertUserStateChg(userParams,REGISTER_STATE);
                
                //个人用户注册需要添加一个有注册转变为正常状态的记录
                if(USER_REGISTER.equals(userParams.getUserType())){
                    insertUserStateChg(userParams,NORMAL_STATE);
                    //个人信息详情表初始化数据
                    UcCustKeyInfo custKeyInfo = new UcCustKeyInfo();
                    custKeyInfo.setTenantId(userParams.getTenantId());
                    custKeyInfo.setUserId("");
                    registerAtomSv.insertUcCustKeyInfo(custKeyInfo);
                    
                }else{
                    //企业信息表初始化数据
                    UcGroupKeyInfo groupKeyInfo = new UcGroupKeyInfo();
                    groupKeyInfo.setTenantId(userParams.getTenantId());
                    groupKeyInfo.setUserId("");
                    registerAtomSv.insertUcGroupKeyInfo(groupKeyInfo);
                }
                
                
                
                //插入用户协议表
                UcUserAgree ucUserAgree = new UcUserAgree();
                ucUserAgree.setUserId("");
                ucUserAgree.setAgreementId(agreeInfo.getAgreementId());
                registerAtomSv.InsertUcUserAgreeAtomSv(ucUserAgree);
                UcContactsInfo contactsInfo = new UcContactsInfo();
                BeanUtils.copyProperties(contactsInfo, contactParams);
                contactsInfo.setUserId(ucUser.getUserId());
                contactsInfo.setTenantId(ucUser.getTenantId());
                //TODO 插入用户联系人表sequence
                contactsInfo.setContactSeqId("11");
                iUcContactsInfoAtomSV.insert(contactsInfo);
                //用户银行卡信息记
                UcBankInfo bankInfo = new UcBankInfo();
                bankInfo.setUserId(ucUser.getUserId());
                bankInfo.setTenantId(ucUser.getTenantId());
                //TODO  获取银行卡sequence 
                bankInfo.setBankSeqId("22");
                iUcBankInfoAtomSV.insert(bankInfo );
                responseHeader = new ResponseHeader(true,"success","注册成功");
            
            }catch(Exception e){
                responseHeader = new ResponseHeader(false,"fail","注册失败");
                LOG.error("注册失败", e);
            }
           response.setResponseHeader(responseHeader);
           return response;
    }
    /**
     * 获取用户信息
     */
    @Override
    public BaseResponse getUserInfo(UcUserParams userParams) {
        BaseResponse response = new BaseResponse();
        ResponseHeader responseHeader = null;
        List<UcUser> list = getUserInfoBycondition(userParams);
        boolean flag = list.size()>0?false:true;
       
        if(flag){
            responseHeader = new ResponseHeader(false,"fail","该用户已注册，请重新输入");
        }else{
            responseHeader = new ResponseHeader(true,"success","");
        }
        response.setResponseHeader(responseHeader);
        return response;
    }
    
    @Override
    public BaseResponse getUcGroupKeyInfo(UcGroupKeyInfoParams ucGroupKeyInfoParams){
        BaseResponse response = new BaseResponse();
        ResponseHeader responseHeader = null;
        
        boolean flag = getUcGroupKeyInfoByCondition(ucGroupKeyInfoParams);
        if(flag){
            responseHeader = new ResponseHeader(false,"fail","该用户已注册，请重新输入");
        }else{
            responseHeader = new ResponseHeader(true,"success","");
        }
        response.setResponseHeader(responseHeader);
        
        return response;
    }
    
    
    /**
     * 企业资质认证(企业注册后台)
     */
    @Override
    public BaseResponse insertCompanyInfoAttest(UcUserParams userParams,UcGroupKeyInfoParams ucGroupKeyInfoParams,UcContactInfoParams ucContactInfoParams) {
        BaseResponse response = new BaseResponse();
        ResponseHeader responseHeader = null;
        
        try{
            
            /**
             * 获取当前用户信息
             */
            List<UcUser> list = getUserInfoBycondition(userParams);
            String userId = list.get(0).getUserId();
            userParams.setUserId(userId);
            //企业客户关键信息表
            UcGroupKeyInfo ucGroupKeyInfo = new UcGroupKeyInfo();
            BeanUtils.copyProperties(ucGroupKeyInfo, ucGroupKeyInfoParams);
            ucGroupKeyInfo.setUserId(userId);
            registerAtomSv.insertUcGroupKeyInfo(ucGroupKeyInfo);
            
            //用户联系人表
            UcContactsInfo ucContactsInfo = new UcContactsInfo();
            ucContactsInfo.setUserId(userId);
            BeanUtils.copyProperties(ucContactsInfo, ucContactInfoParams);
            registerAtomSv.insertUcContactsInfo(ucContactsInfo);
            
            //用户状态变更
            insertUserStateChg(userParams,REGISTER_STATE);
            
        }catch(Exception e){
            responseHeader = new ResponseHeader(false,"fail","注册失败");
            LOG.error("注册失败", e);
        }
       response.setResponseHeader(responseHeader);
       return response;
    }
    
    /**
     * 代理商资质认证
     */
    @Override
    public BaseResponse insertAgentInfoAttest(UcUserParams userParams,UcGroupKeyInfoParams ucGroupKeyInfoParams,UcContactInfoParams ucContactInfoParams,UcBankKeyInfoParams ucBankKeyInfoParam) {
        BaseResponse response = new BaseResponse();
        ResponseHeader responseHeader = null;
        
        try{
            
            /**
             * 获取当前用户信息
             */
            List<UcUser> list = getUserInfoBycondition(userParams);
            String userId = list.get(0).getUserId();
            userParams.setUserId(userId);
            //企业客户关键信息表
            UcGroupKeyInfo ucGroupKeyInfo = new UcGroupKeyInfo();
            BeanUtils.copyProperties(ucGroupKeyInfo, ucGroupKeyInfoParams);
            ucGroupKeyInfo.setUserId(userId);
            registerAtomSv.insertUcGroupKeyInfo(ucGroupKeyInfo);
            
            //用户联系人表
            UcContactsInfo ucContactsInfo = new UcContactsInfo();
            ucContactsInfo.setUserId(userId);
            BeanUtils.copyProperties(ucContactsInfo, ucContactInfoParams);
            registerAtomSv.insertUcContactsInfo(ucContactsInfo);
            
            //用户银行信息
            UcBankInfo ucBankInfo = new UcBankInfo();
            ucBankInfo.setUserId(userId);
            BeanUtils.copyProperties(ucBankInfo, ucBankKeyInfoParam);
            
            //用户状态变更
            insertUserStateChg(userParams,REGISTER_STATE);
            
        }catch(Exception e){
            responseHeader = new ResponseHeader(false,"fail","注册失败");
            LOG.error("注册失败", e);
        }
       response.setResponseHeader(responseHeader);
       return response;
    }
    
    
    /**
     * 个人认证
     * @param userParams
     * @param ucCustKeyInfpParam
     * @param ucBackInfo
     * @return
     * @author zhangyh7
     * @ApiDocMethod
     */
    public BaseResponse insertUserInfoAttest(UcUserParams userParams,UcCustKeyInfoParams ucCustKeyInfpParam,UcContactInfoParams ucContactInfoParams,UcBankInfo ucBackInfo){
       
        BaseResponse response = new BaseResponse();
        ResponseHeader responseHeader = null;
        try{
            /**
             * 获取当前用户信息
             */
            List<UcUser> list = getUserInfoBycondition(userParams);
            String userId = list.get(0).getUserId();
            userParams.setUserId(userId);
            
            UcCustKeyInfo ucCustKeyInfo = new UcCustKeyInfo();
            ucCustKeyInfo.setUserId(userId);
            BeanUtils.copyProperties(ucCustKeyInfo, ucCustKeyInfpParam);
            registerAtomSv.insertUcCustKeyInfo(ucCustKeyInfo);
            responseHeader = new ResponseHeader(true,"succss","认证成功");
            
        }catch(Exception e){
            responseHeader = new ResponseHeader(false,"fail","认证失败");
        }
        
        response.setResponseHeader(responseHeader);
        
        return response;
    }
    
    
    /**
     * 供货商申请注册
     * @param userParams
     * @return
     * @author zhangyh7
     * @ApiDocMethod
     */
    public BaseResponse inertProviderInfo(UcUserParams userParams,UcGroupKeyInfoParams ucGroupKeyInfoParams){
        
        BaseResponse response = new BaseResponse();
        ResponseHeader responseHeader = null;
        try{
            //企业客户关键信息表
            UcGroupKeyInfo ucGroupKeyInfo = new UcGroupKeyInfo();
            ucGroupKeyInfo.setUserId(userParams.getUserId());
            BeanUtils.copyProperties(ucGroupKeyInfo, ucGroupKeyInfoParams);
            registerAtomSv.insertUcGroupKeyInfo(ucGroupKeyInfo);
            responseHeader = new ResponseHeader(true,"success","注册成功");
            
            //缺少供应产品信息
            
            //用户状态变更
            insertUserStateChg(userParams,REGISTER_STATE);
            
        }catch(Exception e){
            LOG.error("供应商注册失败",e);
            responseHeader = new ResponseHeader(false,"fail","注册失败");
        }
        response.setResponseHeader(responseHeader);
        return response;
    }
    
    
    
    public List<UcUser>  getUserInfoBycondition(UcUserParams userParams){
        /**
         * 用户名、手机号、邮箱是不是唯一
         */
        UcUserCriteria criteria = new UcUserCriteria();
        if(!StringUtils.isBlank(userParams.getUserMp())){
            criteria.or().andUserMpEqualTo(userParams.getUserMp());
        }
        if(!StringUtils.isBlank(userParams.getUserLoginName())){
            criteria.or().andUserLoginNameEqualTo(userParams.getUserLoginName());
        }
        if(!StringUtils.isBlank(userParams.getUserEmail())){
            criteria.or().andUserEmailEqualTo(userParams.getUserEmail());
        }
        List<UcUser> list = registerAtomSv.getUserInfo(criteria);
        
        return list;
    }

    
    
    
    
    public boolean getUcGroupKeyInfoByCondition(UcGroupKeyInfoParams ucGroupKeyInfoParams){
        boolean flag = false;
        /**
         * 用户名或者手机号是不是唯一
         */
        UcGroupKeyInfoCriteria example =  new UcGroupKeyInfoCriteria();
        UcGroupKeyInfoCriteria.Criteria criteria = example.createCriteria();
        if(!StringUtil.isBlank(ucGroupKeyInfoParams.getCustName())){
            criteria.andCustNameEqualTo(ucGroupKeyInfoParams.getCustName());
        }
        List<UcGroupKeyInfo> list = registerAtomSv.getUcGroupKeyInfo(example);
        /**
         * list.size()>0说明用户名或者手机不唯一，返回false
         */
        flag = list.size()>0?false:true;
        
        return flag;
    }
  
    /**
     * 用户轨迹状态变化方法
     * @param userParams
     * @return
     * @author zhangyh7
     * @ApiDocMethod
     */
    public int insertUserStateChg(UcUserParams userParams,String state){
        UcStateChg ucStateChgRegister = new UcStateChg();
        ucStateChgRegister.setTenantId(userParams.getTenantId());
        ucStateChgRegister.setUserId(userParams.getUserId());
        ucStateChgRegister.setOperType(userParams.getUserType());
        ucStateChgRegister.setNewState(state);
        ucStateChgRegister.setChgTime(new Timestamp(new Date().getTime()));
        return registerAtomSv.insertUcStateChgBusiInfo(ucStateChgRegister);
    }
    
    @Override
    public BaseResponse updateUserInfo(UserParams updateUserParams){
        BaseResponse response = new BaseResponse();
        ResponseHeader responseHeader = null;
        boolean flag = false;
        if(updateUserParams==null){
            responseHeader = new ResponseHeader(false,"fail","用户信息为空，更新失败");
            response.setResponseHeader(responseHeader);
            return response;
        }
        /*************更新用户基本信息*********************/
        UcUserParams ucUserParams = updateUserParams.getUcUserParams();
        if(ucUserParams ==null){
            responseHeader = new ResponseHeader(false,"fail","用户基本信息为空信息为空，更新失败");
            response.setResponseHeader(responseHeader);
            return response;
        }else{
            //校验用户名、邮箱、手机号码
            List<UcUser> list = getUserInfoBycondition(ucUserParams);
            boolean valide = list.size()>0?false:true;
            if(valide){
                //根据用户id判断是否是当前用户如果不是当前用户 则表示用户名、邮箱、手机号码重复
                boolean uservalide = false;
                for(UcUser user :list){
                    if(!user.getUserId().equals(ucUserParams.getUserId())){
                        uservalide = true ;
                    }
                }
                if(uservalide){
                    responseHeader = new ResponseHeader(false,"fail","请输入有效信息");
                    response.setResponseHeader(responseHeader);
                    return response;
                }
            }
            UcUser record = new UcUser();
            BeanUtils.copyProperties(record, ucUserParams);
            UcUserCriteria example = new UcUserCriteria();
            example.createCriteria().andUserIdEqualTo(record.getUserId())
                                                       .andTenantIdEqualTo(record.getTenantId());
            registerAtomSv.updateUserInfo(record, example);
        }
        //更新用户个人详细信息
        UcCustKeyInfoParams ucCustKey = updateUserParams.getUcCustKeyInfoParams();
        if(ucCustKey!=null){
            UcCustKeyInfo record = new UcCustKeyInfo();
            BeanUtils.copyProperties(record, ucCustKey);
            UcCustKeyInfoCriteria example = new UcCustKeyInfoCriteria();
            example.createCriteria().andUserIdEqualTo(record.getUserId())
                                                       .andTenantIdEqualTo(record.getTenantId());
            registerAtomSv.updateCustKeyInfo(record, example);
        }
        //更新企业信息
        UcGroupKeyInfoParams  ucGroupKeyInfoParams  = updateUserParams.getUcGroupKeyInfoParams();
        if(ucGroupKeyInfoParams!=null ){
            UcGroupKeyInfo record = new UcGroupKeyInfo();
            BeanUtils.copyProperties(record, ucGroupKeyInfoParams);
            UcGroupKeyInfoCriteria example = new UcGroupKeyInfoCriteria();
            example.createCriteria().andUserIdEqualTo(record.getUserId())
                                            .andTenantIdEqualTo(record.getTenantId());
            registerAtomSv.updateGroupKeyInfo(record, example);
        }
        //更新用户联系人信息
        UcContactInfoParams ucContactInfoParams  = updateUserParams.getUcContactInfoParams();
        if(ucContactInfoParams!=null){
            UcContactsInfo record = new UcContactsInfo();
            BeanUtils.copyProperties(record, ucContactInfoParams);
            UcContactsInfoCriteria example = new UcContactsInfoCriteria();
            example.createCriteria().andUserIdEqualTo(record.getUserId())
                                            .andTenantIdEqualTo(record.getTenantId());
            iUcContactsInfoAtomSV.updateByExampleSelective(record, example);
        }
        //更新用户银行信息
        UcBankKeyInfoParams ucBankKeyParams = updateUserParams.getUcBankKeyParams();
        if(ucBankKeyParams!=null){
            UcBankInfo record = new UcBankInfo();
            BeanUtils.copyProperties(record, ucBankKeyParams);
            UcBankInfoCriteria example = new UcBankInfoCriteria();
            example.createCriteria().andUserIdEqualTo(record.getUserId())
            .andTenantIdEqualTo(record.getTenantId());
            iUcBankInfoAtomSV.updateByExampleSelective(record, example);
        }
        responseHeader = new ResponseHeader(true,"success","更新成功");
        response.setResponseHeader(responseHeader);
        return response;
    }
    
    @Override
    public UserResponse searchUserInfo(UcUserParams ucUser){
        UserResponse response = new UserResponse();
        UserParams userParams = new UserParams();
        UcUserParams ucUserParams = new UcUserParams();
        //查询用户基本信息
        UcUserCriteria userCriteria = new UcUserCriteria();
        userCriteria.createCriteria().andUserIdEqualTo(ucUser.getUserId())
                                                        .andTenantIdEqualTo(ucUser.getTenantId());
        List<UcUser> userlist = registerAtomSv.getUserInfo(userCriteria);
        if(userlist!=null &&userlist.size()>0){
            UcUser userInfo = userlist.get(0);
            BeanUtils.copyProperties(ucUserParams, userInfo);
        }
        userParams.setUcUserParams(ucUserParams);
        if(USER_REGISTER.equals(ucUserParams.getUserType())){
            //个人用户
            UcCustKeyInfoCriteria criteria = new UcCustKeyInfoCriteria();
            criteria.createCriteria().andUserIdEqualTo(ucUserParams.getUserId())
                                            .andTenantIdEqualTo(ucUserParams.getTenantId());
           List<UcCustKeyInfo> custList = registerAtomSv.getUcCustKeyInfo(criteria);
           
           if(custList!=null && custList.size()>0){
               UcCustKeyInfo ucCustKeyInfo = custList.get(0);
               UcCustKeyInfoParams ucCustKeyInfoParams = new UcCustKeyInfoParams();
               BeanUtils.copyProperties(ucCustKeyInfoParams, ucCustKeyInfo);
               userParams.setUcCustKeyInfoParams(ucCustKeyInfoParams);
           }
        }else{
            /*
             * 企业用户
             */
            //企业资料信息
            UcGroupKeyInfoCriteria groupCriteria = new UcGroupKeyInfoCriteria();
            groupCriteria.createCriteria().andUserIdEqualTo(ucUserParams.getUserId())
            .andTenantIdEqualTo(ucUserParams.getTenantId());
            List<UcGroupKeyInfo> ucGroupList = registerAtomSv.getUcGroupKeyInfo(groupCriteria);
            if(ucGroupList!=null&&ucGroupList.size()>0){
                UcGroupKeyInfo ucGroupKeyInfo = ucGroupList.get(0);
                UcGroupKeyInfoParams ucGroupKeyInfoParams = new UcGroupKeyInfoParams();
                BeanUtils.copyProperties(ucGroupKeyInfoParams, ucGroupKeyInfo);
                userParams.setUcGroupKeyInfoParams(ucGroupKeyInfoParams);
            }
            //联系人信息
            UcContactsInfoCriteria contactsCriteria = new UcContactsInfoCriteria();
            contactsCriteria.createCriteria().andUserIdEqualTo(ucUserParams.getUserId())
            .andTenantIdEqualTo(ucUserParams.getTenantId());
            List<UcContactsInfo> contactsList = registerAtomSv.getUcContactsInfo(contactsCriteria);
            if(contactsList!=null &&contactsList.size()>0){
                UcContactsInfo contactsInfo = contactsList.get(0);
                UcContactInfoParams contactsInfoParams = new UcContactInfoParams();
                BeanUtils.copyProperties(contactsInfoParams, contactsInfo);
                userParams.setUcContactInfoParams(contactsInfoParams);
                
            }
            
        }
        
        ResponseHeader header = new ResponseHeader(true,"success","查询成功");
        response.setUserParams(userParams);
        response.setResponseHeader(header);
        return response;
    }
    
    
}
