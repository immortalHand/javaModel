package com.shop.modules.sys.dto.custom;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.shop.modules.sys.dto.domain.SysRoleDtoBase;
import com.shop.modules.sys.dto.domain.SysRoleDtoBase;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * 角色
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2019-02-23 14:16:59
 */
@TableName("sys_role")
public class SysRoleDto extends SysRoleDtoBase implements Serializable {

	private static final long serialVersionUID = 1L;

	@TableField(exist=false)
	private List<Long> menuIdList;

	public List<Long> getMenuIdList() {
		return menuIdList;
	}

	public void setMenuIdList(List<Long> menuIdList) {
		this.menuIdList = menuIdList;
	}
}
