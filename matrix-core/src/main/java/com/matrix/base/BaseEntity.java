package com.matrix.base;

import java.io.Serializable;
import java.util.Date;

import com.matrix.pojo.view.McUserInfoView;

/**
 * @description: 实体类基础类
 *
 * @author Yangcl
 * @home https://github.com/PowerYangcl
 * @date 2018年7月25日 下午2:16:57 
 * @version 1.0.0.1
 */
public class BaseEntity implements Serializable {

	private static final long serialVersionUID = -7383391444275138625L;

	/** 
	 * 起始页数 - 微服务化项目需要的字段
	 */
	private Integer startIndex = 1;
	
	/**
	 *  分页记录数 - 微服务化项目需要的字段
	 */
	private Integer pageSize = 10;
	
	
	/**
	 *  动态列表排序依据，比如：dto.setOrder("create_time");
	 */
	private String orderBy = null;
	
	private Date createTime;
	private Long createUserId;
	private String createUserName;
	private Date updateTime;
	private Long updateUserId;
	private String updateUserName;
	private Integer deleteFlag;               // 0 删除 | 1 未删除 数据库记录默认未删除
	
	private McUserInfoView userCache ;

	/*
	* 分布式事务 xid
	* */
	private String commodityCode;

	public McUserInfoView getUserCache() {
		return userCache;
	}
	public void setUserCache(McUserInfoView userCache) {
		this.userCache = userCache;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public Long getCreateUserId() {
		return createUserId;
	}
	public void setCreateUserId(Long createUserId) {
		this.createUserId = createUserId;
	}
	public String getCreateUserName() {
		return createUserName;
	}
	public void setCreateUserName(String createUserName) {
		this.createUserName = createUserName;
	}
	public Date getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	public Long getUpdateUserId() {
		return updateUserId;
	}
	public void setUpdateUserId(Long updateUserId) {
		this.updateUserId = updateUserId;
	}
	public String getUpdateUserName() {
		return updateUserName;
	}
	public void setUpdateUserName(String updateUserName) {
		this.updateUserName = updateUserName;
	}
	public Integer getDeleteFlag() {
		return deleteFlag;
	}
	public void setDeleteFlag(Integer deleteFlag) {
		this.deleteFlag = deleteFlag;
	}
	public Integer getStartIndex() {
		return startIndex;
	}
	public void setStartIndex(Integer startIndex) {
		this.startIndex = startIndex;
	}
	public Integer getPageSize() {
		return pageSize;
	}
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
	public String getOrderBy() {
		return orderBy;
	}
	public void setOrderBy(String orderBy) {
		this.orderBy = orderBy;
	}
	public String getCommodityCode() {
		return commodityCode;
	}
	public void setCommodityCode(String commodityCode) {
		this.commodityCode = commodityCode;
	}
}
