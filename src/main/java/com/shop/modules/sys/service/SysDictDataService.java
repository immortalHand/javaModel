package com.shop.modules.sys.service;

import com.baomidou.mybatisplus.service.IService;
import com.shop.common.utils.PageUtils;
import com.shop.modules.sys.dto.custom.SysDictDataDto;

import java.util.Map;

/**
 * 字典数据表
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2019-02-23 16:16:05
 */
public interface SysDictDataService extends IService<SysDictDataDto> {

    PageUtils queryPage(Map<String, Object> params);
}

