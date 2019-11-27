package com.shop.modules.sys.controller;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.shop.common.dto.ResponseBean;
import com.shop.common.utils.PageUtils;
import com.shop.common.utils.R;
import com.shop.modules.sys.dto.custom.SysDictTypeDto;
import com.shop.modules.sys.service.SysDictTypeService;
import com.github.pagehelper.PageHelper;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.Map;



/**
 * 字典类型表
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2019-02-23 16:16:05
 */
@RestController
@RequestMapping("sys/dictType")
public class SysDictTypeController {
    @Autowired
    private SysDictTypeService sysDictypeService;

    /**
     * 查询
     * @author Generator
     * @date 2019-02-22 18:46:37
     */
    @GetMapping
    public ResponseBean findByCode() {
        List<SysDictTypeDto> sysDictDataDtoList = sysDictypeService.selectList(null);
        return new ResponseBean(HttpStatus.OK.value(),"查询成功", sysDictDataDtoList);
    }

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("sys:sysdictype:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = sysDictypeService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{dictId}")
    @RequiresPermissions("sys:sysdictype:info")
    public R info(@PathVariable("dictId") Long dictId){
			SysDictTypeDto sysDictype = sysDictypeService.selectById(dictId);

        return R.ok().put("sysDictype", sysDictype);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("sys:sysdictype:save")
    public R save(@RequestBody SysDictTypeDto sysDictype){
			sysDictypeService.insert(sysDictype);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("sys:sysdictype:update")
    public R update(@RequestBody SysDictTypeDto sysDictype){
			sysDictypeService.updateById(sysDictype);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("sys:sysdictype:delete")
    public R delete(@RequestBody Long[] dictIds){
			sysDictypeService.deleteBatchIds(Arrays.asList(dictIds));

        return R.ok();
    }

}
