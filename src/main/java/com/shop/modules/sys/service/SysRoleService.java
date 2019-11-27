package com.shop.modules.sys.service;

import com.baomidou.mybatisplus.service.IService;
import com.shop.common.utils.PageUtils;
import com.shop.modules.sys.dto.custom.SysRoleDto;

import java.util.List;
import java.util.Map;


/**
 * 角色
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2016年9月18日 上午9:42:52
 */
public interface SysRoleService extends IService<SysRoleDto> {

	PageUtils queryPage(Map<String, Object> params);

	void save(SysRoleDto role);

	void update(SysRoleDto role);

	void deleteBatch(Long[] roleIds);

	
	/**
	 * 查询用户创建的角色ID列表
	 */
	List<Long> queryRoleIdList(Long createUserId);
}
