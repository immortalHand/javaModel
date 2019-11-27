package com.shop.modules.sys.dto.custom;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.shop.modules.sys.dto.domain.SysUserDtoBase;
import com.shop.modules.sys.dto.domain.SysUserDtoBase;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * 系统用户
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2019-02-23 14:16:59
 */
@TableName("sys_user")
public class SysUserDto extends SysUserDtoBase implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * 角色ID列表
	 */
	@TableField(exist=false)
	private List<Long> roleIdList;

	/**
	 * 部门名称
	 */
	@TableField(exist=false)
	private String deptName;

	/**
	 * 有效/失效翻译
	 */
	@TableField(exist=false)
	private String validIndName;

	/**
	 * 角色名称
	 */
	@TableField(exist=false)
	private String roleName;

	/**
	 * 开始日期
	 */
	@TableField(exist=false)
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
	private Date createdDateStart;

	/**
	 * 结束日期
	 */
	@TableField(exist=false)
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
	private Date createdDateEnd;

	/**
	 * 角色id
	 */
	@TableField(exist=false)
	private Integer roleId;

	/**
	 * 角色id
	 */
	@TableField(exist=false)
	private String projectName;

	public List<Long> getRoleIdList() {
		return roleIdList;
	}

	public void setRoleIdList(List<Long> roleIdList) {
		this.roleIdList = roleIdList;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public String getValidIndName() {
		return validIndName;
	}

	public void setValidIndName(String validIndName) {
		this.validIndName = validIndName;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public Date getCreatedDateStart() {
		return createdDateStart;
	}

	public void setCreatedDateStart(Date createdDateStart) {
		this.createdDateStart = createdDateStart;
	}

	public Date getCreatedDateEnd() {
		return createdDateEnd;
	}

	public void setCreatedDateEnd(Date createdDateEnd) {
		this.createdDateEnd = createdDateEnd;
	}

	public Integer getRoleId() {
		return roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
}
