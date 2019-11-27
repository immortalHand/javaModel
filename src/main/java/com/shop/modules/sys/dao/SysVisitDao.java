package com.shop.modules.sys.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.shop.modules.sys.dto.custom.SysVisitDto;
import com.shop.modules.sys.dto.custom.SysVisitDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 
 *
 * @author Generator
 * @date 2019-08-27 14:05:59
 */
@Mapper
public interface SysVisitDao extends BaseMapper<SysVisitDto> {

    /**
     * @Desc 分页列表查询
     * @author Generator
     * @date 2019-08-27 14:05:59
     */
    public List<SysVisitDto> findPageInfo(SysVisitDto sysVisitDto);

    /**
     *  获取访问记录
     * @param s
     * @throws
     * @return java.lang.String
     * @author wpengfei
     * @date 2019/8/28 10:52
    */
    String getVisitNumLog(@Param("s") String s);

    /**
     * 获取新增记录
     * @param s
     * @throws
     * @return java.lang.String
     * @author wpengfei
     * @date 2019/8/28 11:11
    */
    String getVisitAddLog(@Param("s") String s);
}
