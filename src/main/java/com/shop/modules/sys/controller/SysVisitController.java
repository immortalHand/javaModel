package com.shop.modules.sys.controller;

import java.util.*;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.shop.common.utils.HttpUtils;
import com.shop.common.utils.IPUtils;
import com.shop.modules.sys.dto.custom.SysVisitDto;
import com.shop.modules.sys.service.SysVisitService;
import com.github.pagehelper.PageInfo;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import com.github.pagehelper.PageHelper;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.shop.modules.sys.controller.AbstractController;
import com.shop.common.utils.PageUtils;
import com.shop.common.dto.ResponseBean;

import javax.servlet.http.HttpServletRequest;


/**
 * @author Generator
 * @date 2019-08-27 14:05:59
 */
@RestController
@RequestMapping("/sys/visit")
public class SysVisitController extends AbstractController {

    @Autowired
    private SysVisitService sysVisitService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    public ResponseBean list(SysVisitDto sysVisitDto) {
        PageHelper.startPage(sysVisitDto.getPage(), sysVisitDto.getRows(), "g.updated_date " + sysVisitDto.getSord());
        List<SysVisitDto> sysVisitDtoList = sysVisitService.findPageInfo(sysVisitDto);
        PageInfo selectPage = new PageInfo(sysVisitDtoList);
        Map<String, Object> result = new HashMap<String, Object>(16);
        result.put("count", selectPage.getTotal());
        result.put("data", selectPage.getList());
        return new ResponseBean(HttpStatus.OK.value(), "查询成功", result);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{visitId}")
    public ResponseBean info(@PathVariable("visitId") Integer visitId) {
        SysVisitDto sysVisit = sysVisitService.selectById(visitId);

        return new ResponseBean(HttpStatus.OK.value(), "查询成功(Query was successful)", sysVisit);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public ResponseBean save(@RequestBody SysVisitDto sysVisit) {
        sysVisit.setCreatedDate(new Date());
        sysVisit.setUpdatedUser(sysVisit.getCreatedUser());
        sysVisit.setUpdatedDate(new Date());
        sysVisitService.insert(sysVisit);

        return new ResponseBean(HttpStatus.OK.value(), "查询成功(Query was successful)", null);
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public ResponseBean update(@RequestBody SysVisitDto sysVisit) {
        sysVisitService.updateById(sysVisit);

        return new ResponseBean(HttpStatus.OK.value(), "查询成功(Query was successful)", null);
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public ResponseBean delete(@RequestBody Integer[] visitIds) {
        sysVisitService.deleteBatchIds(Arrays.asList(visitIds));

        return new ResponseBean(HttpStatus.OK.value(), "查询成功(Query was successful)", null);
    }

    /**
     * 列表
     */
    @RequestMapping("/getVisitLog")
    public ResponseBean getVisitLog() {
        // 1.获取今日访问
        String newVisitNum = sysVisitService.getVisitLog("1");
        // 2.总访问数
        String totalVisitNum = sysVisitService.getVisitLog("2");
        // 3.今日新增
        String newAddVisit = sysVisitService.getVisitLog("3");
        // 4.总个数
        String totalAddVisit = sysVisitService.getVisitLog("4");
        Map<String, Object> result = new HashMap<String, Object>(16);
        result.put("newVisitNum", newVisitNum);
        result.put("totalVisitNum", totalVisitNum);
        result.put("newAddVisit", newAddVisit);
        result.put("totalAddVisit", totalAddVisit);
        return new ResponseBean(HttpStatus.OK.value(), "查询成功", result);
    }
}
