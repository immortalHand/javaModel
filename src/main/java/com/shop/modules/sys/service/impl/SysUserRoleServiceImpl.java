package com.shop.modules.sys.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.shop.common.utils.Constant;
import com.shop.common.utils.MapUtils;
import com.shop.common.utils.ToolsUtils;
import com.shop.common.utils.Constant;
import com.shop.common.utils.MapUtils;
import com.shop.common.utils.ToolsUtils;
import com.shop.modules.sys.dao.SysUserRoleDao;
import com.shop.modules.sys.dto.custom.SysUserRoleDto;
import com.shop.modules.sys.service.SysUserRoleService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;



/**
 * 用户与角色对应关系
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2016年9月18日 上午9:45:48
 */
@Service("sysUserRoleService")
public class SysUserRoleServiceImpl extends ServiceImpl<SysUserRoleDao, SysUserRoleDto> implements SysUserRoleService {

	@Override
	public void saveOrUpdate(Long userId, List<Long> roleIdList) throws Exception {
		//先删除用户与角色关系
		List<SysUserRoleDto> sysUserRoleList = this.selectByMap(new MapUtils().put("user_id", userId));
		for (SysUserRoleDto sysUserRoleDto : sysUserRoleList) {
			sysUserRoleDto.setValidInd(Constant.UN_VALID_IND);
			sysUserRoleDto.setOperateStatus(Constant.DELETE_STATUS);
			ToolsUtils.setUserAndDate(sysUserRoleDto);
		}
		//逻辑删除角色用户关联
		if (ToolsUtils.notEmpty(sysUserRoleList)) {
			this.updateBatchById(sysUserRoleList);
		}

		if(roleIdList == null || roleIdList.size() == 0){
			return ;
		}

		//保存用户与角色关系
		List<SysUserRoleDto> list = new ArrayList<>(roleIdList.size());
		for(Long roleId : roleIdList){
			SysUserRoleDto sysUserRoleDto = new SysUserRoleDto();
			sysUserRoleDto.setUserId(userId);
			sysUserRoleDto.setRoleId(roleId);
			ToolsUtils.setUserAndDate(sysUserRoleDto);
			list.add(sysUserRoleDto);
		}
		this.insertBatch(list);
	}

	@Override
	public List<Long> queryRoleIdList(Long userId) {
		return baseMapper.queryRoleIdList(userId);
	}

	@Override
	public int deleteBatch(Long[] roleIds){
		return baseMapper.deleteBatch(roleIds);
	}
}
