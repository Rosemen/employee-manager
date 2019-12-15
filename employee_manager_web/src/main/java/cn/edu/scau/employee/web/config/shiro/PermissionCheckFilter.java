package cn.edu.scau.employee.web.config.shiro;

import cn.edu.scau.employee.common.constant.CommonResult;
import cn.edu.scau.employee.common.constant.HttpConstants;
import com.alibaba.fastjson.JSON;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.web.filter.authz.PermissionsAuthorizationFilter;
import org.apache.tomcat.util.security.PermissionCheck;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.cors.CorsConfiguration;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 权限校验过滤器
 *
 * @author chen.jiale
 * @date 2019/11/19 17:02
 */
public class PermissionCheckFilter extends PermissionsAuthorizationFilter {

    private static final Logger logger = LoggerFactory.getLogger(PermissionCheckFilter.class);

    @Override
    public boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue) throws IOException {
        HttpServletRequest res = (HttpServletRequest) request;
        if (RequestMethod.OPTIONS.name().equals(res.getMethod().toUpperCase())) {
            logger.info("==========当前在校验权限========");
            HttpServletResponse resp = (HttpServletResponse) response;
            resp.setHeader(HttpConstants.ACCESS_CONTROL_ALLOW_ORIGIN,
                    ((HttpServletRequest) request).getHeader(HttpConstants.ORIGIN));
            resp.setHeader(HttpConstants.ACCESS_CONTROL_ALLOW_HEADERS, CorsConfiguration.ALL);
            resp.setHeader(HttpConstants.ACCESS_CONTROL_ALLOW_METHODS,CorsConfiguration.ALL);
            return true;
        }
        return SecurityUtils.getSubject().isPermitted(getPathWithinApplication(request));
    }

    @Override
    protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws IOException {
        CommonResult result = CommonResult.error(HttpConstants.FORBIDDEN, HttpConstants.NO_PERMISSION);
        String json = JSON.toJSONString(result);
        HttpServletResponse res = (HttpServletResponse) response;
        res.setCharacterEncoding(HttpConstants.CHARACTER_ENCODING);
        res.setContentType(HttpConstants.CONTENT_TYPE);
        PrintWriter out = res.getWriter();
        out.println(json);
        out.close();
        return false;
    }
}
