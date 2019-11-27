package com.shop.modules.sys.dto.custom;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import com.shop.modules.sys.dto.domain.SysUserTokenDtoBase;
import com.shop.modules.sys.dto.domain.SysUserTokenDtoBase;

import java.io.Serializable;
import java.util.Date;


/**
 * 系统用户Token
 */
@TableName("sys_user_token")
public class SysUserTokenDto extends SysUserTokenDtoBase implements Serializable {

	private static final long serialVersionUID = 1L;
	

}
