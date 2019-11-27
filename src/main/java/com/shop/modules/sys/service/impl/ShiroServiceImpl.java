package com.shop.modules.sys.service.impl;

import com.shop.common.utils.Constant;
import com.shop.common.utils.Constant;
import com.shop.modules.sys.dao.SysMenuDao;
import com.shop.modules.sys.dao.SysUserDao;
import com.shop.modules.sys.dao.SysUserTokenDao;
import com.shop.modules.sys.dto.custom.SysMenuDto;
import com.shop.modules.sys.dto.custom.SysUserDto;
import com.shop.modules.sys.dto.custom.SysUserTokenDto;
import com.shop.modules.sys.service.ShiroService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ShiroServiceImpl implements ShiroService {
    @Autowired
    private SysMenuDao sysMenuDao;
    @Autowired
    private SysUserDao sysUserDao;
    @Autowired
    private SysUserTokenDao sysUserTokenDao;

    @Override
    public Set<String> getUserPermissions(long userId) {
        List<String> permsList;

        //系统管理员，拥有最高权限
        if(Constant.SUPER_ADMIN == userId){
            List<SysMenuDto> menuList = sysMenuDao.selectList(null);
            permsList = new ArrayList<>(menuList.size());
            for(SysMenuDto menu : menuList){
                permsList.add(menu.getPerms());
            }
        }else{
            permsList = sysUserDao.queryAllPerms(userId);
        }
        //用户权限列表
        Set<String> permsSet = new HashSet<>();
        for(String perms : permsList){
            if(StringUtils.isBlank(perms)){
                continue;
            }
            permsSet.addAll(Arrays.asList(perms.trim().split(",")));
        }
        return permsSet;
    }

    @Override
    public SysUserTokenDto queryByToken(String token) {
        return sysUserTokenDao.queryByToken(token);
    }

    @Override
    public SysUserDto queryUser(Long userId) {
        return sysUserDao.selectById(userId);
    }
}
