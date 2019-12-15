package cn.edu.scau.employee.web.config.shiro;

import cn.edu.scau.employee.common.constant.HttpConstants;
import org.apache.shiro.web.filter.AccessControlFilter;
import org.apache.shiro.web.util.WebUtils;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author chen.jiale
 * @Description 过滤所有的options请求
 * @date 2019/12/15 14:34
 */
public class OptionalFilter extends AccessControlFilter {
    @Override
    protected boolean preHandle(ServletRequest request, ServletResponse response) throws Exception {
        HttpServletRequest req = WebUtils.toHttp(request);
        HttpServletResponse resp = WebUtils.toHttp(response);
        if (RequestMethod.OPTIONS.name().equals(req.getMethod())) {
            resp.setHeader(HttpConstants.ACCESS_CONTROL_ALLOW_ORIGIN, req.getHeader("Origin"));
            resp.setHeader(HttpConstants.ACCESS_CONTROL_ALLOW_METHODS, req.getMethod());
            resp.setHeader(HttpConstants.ACCESS_CONTROL_ALLOW_HEADERS, req.getHeader("Access-Control-Request-Headers"));
            resp.setStatus(HttpConstants.SUCCESS);
            return false;
        }
        return super.preHandle(request, response);
    }

    @Override
    protected boolean isAccessAllowed(ServletRequest servletRequest, ServletResponse servletResponse, Object o) throws Exception {
        return true;
    }

    @Override
    protected boolean onAccessDenied(ServletRequest servletRequest, ServletResponse servletResponse) throws Exception {
        return false;
    }
}
