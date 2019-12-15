package cn.edu.scau.employee.web.config.shiro;

import cn.edu.scau.employee.common.constant.CommonResult;
import cn.edu.scau.employee.common.constant.HttpConstants;
import cn.edu.scau.employee.dao.repository.TokenRepository;
import com.alibaba.fastjson.JSON;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.cors.CorsConfiguration;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

/**
 * 自定义登录认证filter
 *
 * @author chen.jiale
 * @date 2019/11/9 17:03
 */
public class LoginCheckFilter extends FormAuthenticationFilter {
    @Override
    protected boolean preHandle(ServletRequest request, ServletResponse response) throws Exception {
        HttpServletRequest res = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;
        if (RequestMethod.OPTIONS.name().equals(res.getMethod())){
            resp.setHeader(HttpConstants.ACCESS_CONTROL_ALLOW_ORIGIN, CorsConfiguration.ALL);
            resp.setHeader(HttpConstants.ACCESS_CONTROL_ALLOW_METHODS,CorsConfiguration.ALL);
            resp.setHeader(HttpConstants.ACCESS_CONTROL_ALLOW_ORIGIN,HttpConstants.ORIGIN);
            resp.setStatus(HttpConstants.SUCCESS);
            return false;
        }
        return super.preHandle(request, response);
    }

    /**
     * 判断请求是否已经登录过，默认shiro会帮我们处理，这里使用自定义token来处理
     *
     * @param request
     * @param response
     * @param mappedValue
     * @return
     */
    @Override
    protected boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue) {
        BeanFactory factory = WebApplicationContextUtils.getRequiredWebApplicationContext(request.getServletContext());
        TokenRepository tokenRepository = factory.getBean(TokenRepository.class);
        HttpServletRequest res = (HttpServletRequest) request;
        String token = res.getHeader(TokenRepository.TOKEN_HEADER_NAME);
        if (null == token) {
            return false;
        }
        return tokenRepository.checkToken(token);
    }

    /**
     * 请求认证失败后执行这个方法
     *
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    @Override
    protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws Exception {
        CommonResult result = CommonResult.error(HttpConstants.FORBIDDEN, HttpConstants.NOT_LOGIN);
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
