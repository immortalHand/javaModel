package com.shop.modules.sys.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.shop.common.exception.RRException;
import com.shop.common.utils.Constant;
import com.shop.common.utils.PageUtils;
import com.shop.common.utils.Query;
import com.shop.common.exception.RRException;
import com.shop.common.utils.Constant;
import com.shop.common.utils.PageUtils;
import com.shop.common.utils.Query;
import com.shop.modules.sys.dao.SysRoleDao;
import com.shop.modules.sys.dto.custom.SysMenuDto;
import com.shop.modules.sys.dto.custom.SysRoleDto;
import com.shop.modules.sys.service.SysRoleMenuService;
import com.shop.modules.sys.service.SysRoleService;
import com.shop.modules.sys.service.SysUserRoleService;
import com.shop.modules.sys.service.SysUserService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 角色
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2016年9月18日 上午9:45:12
 */
@Service("sysRoleService")
public class SysRoleServiceImpl extends ServiceImpl<SysRoleDao, SysRoleDto> implements SysRoleService {
	@Autowired
	private SysRoleMenuService sysRoleMenuService;
	@Autowired
	private SysUserService sysUserService;
    @Autowired
    private SysUserRoleService sysUserRoleService;

	@Override
	public PageUtils queryPage(Map<String, Object> params) {
		String roleName = (String)params.get("roleName");
		String roleId = (String)params.get("roleId");
		Long createdUser = (Long)params.get("createdUser");
		// .eq(StringUtils.isNotBlank(createdUser.toString()),"created_user",createdUser)

		Page<SysRoleDto> page = this.selectPage(
				new Query<SysRoleDto>(params).getPage(),
				new EntityWrapper<SysRoleDto>()
						.like(StringUtils.isNotBlank(roleName),"role_name", roleName).eq(StringUtils.isNotBlank(roleId),"role_id",roleId)
		);

		return new PageUtils(page);
	}

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void save(SysRoleDto role) {
        role.setCreatedDate(new Date());
        this.insert(role);

        //检查权限是否越权
        checkPrems(role);

        //保存角色与菜单关系
        sysRoleMenuService.saveOrUpdate(role.getRoleId(), role.getMenuIdList());
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void update(SysRoleDto role) {
        this.updateById(role);

        //检查权限是否越权
        checkPrems(role);

        //更新角色与菜单关系
        sysRoleMenuService.saveOrUpdate(role.getRoleId(), role.getMenuIdList());
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void deleteBatch(Long[] roleIds) {
        //删除角色
        this.deleteBatchIds(Arrays.asList(roleIds));

        //删除角色与菜单关联
        sysRoleMenuService.deleteBatch(roleIds);

        //删除角色与用户关联
        sysUserRoleService.deleteBatch(roleIds);
    }


    @Override
	public List<Long> queryRoleIdList(Long createUserId) {
		return baseMapper.queryRoleIdList(createUserId);
	}

	/**
	 * 检查权限是否越权
	 */
	private void checkPrems(SysRoleDto role){
		//如果不是超级管理员，则需要判断角色的权限是否超过自己的权限
		if(Constant.SUPER_ADMIN == Integer.valueOf(role.getCreatedUser())){
			return ;
		}
		
		//查询用户所拥有的菜单列表
		List<Long> menuIdList = sysUserService.queryAllMenuId(Long.valueOf(role.getCreatedUser()));
		
		//判断是否越权
		if(!menuIdList.containsAll(role.getMenuIdList())){
			throw new RRException("新增角色的权限，已超出你的权限范围");
		}
	}
}
