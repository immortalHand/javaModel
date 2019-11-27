package com.shop.modules.sys.service;

import com.baomidou.mybatisplus.service.IService;
import com.shop.common.utils.PageUtils;
import com.shop.common.utils.R;
import com.shop.modules.sys.dto.custom.SysUserDto;

import java.util.List;
import java.util.Map;


/**
 * 系统用户
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2016年9月18日 上午9:43:39
 */
public interface SysUserService extends IService<SysUserDto> {

	PageUtils queryPage(Map<String, Object> params);

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
	 * 根据用户名，查询系统用户
	 */
	SysUserDto queryByUserCode(String userCode);

	/**
	 * 保存用户
	 */
	R save(SysUserDto user) throws Exception;
	
	/**
	 * 修改用户
	 */
	void update(SysUserDto user) throws Exception;
	
	/**
	 * 删除用户
	 */
	void deleteBatch(Long[] userIds);

	/**
	 * 修改密码
	 * @param userId       用户ID
	 * @param password     原密码
	 * @param newPassword  新密码
	 */
	boolean updatePassword(Long userId, String password, String newPassword);

	List<SysUserDto> findPageInfo(SysUserDto sysUserDto);

	/**
	  * @Title 根据角色id查询用户信息
	  * @Description
	  * @author xruichang
	  * @date 2019年02月25日 17:21
	  * @version V1.0
	  * @param roleId
	  * @return java.util.List<io.piccsz.modules.sys.dto.custom.SysUserDto>
	  * @throws
	  */
	List<SysUserDto> findUserByRoleId(String roleId);

	/**
	  * @Title SysUserService
	  * @Description 根据用户ID查询出对应的项目名称
	  * @author xruichang
	  * @date 2019年02月25日 18:16
	  * @version V1.0
	  * @param userId
	  * @return java.lang.String
	  * @throws
	  */
	String findUserByVerifier(String userId);
}
