package cn.edu.scau.employee.web.config.shiro;

import org.apache.shiro.authz.Permission;
import org.apache.shiro.authz.permission.PermissionResolver;

/**
 * 自定义权限解析器
 *
 * @author chen.jiale
 * @date 2019/11/19 17:13
 */
public class ShiroPermissionResolver implements PermissionResolver {
    @Override
    public Permission resolvePermission(String s) {
        return new ShiroWildcardPermission(s);
    }
}
