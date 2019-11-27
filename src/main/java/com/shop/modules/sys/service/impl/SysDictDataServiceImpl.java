package com.shop.modules.sys.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.shop.common.utils.PageUtils;
import com.shop.common.utils.Query;
import com.shop.modules.sys.dao.SysDictDataDao;
import com.shop.modules.sys.dto.custom.SysDictDataDto;
import com.shop.modules.sys.service.SysDictDataService;
import org.springframework.stereotype.Service;

import java.util.Map;


@Service("sysDicdataService")
public class SysDictDataServiceImpl extends ServiceImpl<SysDictDataDao, SysDictDataDto> implements SysDictDataService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<SysDictDataDto> page = this.selectPage(
                new Query<SysDictDataDto>(params).getPage(),
                new EntityWrapper<SysDictDataDto>()
        );

        return new PageUtils(page);
    }

}
