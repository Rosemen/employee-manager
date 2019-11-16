package cn.edu.scau.employee.web.config.logs;

import org.apache.commons.lang3.time.DateFormatUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

/**
 * 日志切面类,用来管理访问日志
 *
 * @author chen.jiale
 * @date 2019/11/16 12:58
 */
@Aspect
@Configuration
public class WebLogAspect {
    private static final Logger logger = LoggerFactory.getLogger(WebLogAspect.class);

    private ThreadLocal<Long> startTime = new ThreadLocal<>();

    private static final String TIME_PATTERN = "yyyy-MM-dd HH:mm:ss";

    @Pointcut("execution(* cn.edu.scau.employee.web.controller.*Controller.*(..))")
    public void pointCut() {
    }

    @Before("pointCut()")
    public void doBefore(JoinPoint joinPoint) {
        startTime.set(System.currentTimeMillis());
        HttpServletRequest request = HttpContextUtil.getHttpServletRequest();
        String ipAddress = HttpContextUtil.getIpAddress();
        String methodName = joinPoint.getSignature().getName();
        String className = joinPoint.getTarget().getClass().getSimpleName();
        logger.info("请求开始时间: " + DateFormatUtils.format(new Date(), TIME_PATTERN));
        logger.info("请求URL: " + request.getRequestURL().toString());
        logger.info("请求类型: " + request.getMethod());
        logger.info("请求方法: " + className + "." + methodName);
        logger.info("请求来源IP: " + ipAddress);
    }

    @AfterReturning("pointCut()")
    public void doAfterRunning() {
        logger.info("请求结束时间: " + DateFormatUtils.format(new Date(), TIME_PATTERN));
        logger.info("请求处理总时间: " + (System.currentTimeMillis() - startTime.get()) + "ms");
    }
}
