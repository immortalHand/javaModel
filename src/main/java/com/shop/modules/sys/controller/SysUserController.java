package com.shop.modules.sys.controller;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.shop.common.dto.ResponseBean;
import com.shop.common.exception.CustomException;
import com.shop.common.utils.Constant;
import com.shop.common.utils.ToolsUtils;
import com.shop.common.validator.Assert;
import com.shop.common.validator.ValidatorUtils;
import com.shop.common.validator.group.UpdateGroup;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.shop.common.annotation.SysLog;
import com.shop.common.dto.ResponseBean;
import com.shop.common.exception.CustomException;
import com.shop.common.utils.Constant;
import com.shop.common.utils.ToolsUtils;
import com.shop.common.validator.Assert;
import com.shop.common.validator.ValidatorUtils;
import com.shop.common.validator.group.AddGroup;
import com.shop.common.validator.group.UpdateGroup;
import com.shop.modules.sys.dto.custom.SysUserDto;
import com.shop.modules.sys.form.PasswordForm;
import com.shop.modules.sys.service.SysUserRoleService;
import com.shop.modules.sys.service.SysUserService;
import org.apache.shiro.crypto.hash.Sha256Hash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 系统用户
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2016年10月31日 上午10:40:10
 */
@RestController
@RequestMapping("/sys/user")
public class SysUserController extends AbstractController {

    @Autowired
    private SysUserService sysUserService;

    @Autowired
    private SysUserRoleService sysUserRoleService;

    /**
     * 所有用户列表
     */
    @GetMapping("/list")
    public ResponseBean list(SysUserDto sysUserDto) {
        PageHelper.startPage(sysUserDto.getPage(), sysUserDto.getRows(), "g.updated_date " + sysUserDto.getSord());
        sysUserDto.setOperateStatus(Constant.NORMAL_STATUS);
        List<SysUserDto> sysUserList = sysUserService.findPageInfo(sysUserDto);
        PageInfo selectPage = new PageInfo(sysUserList);
        Map<String, Object> result = new HashMap<String, Object>(16);
        result.put("count", selectPage.getTotal());
        result.put("data", selectPage.getList());
        return new ResponseBean(HttpStatus.OK.value(), "查询成功", result);
    }

    /**
     * 修改登录用户密码
     */
    @SysLog("修改密码")
    @PutMapping("/password")
    public ResponseBean password(@RequestBody PasswordForm form) {
        Assert.isBlank(form.getNewPassword(), "新密码不为能空");
        // sha256加密
        String password = new Sha256Hash(form.getPassword(), getUser().getSalt()).toHex();
        // sha256加密
        String newPassword = new Sha256Hash(form.getNewPassword(), getUser().getSalt()).toHex();
        // 更新密码
        boolean flag = sysUserService.updatePassword(getUserId(), password, newPassword);
        if (!flag) {
            throw new CustomException("原密码不正确");
        }
        return new ResponseBean(HttpStatus.OK.value(), "密码修改成功", null);
    }

    /**
     * 用户信息
     */
    @GetMapping("/{userId}")
    public ResponseBean info(@PathVariable("userId") Long userId) {
        SysUserDto user = sysUserService.selectById(userId);
        // 获取用户所属的角色列表
        List<Long> roleIdList = sysUserRoleService.queryRoleIdList(userId);
        user.setRoleIdList(roleIdList);

        return new ResponseBean(HttpStatus.OK.value(), "查询成功", user);
    }

    /**
     * 保存用户
     */
    @SysLog("新增用户")
    @PostMapping
    public ResponseBean add(@RequestBody SysUserDto user) throws Exception {
        ValidatorUtils.validateEntity(user, AddGroup.class);
        sysUserService.save(user);
        return new ResponseBean(HttpStatus.OK.value(), "新增成功", null);
    }

    /**
     * 修改用户
     */
    @SysLog("修改用户")
    @PutMapping
    public ResponseBean update(@RequestBody SysUserDto user) throws Exception {
        ValidatorUtils.validateEntity(user, UpdateGroup.class);
        ToolsUtils.setUpdateUserAndDate(user);
        sysUserService.update(user);
        return new ResponseBean(HttpStatus.OK.value(), "修改成功", null);
    }

    /**
     * 删除用户
     */
    @SysLog("删除用户")
    @DeleteMapping("/{id}")
    public ResponseBean delById(@PathVariable("id") Long id) {
        SysUserDto sysUserDto = new SysUserDto();
        sysUserDto.setUserId(id);
        sysUserDto.setValidInd(Constant.UN_VALID_IND);
        sysUserDto.setOperateStatus(Constant.DELETE_STATUS);

        if (!sysUserService.updateById(sysUserDto)) {
            throw new CustomException("删除失败，ID不存在");
        }
        return new ResponseBean(HttpStatus.OK.value(), "删除成功", null);
    }

    /**
     * @param id
     * @return com.sinosoft.core.dto.ResponseBean
     * @Title AppUserController
     * @Description 修改用户有效/无效状态
     * @author xruichang
     * @date 2019年02月23日 09:47
     * @version V1.0
     */
    @SysLog("修改用户有效状态")
    @DeleteMapping("/switch/{id}")
    public ResponseBean statusChange(@PathVariable("id") Integer id) {
        SysUserDto sysUserDto = sysUserService.selectById(id);
        if (ToolsUtils.isEmpty(sysUserDto)) {
            throw new CustomException("该帐号不存在(Account not exist.)");
        }
        if (Constant.VALID_IND.equals(sysUserDto.getValidInd())) {
            sysUserDto.setValidInd(Constant.UN_VALID_IND);
        } else {
            sysUserDto.setValidInd(Constant.VALID_IND);
        }
        sysUserService.updateById(sysUserDto);
        return new ResponseBean(HttpStatus.OK.value(), "操作成功", null);
    }

    /**
     * 获取登录的用户信息
     */
    @GetMapping("/info")
    public ResponseBean info() {
        return new ResponseBean(HttpStatus.OK.value(), "查询成功", getUser());
    }
}
