package com.ai.slp.user.api.apiinfo.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ai.opt.base.vo.PageInfo;
import com.ai.slp.user.api.apiinfo.param.ApiInfoRequest;
import com.ai.slp.user.api.apiinfo.param.ApiInfoResponse;
import com.ai.slp.user.api.apiinfo.param.CreateApiInfoRequest;
import com.ai.slp.user.api.apiinfo.param.UcApiInfoParams;
import com.ai.slp.user.service.business.interfaces.IApiInfoBusiSV;
import com.ai.slp.user.util.DateUtils;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "/context/core-context.xml" })
public class ApiInfoSVImplTest {

    @Autowired
    private IApiInfoBusiSV iApiInfoBusiSV;

    // @Test
    public void insertApiInfoTest() {
        CreateApiInfoRequest request = new CreateApiInfoRequest();
        request.setApiInfo("test11111");
        request.setApiName("1111");
        request.setApiSeqId("2222");
        request.setApiType("00");
        request.setWebAddr("www.111.com");
        request.setCreateTime(DateUtils.currTimeStamp());
        request.setUserId(111);
        request.setCreateOperId("111");
        request.setTenantId("test111");
        request.setTenantPwd("123456");
        System.out.println(iApiInfoBusiSV.insertApiInfo(request).getResponseId());
    }

    // @Test
    public void updateApiInfoTest() {
        UcApiInfoParams request = new UcApiInfoParams();
        request.setApiKey("111");
        request.setSecretKey("222");
        request.setTenantId("test111");
        request.setUserId(111);
        request.setApiSeqId("1111");
        request.setUpdateOperId("111");

        iApiInfoBusiSV.updateApiInfo(request);
    }

    @Test
    public void queryApiInfoTest() {
        ApiInfoRequest request = new ApiInfoRequest();
        request.setTenantId("test111");
        request.setUserId(111);
        request.setPageNo(11);
        request.setPageSize(11);
        PageInfo<ApiInfoResponse> pageInfo = iApiInfoBusiSV.queryApiInfo(request);
        System.out.println(pageInfo.getCount());
        System.out.println("***************************************");
        System.out.println(pageInfo.getResult().size());
    }

}
