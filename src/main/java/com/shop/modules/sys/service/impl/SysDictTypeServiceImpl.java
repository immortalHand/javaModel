package com.shop.modules.sys.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.shop.common.utils.PageUtils;
import com.shop.common.utils.Query;
import com.shop.common.utils.PageUtils;
import com.shop.common.utils.Query;
import com.shop.modules.sys.dao.SysDictTypeDao;
import com.shop.modules.sys.dto.custom.SysDictTypeDto;
import com.shop.modules.sys.service.SysDictTypeService;
import org.springframework.stereotype.Service;

import java.util.Map;


@Service("sysDictypeService")
public class SysDictTypeServiceImpl extends ServiceImpl<SysDictTypeDao, SysDictTypeDto> implements SysDictTypeService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<SysDictTypeDto> page = this.selectPage(
                new Query<SysDictTypeDto>(params).getPage(),
                new EntityWrapper<SysDictTypeDto>()
        );

        return new PageUtils(page);
    }

}
