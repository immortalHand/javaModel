package com.shop.modules.sys.service;

import com.baomidou.mybatisplus.service.IService;
import com.shop.common.utils.PageUtils;
import com.shop.modules.sys.dto.custom.SysVisitDto;

import java.util.List;
import java.util.Map;

/**
 * 
 *
 * @author Generator
 * @date 2019-08-27 14:05:59
 */
public interface SysVisitService extends IService<SysVisitDto> {

    PageUtils queryPage(Map<String, Object> params);

    /**
     * @Desc 分页列表查询
     * @author Generator
     * @date 2019-08-27 14:05:59
     */
    public List<SysVisitDto> findPageInfo(SysVisitDto sysVisitDto);

    /**
     * 获取访问记录
     * @param s
     * @throws
     * @return java.lang.String
     * @author wpengfei
     * @date 2019/8/28 10:49
    */
    String getVisitLog(String s);
}

