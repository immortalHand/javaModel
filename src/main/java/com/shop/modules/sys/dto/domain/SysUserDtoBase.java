package com.shop.modules.sys.dto.domain;

import com.baomidou.mybatisplus.annotations.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.shop.common.dto.BaseDto;

import java.io.Serializable;
import java.util.Date;

/**
 * 系统用户
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2019-02-23 14:16:59
 */
public class SysUserDtoBase extends BaseDto implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 *
	 */
	@TableId
	private Long userId;
	/**
	 * 工号
	 */
	private String userCode;
	/**
	 * 用户名
	 */
	private String username;
	/**
	 * 密码
	 */
	private String password;
	/**
	 * 盐
	 */
	private String salt;
	/**
	 * 归属部门
	 */
	private String deptCode;
	/**
	 * 联系方式
	 */
	private String mobile;
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
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
	private Date createdDate;
	/**
	 * 更新人
	 */
	private String updatedUser;
	/**
	 * 更新时间
	 */
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
	private Date updatedDate;

	/**
	 * 设置：
	 */
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	/**
	 * 获取：
	 */
	public Long getUserId() {
		return userId;
	}
	/**
	 * 设置：工号
	 */
	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}
	/**
	 * 获取：工号
	 */
	public String getUserCode() {
		return userCode;
	}
	/**
	 * 设置：用户名
	 */
	public void setUsername(String username) {
		this.username = username;
	}
	/**
	 * 获取：用户名
	 */
	public String getUsername() {
		return username;
	}
	/**
	 * 设置：密码
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	/**
	 * 获取：密码
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * 设置：盐
	 */
	public void setSalt(String salt) {
		this.salt = salt;
	}
	/**
	 * 获取：盐
	 */
	public String getSalt() {
		return salt;
	}
	/**
	 * 设置：归属部门
	 */
	public void setDeptCode(String deptCode) {
		this.deptCode = deptCode;
	}
	/**
	 * 获取：归属部门
	 */
	public String getDeptCode() {
		return deptCode;
	}
	/**
	 * 设置：联系方式
	 */
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	/**
	 * 获取：联系方式
	 */
	public String getMobile() {
		return mobile;
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
