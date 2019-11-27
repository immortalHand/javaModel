package com.shop.modules.sys.service;


import com.shop.modules.sys.dto.custom.SysUserDto;
import com.shop.modules.sys.dto.custom.SysUserTokenDto;

import java.util.Set;

/**
 * shiro相关接口
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2017-06-06 8:49
 */
public interface ShiroService {
    /**
     * 获取用户权限列表
     */
    Set<String> getUserPermissions(long userId);

    SysUserTokenDto queryByToken(String token);

    /**
     * 根据用户ID，查询用户
     * @param userId
     */
    SysUserDto queryUser(Long userId);
}
