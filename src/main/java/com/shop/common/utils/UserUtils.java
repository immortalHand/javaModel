package com.shop.common.utils;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.shop.modules.sys.dto.custom.SysRoleDto;
import com.shop.modules.sys.dto.custom.SysUserDto;
import com.shop.modules.sys.dto.custom.SysUserRoleDto;
import com.shop.modules.sys.service.SysRoleService;
import com.shop.modules.sys.service.SysUserRoleService;
import com.shop.modules.sys.dto.custom.SysRoleDto;
import com.shop.modules.sys.dto.custom.SysUserDto;
import com.shop.modules.sys.dto.custom.SysUserRoleDto;
import com.shop.modules.sys.service.SysRoleService;
import com.shop.modules.sys.service.SysUserRoleService;
import org.apache.shiro.SecurityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @Desc 获取user工具包
 * @Author sinosoft-an
 * @Date 2019/2/24 12:01
 */
@Component
public class UserUtils {

    public Logger logger = LoggerFactory.getLogger(getClass());

    public SysUserDto getUser() {
        return (SysUserDto) SecurityUtils.getSubject().getPrincipal();
    }

    public Long getUserId() {
        return getUser().getUserId();
    }

    public String getUserCode() {
        return getUser().getUserCode();
    }

    @Autowired
    private SysUserRoleService sysUserRoleService;

    @Autowired
    private SysRoleService sysRoleService;

    /**
     * 判断当前用户是否系统管理员
     * @param
     * @return java.lang.Boolean
     * @author Wang926454
     * @date 2019/3/14 19:13
     */
    public Boolean isSysTemRole () {
        // 判断当前用户是否系统管理员，为系统管理员就不设定当前用户条件查询限制
        boolean flag = true;
        // 查询当前用户下的所有角色
        List<SysUserRoleDto> sysUserRoleDtoList = sysUserRoleService.selectList(new EntityWrapper<SysUserRoleDto>()
                .eq("user_id", getUserId())
                .eq("valid_ind", Constant.VALID_IND));
        // 查询系统管理员角色ID
        SysRoleDto sysRoleDto = sysRoleService.selectOne(new EntityWrapper<SysRoleDto>()
                .eq("role_name", Constant.SYSTEM_ROLE_NAME));
        if (sysRoleDto != null) {
            // 查看当前用户是否存在系统管理员角色
            for (SysUserRoleDto sysUserRoleDto : sysUserRoleDtoList) {
                if (sysRoleDto.getRoleId().equals(sysUserRoleDto.getRoleId())) {
                    flag = false;
                }
            }
        }
        return flag;
    }

}
