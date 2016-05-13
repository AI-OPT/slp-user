package com.ai.slp.user.api.ucTelGroupInfo.param;
import java.io.Serializable;
import java.util.Date;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.ai.opt.base.vo.BaseInfo;
import com.ai.slp.user.api.ucTelGroupInfo.interfaces.IUcTelGroupSV;




public class UcTelGroupParamsRequest extends BaseInfo implements Serializable{
	private static final long serialVersionUID = 1L;

	
	/**
	 * 用户ID
	 */
	@NotNull(message="用户ID不能为空",groups={IUcTelGroupSV.InsertUcTelGroupInfo.class,IUcTelGroupSV.UpdateGroupInfo.class})
    @Size(max=18,groups={IUcTelGroupSV.InsertUcTelGroupInfo.class,IUcTelGroupSV.UpdateGroupInfo.class})
	private String userId;
	
	/**
	 * 通讯录组ID
	 */
	@NotNull(message="通讯录组ID不能为空",groups={IUcTelGroupSV.InsertUcTelGroupInfo.class,IUcTelGroupSV.UpdateGroupInfo.class})
    @Size(max=32,groups={IUcTelGroupSV.InsertUcTelGroupInfo.class,IUcTelGroupSV.UpdateGroupInfo.class})
	private String telGroupId;
	
	/**
	 * 序号
	 */
    @Size(max=10,groups={IUcTelGroupSV.InsertUcTelGroupInfo.class,IUcTelGroupSV.UpdateGroupInfo.class})
	private long seq;
	
    /**
     * 通讯录名称
     */
    @NotNull(message="通讯录组NAME不能为空",groups={IUcTelGroupSV.InsertUcTelGroupInfo.class,IUcTelGroupSV.UpdateGroupInfo.class})
    @Size(max=128,groups={IUcTelGroupSV.InsertUcTelGroupInfo.class,IUcTelGroupSV.UpdateGroupInfo.class})
	private String telGroupName;
    
    /**
     * 创建渠道 
     */
    @Size(max=7,groups={IUcTelGroupSV.InsertUcTelGroupInfo.class,IUcTelGroupSV.UpdateGroupInfo.class})
    private String createChlId;
    
    /**
     * 创建员工
     */
    @Size(max=10,groups={IUcTelGroupSV.InsertUcTelGroupInfo.class,IUcTelGroupSV.UpdateGroupInfo.class})
    private long createOperId;
    
    
    /**
     * 创建渠道
     */
    @Size(max=7,groups={IUcTelGroupSV.InsertUcTelGroupInfo.class,IUcTelGroupSV.UpdateGroupInfo.class})
    private String updateChlId;
    
    /**
     * 创建员工
     */
    @Size(max=10,groups={IUcTelGroupSV.InsertUcTelGroupInfo.class,IUcTelGroupSV.UpdateGroupInfo.class})
    private long updateOperId;


    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getTelGroupId() {
		return telGroupId;
	}

	public void setTelGroupId(String telGroupId) {
		this.telGroupId = telGroupId;
	}

	public long getSeq() {
		return seq;
	}

	public void setSeq(long seq) {
		this.seq = seq;
	}

	public String getTelGroupName() {
		return telGroupName;
	}

	public void setTelGroupName(String telGroupName) {
		this.telGroupName = telGroupName;
	}


	public String getCreateChlId() {
		return createChlId;
	}

	public void setCreateChlId(String createChlId) {
		this.createChlId = createChlId;
	}

	public long getCreateOperId() {
		return createOperId;
	}

	public void setCreateOperId(long createOperId) {
		this.createOperId = createOperId;
	}


	public String getUpdateChlId() {
		return updateChlId;
	}

	public void setUpdateChlId(String updateChlId) {
		this.updateChlId = updateChlId;
	}

	public long getUpdateOperId() {
		return updateOperId;
	}

	public void setUpdateOperId(long updateOperId) {
		this.updateOperId = updateOperId;
	}
}
