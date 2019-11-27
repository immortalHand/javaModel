package com.shop.modules.sys.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.shop.common.exception.CustomException;
import com.shop.common.utils.*;
import com.shop.common.exception.CustomException;
import com.shop.common.exception.RRException;
import com.shop.common.utils.*;
import com.shop.modules.sys.dao.SysUserDao;
import com.shop.modules.sys.dto.custom.SysUserDto;
import com.shop.modules.sys.service.SysRoleService;
import com.shop.modules.sys.service.SysUserRoleService;
import com.shop.modules.sys.service.SysUserService;
import org.apache.commons.lang.RandomStringUtils;
import org.apache.commons.lang.StringUtils;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.crypto.hash.Sha256Hash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.tools.Tool;
import java.util.*;


/**
 * 系统用户
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2016年9月18日 上午9:46:09
 */
@Service("sysUserService")
public class SysUserServiceImpl extends ServiceImpl<SysUserDao, SysUserDto> implements SysUserService {
	@Autowired
	private SysUserRoleService sysUserRoleService;
	@Autowired
	private SysRoleService sysRoleService;
	@Autowired
	private SysUserDao sysUserDao;

	@Override
	public PageUtils queryPage(Map<String, Object> params) {
		String username = (String)params.get("username");
		Long createdUser = (Long)params.get("createdUser");

		Page<SysUserDto> page = this.selectPage(
				new Query<SysUserDto>(params).getPage(),
				new EntityWrapper<SysUserDto>()
						.like(StringUtils.isNotBlank(username),"username", username)
						.eq(createdUser != null,"created_user", createdUser)
		);

		return new PageUtils(page);
	}

	@Override
	public List<String> queryAllPerms(Long userId) {
		return baseMapper.queryAllPerms(userId);
	}

	@Override
	public List<Long> queryAllMenuId(Long userId) {
		return baseMapper.queryAllMenuId(userId);
	}

	@Override
	public SysUserDto queryByUserCode(String userCode) {
		return baseMapper.queryByUserCode(userCode);
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public R save(SysUserDto user) throws Exception {
		Wrapper<SysUserDto> userCode = new EntityWrapper<SysUserDto>().eq("user_code", user.getUserCode());
		SysUserDto sysUserDto = this.selectOne(userCode);
		if (ToolsUtils.notEmpty(sysUserDto)) {
			throw new CustomException("该用户工号已存在");
		}
		//设置创建信息与更新信息
		ToolsUtils.setUserAndDate(user);
		user.setValidInd(Constant.VALID_IND);
		//sha256加密
		String salt = RandomStringUtils.randomAlphanumeric(20);
		user.setPassword(new Sha256Hash(user.getPassword(), salt).toHex());
		user.setSalt(salt);
		this.insert(user);
		
		// 检查角色是否越权
		// checkRole(user);
		
		//保存用户与角色关系
		sysUserRoleService.saveOrUpdate(user.getUserId(), user.getRoleIdList());
		return R.ok("新增成功(insert success)");
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public void update(SysUserDto user) throws Exception {
		SysUserDto userTemp = sysUserDao.selectById(user.getUserId());
		if (userTemp.getPassword().equals(user.getPassword())) {

		} else {
			user.setPassword(new Sha256Hash(user.getPassword(), user.getSalt()).toHex());
		}
		this.updateById(user);
		
		// 检查角色是否越权
		// checkRole(user);
		
		//保存用户与角色关系
		sysUserRoleService.saveOrUpdate(user.getUserId(), user.getRoleIdList());
	}

	@Override
	public void deleteBatch(Long[] userId) {
		this.deleteBatchIds(Arrays.asList(userId));
	}

	@Override
	public boolean updatePassword(Long userId, String password, String newPassword) {
		SysUserDto userEntity = new SysUserDto();
		userEntity.setPassword(newPassword);
		return this.update(userEntity,
				new EntityWrapper<SysUserDto>().eq("user_id", userId).eq("password", password));
	}

	@Override
	public List<SysUserDto> findPageInfo(SysUserDto sysUserDto) {
		return sysUserDao.findPageInfo(sysUserDto);
	}

	@Override
	public List<SysUserDto> findUserByRoleId(String roleId) {
		return sysUserDao.findUserByRoleId(roleId);
	}

	@Override
	public String findUserByVerifier(String userId) {
		return sysUserDao.findUserByVerifier(userId);
	}

	/**
	 * 检查角色是否越权
	 */
	private void checkRole(SysUserDto user){
		if(user.getRoleIdList() == null || user.getRoleIdList().size() == 0){
			return;
		}
		
		//查询用户创建的角色列表
		List<Long> roleIdList = sysRoleService.queryRoleIdList(Long.valueOf(user.getCreatedUser()));

		//判断是否越权
		/*if(!roleIdList.containsAll(user.getRoleIdList())){
			throw new RRException("新增用户所选角色，不是本人创建");
		}*/
	}
}
