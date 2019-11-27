package com.shop.modules.sys.dto.domain;

import com.baomidou.mybatisplus.annotations.TableId;
import com.shop.common.dto.BaseDto;

import java.io.Serializable;
import java.util.Date;

/**
 * 字典类型表
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2019-02-23 16:16:05
 */
public class SysDictTypeDtoBase extends BaseDto implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 字典主键
	 */
	@TableId
	private Long dictId;
	/**
	 * 字典名称
	 */
	private String dictName;
	/**
	 * 字典类型
	 */
	private String dictType;
	/**
	 * 操作状态（1-正常，0-删除）
	 */
	private String operateStatus;
	/**
	 * 有效状态
	 */
	private String validInd;
	/**
	 * 创建人
	 */
	private String createdUser;
	/**
	 * 创建时间
	 */
	private Date createdDate;
	/**
	 * 更新人
	 */
	private String updatedUser;
	/**
	 * 更新时间
	 */
	private Date updatedDate;
	/**
	 * 备注
	 */
	private String remark;

	/**
	 * 设置：字典主键
	 */
	public void setDictId(Long dictId) {
		this.dictId = dictId;
	}
	/**
	 * 获取：字典主键
	 */
	public Long getDictId() {
		return dictId;
	}
	/**
	 * 设置：字典名称
	 */
	public void setDictName(String dictName) {
		this.dictName = dictName;
	}
	/**
	 * 获取：字典名称
	 */
	public String getDictName() {
		return dictName;
	}
	/**
	 * 设置：字典类型
	 */
	public void setDictType(String dictType) {
		this.dictType = dictType;
	}
	/**
	 * 获取：字典类型
	 */
	public String getDictType() {
		return dictType;
	}
	/**
	 * 设置：操作状态（1-正常，0-删除）
	 */
	public void setOperateStatus(String operateStatus) {
		this.operateStatus = operateStatus;
	}
	/**
	 * 获取：操作状态（1-正常，0-删除）
	 */
	public String getOperateStatus() {
		return operateStatus;
	}
	/**
	 * 设置：有效状态
	 */
	public void setValidInd(String validInd) {
		this.validInd = validInd;
	}
	/**
	 * 获取：有效状态
	 */
	public String getValidInd() {
		return validInd;
	}
	/**
	 * 设置：创建人
	 */
	public void setCreatedUser(String createdUser) {
		this.createdUser = createdUser;
	}
	/**
	 * 获取：创建人
	 */
	public String getCreatedUser() {
		return createdUser;
	}
	/**
	 * 设置：创建时间
	 */
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	/**
	 * 获取：创建时间
	 */
	public Date getCreatedDate() {
		return createdDate;
	}
	/**
	 * 设置：更新人
	 */
	public void setUpdatedUser(String updatedUser) {
		this.updatedUser = updatedUser;
	}
	/**
	 * 获取：更新人
	 */
	public String getUpdatedUser() {
		return updatedUser;
	}
	/**
	 * 设置：更新时间
	 */
	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}
	/**
	 * 获取：更新时间
	 */
	public Date getUpdatedDate() {
		return updatedDate;
	}
	/**
	 * 设置：备注
	 */
	public void setRemark(String remark) {
		this.remark = remark;
	}
	/**
	 * 获取：备注
	 */
	public String getRemark() {
		return remark;
	}
}
