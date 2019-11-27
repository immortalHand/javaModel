package com.shop.modules.sys.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.shop.modules.sys.dto.custom.SysUserTokenDto;
import com.shop.modules.sys.dto.custom.SysUserTokenDto;
import com.shop.modules.sys.dto.custom.SysUserTokenDto;
import org.apache.ibatis.annotations.Mapper;

/**
 * 系统用户Token
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2017-03-23 15:22:07
 */
@Mapper
public interface SysUserTokenDao extends BaseMapper<SysUserTokenDto> {

    SysUserTokenDto queryByToken(String token);
	
}
