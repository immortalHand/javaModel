package com.shop.modules.sys.dto.custom;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.shop.modules.sys.dto.domain.SysMenuDtoBase;
import com.shop.modules.sys.dto.domain.SysMenuDtoBase;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * 菜单管理
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2019-02-23 14:16:59
 */
@TableName("sys_menu")
public class SysMenuDto extends SysMenuDtoBase implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * 父菜单名称
	 */
	@TableField(exist=false)
	private String parentName;

	/**
	 * ztree属性
	 */
	@TableField(exist=false)
	private Boolean open;

	@TableField(exist=false)
	private List<?> list;

	public String getParentName() {
		return parentName;
	}

	public void setParentName(String parentName) {
		this.parentName = parentName;
	}

	public Boolean getOpen() {
		return open;
	}

	public void setOpen(Boolean open) {
		this.open = open;
	}

	public List<?> getList() {
		return list;
	}

	public void setList(List<?> list) {
		this.list = list;
	}
}
