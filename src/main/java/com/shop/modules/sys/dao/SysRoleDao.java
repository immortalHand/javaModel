package com.shop.modules.sys.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.shop.modules.sys.dto.custom.SysRoleDto;
import com.shop.modules.sys.dto.custom.SysRoleDto;
import com.shop.modules.sys.dto.custom.SysRoleDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 角色管理
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2016年9月18日 上午9:33:33
 */
@Mapper
public interface SysRoleDao extends BaseMapper<SysRoleDto> {
	
	/**
	 * 查询用户创建的角色ID列表
	 */
	List<Long> queryRoleIdList(Long userId);
}
