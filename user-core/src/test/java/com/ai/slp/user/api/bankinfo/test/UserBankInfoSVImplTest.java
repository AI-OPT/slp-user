package com.ai.slp.user.api.bankinfo.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ai.slp.user.api.bankinfo.param.InsertBankInfoRequest;
import com.ai.slp.user.api.bankinfo.param.QueryBankInfoRequest;
import com.ai.slp.user.api.bankinfo.param.UpdateBankInfoRequest;
import com.ai.slp.user.service.business.interfaces.IUcBankInfoBusiSV;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "/context/core-context.xml" })
public class UserBankInfoSVImplTest {

    @Autowired
    private IUcBankInfoBusiSV userBankInfoBusiSV;
    
    @Test
    public void insertBankInfoTest(){
        InsertBankInfoRequest request = new InsertBankInfoRequest();
        request.setUserId("");
        request.setTenantId("");
        request.setAcctName("");
        request.setBankName("");
        request.setBankNo("");
        request.setAcctNo("");
        userBankInfoBusiSV.insertBankInfo(request);
    }
    
    //@Test
    public void updateBankInfoTest(){
        UpdateBankInfoRequest request = new UpdateBankInfoRequest();
        request.setTenantId("test111");
        request.setBankSeqId("111");
        request.setUserId("111");
        request.setLicenseNo("666");
        userBankInfoBusiSV.UpdateBankInfo(request);
    }

    //@Test
    public void queryBankInfoTest(){
        QueryBankInfoRequest request = new QueryBankInfoRequest();
        request.setTenantId("test111");
        request.setUserId("111");
        System.out.println(userBankInfoBusiSV.queryBankInfo(request).getResponseHeader().getResultMessage());
    }
    
    @Test
    public  void insertTest(){
        InsertBankInfoRequest re = new InsertBankInfoRequest();
        re.setTenantId("SLP");
        re.setAcctNo("234325345");
        re.setBankName("vfxvgx");
        re.setSubBranchName("dfhgfdfsd");;
        re.setUserId("000000000000000202");
        System.out.println(userBankInfoBusiSV.insertBankInfo(re));
    }
    
}
