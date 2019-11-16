package cn.edu.scau.employee.web.controller;

import cn.edu.scau.employee.common.entity.dto.UserDto;
import cn.edu.scau.employee.common.result.CommonResult;
import cn.edu.scau.employee.dao.repository.TokenRepository;
import cn.edu.scau.employee.interfaces.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

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
    @RequiresPermissions(value = {"user:select"})
    public CommonResult test(){
        return CommonResult.success();
    }

}
