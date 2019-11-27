package com.shop.modules.sys.service.impl;

import com.shop.modules.sys.dao.SysVisitDao;
import com.shop.modules.sys.dto.custom.SysVisitDto;
import com.shop.modules.sys.service.SysVisitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.shop.common.utils.PageUtils;
import com.shop.common.utils.Query;



@Service("sysVisitService")
public class SysVisitServiceImpl extends ServiceImpl<SysVisitDao, SysVisitDto> implements SysVisitService {

    @Autowired
    private SysVisitDao sysVisitDao;

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<SysVisitDto> page = this.selectPage(
                new Query<SysVisitDto>(params).getPage(),
                new EntityWrapper<SysVisitDto>()
        );
        return new PageUtils(page);
    }

    /**
     * @Desc 分页列表查询
     * @author Generator
     * @date 2019-08-27 14:05:59
     */
    @Override
    public List<SysVisitDto> findPageInfo(SysVisitDto sysVisitDto){
          return sysVisitDao.findPageInfo(sysVisitDto);
    }


    @Override
    public String getVisitLog(String s) {
        String visitLog = "";
        if("1".equals(s) || "2".equals(s)){
            visitLog = sysVisitDao.getVisitNumLog(s);
        }else{
            visitLog = sysVisitDao.getVisitAddLog(s);
        }
        return visitLog;
    }

}
