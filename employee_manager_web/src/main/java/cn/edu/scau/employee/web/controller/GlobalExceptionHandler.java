package cn.edu.scau.employee.web.controller;

import cn.edu.scau.employee.common.result.CommonResult;
import cn.edu.scau.employee.common.result.RespConstants;
import org.apache.shiro.authc.CredentialsException;
import org.apache.shiro.authz.AuthorizationException;
import org.apache.shiro.authz.UnauthenticatedException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 全局异常处理器
 *
 * @author chen.jiale
 * @date 2019/11/11 16:45
 */
@ControllerAdvice
@ResponseBody
public class GlobalExceptionHandler {
    private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(value = {UnauthenticatedException.class, CredentialsException.class})
    public CommonResult loginHandler(Exception ex){
       logger.error(RespConstants.LOGIN_FAILURE,ex);
       return CommonResult.error(RespConstants.LOGIN_FAILURE);
    }

    @ExceptionHandler(value = {AuthorizationException.class})
    public CommonResult permissionHandler(Exception ex){
        logger.error(RespConstants.NO_PERMISSION,ex);
        return CommonResult.error(RespConstants.FORBIDDEN,RespConstants.NO_PERMISSION);
    }
}
