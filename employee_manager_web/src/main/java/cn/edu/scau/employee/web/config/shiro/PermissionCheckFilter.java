package cn.edu.scau.employee.web.config.shiro;

import cn.edu.scau.employee.common.constant.CommonResult;
import cn.edu.scau.employee.common.constant.RespConstants;
import com.alibaba.fastjson.JSON;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.web.filter.authz.PermissionsAuthorizationFilter;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
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
    @Override
    public boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue) throws IOException {
        return SecurityUtils.getSubject().isPermitted(getPathWithinApplication(request));
    }

    @Override
    protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws IOException {
        CommonResult result = CommonResult.error(RespConstants.FORBIDDEN,RespConstants.NO_PERMISSION);
        String json = JSON.toJSONString(result);
        HttpServletResponse res = (HttpServletResponse) response;
        res.setCharacterEncoding(RespConstants.CHARACTER_ENCODING);
        res.setContentType(RespConstants.CONTENT_TYPE);
        PrintWriter out = res.getWriter();
        out.println(json);
        out.close();
        return false;
    }
}
