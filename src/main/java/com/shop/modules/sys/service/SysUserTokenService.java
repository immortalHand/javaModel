package com.shop.modules.sys.service;

import com.baomidou.mybatisplus.service.IService;
import com.shop.common.utils.R;
import com.shop.modules.sys.dto.custom.SysUserTokenDto;

/**
 * 用户Token
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2017-03-23 15:22:07
 */
public interface SysUserTokenService extends IService<SysUserTokenDto> {

	/**
	 * 生成token
	 * @param userId  用户ID
	 */
	R createToken(long userId);

	/**
	 * 退出，修改token值
	 * @param userId  用户ID
	 */
	void logout(long userId);

}
