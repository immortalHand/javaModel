package com.shop.modules.sys.controller;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.shop.common.dto.ResponseBean;
import com.shop.common.utils.PageUtils;
import com.shop.common.utils.UserUtils;
import com.shop.modules.sys.dto.custom.SysDictDataDto;
import com.shop.modules.sys.dto.custom.SysRoleDto;
import com.shop.modules.sys.dto.custom.SysUserDto;
import com.shop.modules.sys.service.SysDictDataService;
import com.shop.modules.sys.service.SysRoleService;
import com.shop.modules.sys.service.SysUserService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.*;


/**
 * 字典数据表
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2019-02-23 16:16:05
 */
@RestController
@RequestMapping("sys/dictData")
public class SysDictDataController {

    @Autowired
    private UserUtils userUtils;

    @Autowired
    private SysDictDataService sysDictDataService;

    @Autowired
    private SysUserService sysUserService;

    @Autowired
    private SysRoleService sysRoleService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    public ResponseBean list(@RequestParam Map<String, Object> params){
        PageUtils page = sysDictDataService.queryPage(params);
        return new ResponseBean(HttpStatus.OK.value(),"查询成功！",page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{dictCode}")
    public ResponseBean info(@PathVariable("dictCode") Long dictCode){
			SysDictDataDto sysDicdata = sysDictDataService.selectById(dictCode);
        return new ResponseBean(HttpStatus.OK.value(),"查询成功！",sysDicdata);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public ResponseBean save(@RequestBody SysDictDataDto sysDicdata){
        sysDictDataService.insert(sysDicdata);
        return new ResponseBean(HttpStatus.OK.value(),"查询成功！",null);
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public ResponseBean update(@RequestBody SysDictDataDto sysDicdata){
        sysDictDataService.updateById(sysDicdata);
        return new ResponseBean(HttpStatus.OK.value(),"查询成功！",null);
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public ResponseBean delete(@RequestBody Long[] dictCodes){
        sysDictDataService.deleteBatchIds(Arrays.asList(dictCodes));

        return new ResponseBean(HttpStatus.OK.value(),"删除成功！",null);
    }

    /**
     * 查询
     * @author Generator
     * @date 2019-02-22 18:46:37
     */
    @GetMapping("/{dictType}")
    public ResponseBean findByCode(@PathVariable("dictType") String dictType) {
        List<SysDictDataDto> sysDictDataDtoList = null;
        if ("PermissionType".equals(dictType)) {
            sysDictDataDtoList = new ArrayList<SysDictDataDto>();
            List<SysRoleDto> sysRoleDtos = sysRoleService.selectList(new EntityWrapper<SysRoleDto>());
            SysDictDataDto dictDataDto = null;
            for (SysRoleDto roleDto : sysRoleDtos) {
                dictDataDto = new SysDictDataDto();
                dictDataDto.setDictCode(roleDto.getRoleId());
                dictDataDto.setDictValue(roleDto.getRoleName());
                sysDictDataDtoList.add(dictDataDto);
            }
        } else if ("UserCode".equals(dictType)) {
            sysDictDataDtoList = new ArrayList<SysDictDataDto>();
            List<SysUserDto> sysUserDtos = sysUserService.selectList(new EntityWrapper<SysUserDto>());
            SysDictDataDto dictDataDto = null;
            for (SysUserDto userDto : sysUserDtos) {
                dictDataDto = new SysDictDataDto();
                dictDataDto.setDictCode(userDto.getUserId());
                // dictDataDto.setDictValue(userDto.getUserName());
                sysDictDataDtoList.add(dictDataDto);
            }
        } else {
            PageHelper.orderBy("dict_sort asc");
            sysDictDataDtoList = sysDictDataService.selectList(new EntityWrapper<SysDictDataDto>()
                    .eq(dictType != null, "dict_type", dictType));
        }
        return new ResponseBean(HttpStatus.OK.value(), "查询成功！", sysDictDataDtoList);
    }

    /**
     * 查询
     * @author Generator
     * @date 2019-02-22 18:46:37
     */
    @GetMapping("/all/{dictType}")
    public ResponseBean findByCodeAll(@PathVariable("dictType") String dictType) {
        List<SysDictDataDto> sysDictDataDtoListTemp = null;
        if ("PermissionType".equals(dictType)) {
            sysDictDataDtoListTemp = new ArrayList<SysDictDataDto>();
            List<SysRoleDto> sysRoleDtos = sysRoleService.selectList(new EntityWrapper<SysRoleDto>());
            SysDictDataDto dictDataDto = null;
            for (SysRoleDto roleDto : sysRoleDtos) {
                dictDataDto = new SysDictDataDto();
                dictDataDto.setDictCode(roleDto.getRoleId());
                dictDataDto.setDictValue(roleDto.getRoleName());
                sysDictDataDtoListTemp.add(dictDataDto);
            }
        } else if ("UserCode".equals(dictType)) {
            sysDictDataDtoListTemp = new ArrayList<SysDictDataDto>();
            List<SysUserDto> sysUserDtos = sysUserService.selectList(new EntityWrapper<SysUserDto>());
            SysDictDataDto dictDataDto = null;
            for (SysUserDto userDto : sysUserDtos) {
                dictDataDto = new SysDictDataDto();
                dictDataDto.setDictCode(userDto.getUserId());
                dictDataDto.setDictValue(userDto.getUsername());
                sysDictDataDtoListTemp.add(dictDataDto);
            }
        }else {
            PageHelper.orderBy("dict_sort asc");
            sysDictDataDtoListTemp = sysDictDataService.selectList(new EntityWrapper<SysDictDataDto>()
                    .eq(dictType != null, "dict_type", dictType));
        }
        List<SysDictDataDto> sysDictDataDtoList = new ArrayList<SysDictDataDto>();
        SysDictDataDto sysDictDataDto = new SysDictDataDto();
        sysDictDataDto.setRemark("全部");
        sysDictDataDto.setDictValue("全部");
        sysDictDataDtoList.add(sysDictDataDto);
        sysDictDataDtoList.addAll(sysDictDataDtoListTemp);
        return new ResponseBean(HttpStatus.OK.value(),"查询成功！", sysDictDataDtoList);
    }



    /**
     * 根据用户id查询角色信息
     * @author Generator
     * @date 2019-02-22 18:46:37
     */
    @GetMapping("/verifier/{roleId}")
    public ResponseBean verifier(@PathVariable("roleId") String roleId) {
        List<SysUserDto> userList = sysUserService.findUserByRoleId(roleId);
        return new ResponseBean(HttpStatus.OK.value(),"查询成功！", userList);
    }

}
