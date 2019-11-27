package com.shop.modules.sys.dao;

import com.shop.modules.sys.dto.custom.SysDictDataDto;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.shop.modules.sys.dto.custom.SysDictDataDto;
import org.apache.ibatis.annotations.Mapper;

/**
 * 字典数据表
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2019-02-23 16:16:05
 */
@Mapper
public interface SysDictDataDao extends BaseMapper<SysDictDataDto> {
	
}
