package com.imooc.entity;

import java.util.Date;

import javax.validation.constraints.Min;

import com.alibaba.fastjson.annotation.JSONField;


public class TArea {

	private Integer areaId;
	@JSONField(name="name")
	private String areaName;
	@JSONField(name="priority")
	@Min(value=1, message="优先级取值需要大于0")
	private Integer priority;
	private Date createTime;
	private Date lastEditTime;
	
	public Integer getAreaId() {
		return areaId;
	}
	public void setAreaId(Integer areaId) {
		this.areaId = areaId;
	}
	public String getAreaName() {
		return areaName;
	}
	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}
	public Integer getPriority() {
		return priority;
	}
	public void setPriority(Integer priority) {
		this.priority = priority;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public Date getLastEditTime() {
		return lastEditTime;
	}
	public void setLastEditTime(Date lastEditTime) {
		this.lastEditTime = lastEditTime;
	}
}
