package com.shop.modules.sys.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.shop.modules.sys.dto.custom.SysUserDto;
import com.shop.modules.sys.dto.custom.SysUserDto;
import com.shop.modules.sys.dto.custom.SysUserDto;
import io.swagger.models.auth.In;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 系统用户
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2016年9月18日 上午9:34:11
 */
@Mapper
public interface SysUserDao extends BaseMapper<SysUserDto> {
	
	/**
	 * 查询用户的所有权限
	 * @param userId  用户ID
	 */
	List<String> queryAllPerms(Long userId);
	
	/**
	 * 查询用户的所有菜单ID
	 */
	List<Long> queryAllMenuId(Long userId);
	
	/**
	 * 根据用户工号，查询系统用户
	 */
	SysUserDto queryByUserCode(String userCode);

	List<SysUserDto> findPageInfo(SysUserDto sysUserDto);

	List<SysUserDto> findUserByRoleId(String roleId);

	String findUserByVerifier(String userId);

}
