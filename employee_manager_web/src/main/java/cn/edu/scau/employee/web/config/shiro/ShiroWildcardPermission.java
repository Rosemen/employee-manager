package cn.edu.scau.employee.web.config.shiro;

import org.apache.shiro.authz.Permission;
import org.apache.shiro.authz.permission.WildcardPermission;

import java.util.List;
import java.util.Set;

/**
 * 校验是否拥有权限
 *
 * @author chen.jiale
 * @date 2019/11/19 20:06
 */
public class ShiroWildcardPermission extends WildcardPermission {
    public ShiroWildcardPermission(String wildcardString) {
        super(wildcardString, DEFAULT_CASE_SENSITIVE);
    }

    @Override
    public boolean implies(Permission p) {
        if (!(p instanceof ShiroWildcardPermission)) {
            return false;
        }
        List<Set<String>> parts = ((ShiroWildcardPermission) p).getParts();
        String targetUrl = parts.get(0).iterator().next();
        String url = getParts().get(0).iterator().next();
        if (targetUrl.startsWith(url)){
            if (targetUrl.equals(url)){
                return true;
            }
            return targetUrl.startsWith(url.concat("/"));
        }
        return false;
    }
}
