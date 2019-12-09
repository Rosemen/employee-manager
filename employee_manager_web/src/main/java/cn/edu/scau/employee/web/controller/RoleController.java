package cn.edu.scau.employee.web.controller;

import cn.edu.scau.employee.common.constant.CommonResult;
import cn.edu.scau.employee.common.dto.RoleAddDto;
import cn.edu.scau.employee.interfaces.service.RoleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 角色管理Controller
 *
 * @author chen.jiale
 * @date 2019/11/20 15:54
 */
@Api(description = "角色管理Controller")
@RestController
@RequestMapping(value = "/role")
public class RoleController {
    @Autowired
    private RoleService roleService;

    @ApiOperation(value = "查询所有角色")
    @ApiImplicitParam(name = "employee-token", value = "用于登录认证的token", paramType = "header", dataType = "string")
    @RequestMapping(value = "/query", method = RequestMethod.GET)
    public CommonResult query() {
        return roleService.findAll();
    }

    @ApiOperation(value = "添加角色")
    @ApiImplicitParam(name = "employee-token", value = "用于登录认证的token", paramType = "header", dataType = "string")
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public CommonResult add(@RequestBody RoleAddDto roleAddDto) {
        return roleService.add(roleAddDto);
    }

    @ApiOperation(value = "删除角色")
    @ApiImplicitParam(name = "employee-token", value = "用于登录认证的token", paramType = "header", dataType = "string")
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public CommonResult delete(@RequestBody List<Integer> ids) {
        return roleService.delete(ids);
    }

    @ApiOperation(value = "修改角色")
    @ApiImplicitParam(name = "employee-token", value = "用于登录认证的token", paramType = "header", dataType = "string")
    @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
    public CommonResult update(@PathVariable("id")Integer id, @RequestBody RoleAddDto roleAddDto) {
        return roleService.update(id,roleAddDto);
    }

    @ApiOperation(value = "修改角色")
    @ApiImplicitParam(name = "employee-token", value = "用于登录认证的token", paramType = "header", dataType = "string")
    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public CommonResult test(){
        return CommonResult.success();
    }
}
