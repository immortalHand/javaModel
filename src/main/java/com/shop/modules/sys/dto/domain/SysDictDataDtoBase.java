package com.shop.modules.sys.dto.domain;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.shop.common.dto.BaseDto;

import java.io.Serializable;
import java.util.Date;

/**
 * 字典数据表
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2019-02-23 16:16:05
 */
public class SysDictDataDtoBase extends BaseDto implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 字典编码
	 */
	@TableId
	private Long dictCode;
	/**
	 * 字典类型
	 */
	private String dictType;
	/**
	 * 备注
	 */
	private String remark;
	/**
	 * 字典键值
	 */
	private String dictValue;
	/**
	 * 字典排序
	 */
	private Integer dictSort;
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
	 * 设置：字典编码
	 */
	public void setDictCode(Long dictCode) {
		this.dictCode = dictCode;
	}
	/**
	 * 获取：字典编码
	 */
	public Long getDictCode() {
		return dictCode;
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
	/**
	 * 设置：字典键值
	 */
	public void setDictValue(String dictValue) {
		this.dictValue = dictValue;
	}
	/**
	 * 获取：字典键值
	 */
	public String getDictValue() {
		return dictValue;
	}
	/**
	 * 设置：字典排序
	 */
	public void setDictSort(Integer dictSort) {
		this.dictSort = dictSort;
	}
	/**
	 * 获取：字典排序
	 */
	public Integer getDictSort() {
		return dictSort;
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
}
