package com.shop.modules.sys.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.shop.modules.sys.dao.SysRoleMenuDao;
import com.shop.modules.sys.dto.custom.SysRoleMenuDto;
import com.shop.modules.sys.dto.custom.SysUserDto;
import com.shop.modules.sys.service.SysRoleMenuService;
import org.apache.shiro.SecurityUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;



/**
 * 角色与菜单对应关系
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2016年9月18日 上午9:44:35
 */
@Service("sysRoleMenuService")
public class SysRoleMenuServiceImpl extends ServiceImpl<SysRoleMenuDao, SysRoleMenuDto> implements SysRoleMenuService {

	@Override
	@Transactional(rollbackFor = Exception.class)
	public void saveOrUpdate(Long roleId, List<Long> menuIdList) {
		//先删除角色与菜单关系
		deleteBatch(new Long[]{roleId});

		if(menuIdList.size() == 0){
			return ;
		}

		SysUserDto userDto = (SysUserDto) SecurityUtils.getSubject().getPrincipal();
		//保存角色与菜单关系
		List<SysRoleMenuDto> list = new ArrayList<>(menuIdList.size());
		for(Long menuId : menuIdList){
			SysRoleMenuDto sysRoleMenuEntity = new SysRoleMenuDto();
			sysRoleMenuEntity.setMenuId(menuId);
			sysRoleMenuEntity.setRoleId(roleId);
			sysRoleMenuEntity.setCreatedUser(userDto.getUserId().toString());
			sysRoleMenuEntity.setCreatedDate(new Date());
			sysRoleMenuEntity.setUpdatedUser(userDto.getUserId().toString());
			sysRoleMenuEntity.setUpdatedDate(new Date());
			list.add(sysRoleMenuEntity);
		}
		this.insertBatch(list);
	}

	@Override
	public List<Long> queryMenuIdList(Long roleId) {
		return baseMapper.queryMenuIdList(roleId);
	}

	@Override
	public int deleteBatch(Long[] roleIds){
		return baseMapper.deleteBatch(roleIds);
	}

}
