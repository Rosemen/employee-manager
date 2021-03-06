package cn.edu.scau.employee.web.controller;

import cn.edu.scau.employee.common.constant.CommonResult;
import cn.edu.scau.employee.common.constant.HttpConstants;
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
       logger.error(HttpConstants.LOGIN_FAILURE,ex);
       return CommonResult.error(HttpConstants.LOGIN_FAILURE);
    }

    @ExceptionHandler(value = {AuthorizationException.class})
    public CommonResult permissionHandler(Exception ex){
        logger.error(HttpConstants.NO_PERMISSION,ex);
        return CommonResult.error(HttpConstants.FORBIDDEN, HttpConstants.NO_PERMISSION);
    }

    @ExceptionHandler(value = {Exception.class})
    public CommonResult errorHandler(Exception ex){
        logger.error(HttpConstants.ERROR_MSG,ex);
        return CommonResult.error(HttpConstants.ERROR_MSG);
    }
}
