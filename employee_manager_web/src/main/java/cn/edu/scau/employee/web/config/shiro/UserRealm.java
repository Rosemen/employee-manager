package cn.edu.scau.employee.web.config.shiro;

import cn.edu.scau.employee.common.entity.User;
import cn.edu.scau.employee.common.result.CommonResult;
import cn.edu.scau.employee.interfaces.service.UserService;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.authz.UnauthenticatedException;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 自定义realm: 从数据库获取相关信息
 *
 * @author chen.jiale
 * @date 2019/11/8 16:00
 */
public class UserRealm extends AuthorizingRealm {

    private static final Logger logger = LoggerFactory.getLogger(UserRealm.class);

    @Autowired
    private UserService userService;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        String username = (String) principalCollection.getPrimaryPrincipal();
        logger.info("===========当前授权用户:" + username + "============");
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        return authorizationInfo;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        String username = (String) authenticationToken.getPrincipal();
        logger.info("===========当前验证用户:" + username + "============");
        CommonResult result = userService.findByUserName(username);
        User user = (User)result.getData();
        if (null == user) {
            throw new UnauthenticatedException();
        }
        ByteSource salt = ByteSource.Util.bytes(username);
        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(
                user,
                user.getPassword(),
                salt,
                getName()
        );
        return authenticationInfo;
    }
}
