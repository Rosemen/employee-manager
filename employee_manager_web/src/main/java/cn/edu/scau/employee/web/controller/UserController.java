package cn.edu.scau.employee.web.controller;

import cn.edu.scau.employee.common.dto.UserAddDto;
import cn.edu.scau.employee.common.dto.UserDto;
import cn.edu.scau.employee.common.constant.CommonResult;
import cn.edu.scau.employee.common.dto.UserQueryDto;
import cn.edu.scau.employee.dao.repository.TokenRepository;
import cn.edu.scau.employee.interfaces.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * 用户Controller: 处理用户的基本业务
 *
 * @author chen.jiale
 * @date 2019/11/10 16:54
 */
@Api(description = "用户Controller")
@RestController
@RequestMapping(value = "/user")
public class UserController {
    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    @ApiOperation(value = "用户登录")
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public CommonResult login(@RequestBody UserDto userDto){
        return userService.login(userDto);
    }

    @ApiOperation(value = "用户登出")
    @ApiImplicitParam(name = "employee-token",value = "用于登录认证的token",paramType = "header",dataType = "string")
    @RequestMapping(value = "/logout",method = RequestMethod.GET)
    public CommonResult logout(HttpServletRequest request){
        String token = request.getHeader(TokenRepository.TOKEN_HEADER_NAME);
        return userService.logout(token);
    }

    @ApiOperation(value = "测试方法")
    @ApiImplicitParam(name = "employee-token",value = "用于登录认证的token",paramType = "header",dataType = "string")
    @RequestMapping(value = "/test",method = RequestMethod.GET)
    public CommonResult test(){
        return CommonResult.success();
    }

    @ApiOperation(value = "导入用户信息")
    @ApiImplicitParam(name = "employee-token",value = "用于登录认证的token",paramType = "header",dataType = "string")
    @RequestMapping(value = "/upload",method = RequestMethod.POST)
    public CommonResult upload(@RequestParam(value = "file") MultipartFile file) throws Exception {
        return userService.importExcel(file.getBytes());
    }

    @ApiOperation(value = "导出用户信息")
    @ApiImplicitParam(name = "employee-token",value = "用于登录认证的token",paramType = "header",dataType = "string")
    @RequestMapping(value = "/download",method = RequestMethod.POST)
    public CommonResult download(@RequestParam(value = "fileName")String fileName) throws Exception {
        return userService.exportExcel(fileName);
    }

    @ApiOperation(value = "添加用户")
    @ApiImplicitParam(name = "employee-token",value = "用于登录认证的token",paramType = "header",dataType = "string")
    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public CommonResult add(@RequestBody UserAddDto userAddDto){
        return userService.add(userAddDto);
    }

    @ApiOperation(value = "修改用户")
    @ApiImplicitParam(name = "employee-token",value = "用于登录认证的token",paramType = "header",dataType = "string")
    @RequestMapping(value = "/update/{id}",method = RequestMethod.PUT)
    public CommonResult update(@PathVariable("id")Integer id, @RequestBody UserAddDto userAddDto){
        return userService.update(id,userAddDto);
    }

    @ApiOperation(value = "删除用户")
    @ApiImplicitParam(name = "employee-token",value = "用于登录认证的token",paramType = "header",dataType = "string")
    @RequestMapping(value = "/delete",method = RequestMethod.DELETE)
    public CommonResult delete(@RequestBody List<Integer> ids){
        return userService.delete(ids);
    }

    @ApiOperation(value = "查询用户")
    @ApiImplicitParam(name = "employee-token",value = "用于登录认证的token",paramType = "header",dataType = "string")
    @RequestMapping(value = "/query",method = RequestMethod.POST)
    public CommonResult query(@RequestBody UserQueryDto userQueryDto){
        return userService.findByCondition(userQueryDto);
    }

    @ApiOperation(value = "查询用户")
    @ApiImplicitParam(name = "employee-token",value = "用于登录认证的token",paramType = "header",dataType = "string")
    @RequestMapping(value = "/query",method = RequestMethod.GET)
    public CommonResult query(HttpServletRequest request){
        String token = request.getHeader("employee-token");
        return userService.findByToken(token);
    }


}
