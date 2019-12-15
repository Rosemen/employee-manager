package cn.edu.scau.employee.web.config.shiro;

import cn.edu.scau.employee.common.utils.EncryptUtil;
import org.apache.shiro.authc.credential.CredentialsMatcher;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.spring.LifecycleBeanPostProcessor;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;

import javax.servlet.Filter;
import java.util.LinkedHashMap;
import java.util.Map;


/**
 * shiro配置类
 *
 * @author chen.jiale
 * @date 2019/11/8 15:35
 */
@Configuration
public class ShiroConfig {

    @Bean
    @ConfigurationProperties(prefix = "shiro")
    public ShiroProperties properties() {
        return new ShiroProperties();
    }

    /**
     * shiro的过滤器
     *
     * @param securityManager
     * @return
     */
    @Bean(name = "shiroFilter")
    public ShiroFilterFactoryBean shiroFilterFactoryBean(SecurityManager securityManager) {
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        shiroFilterFactoryBean.setSecurityManager(securityManager);
        ShiroProperties properties = properties();
        Map<String, Filter> filterMap = new LinkedHashMap<>();
        //使用自定义filter,验证不通过返回json数据
        filterMap.put(properties.getOptional(), new OptionalFilter());
        filterMap.put(properties.getAuthcToken(), new LoginCheckFilter());
        filterMap.put(properties.getPermission(), new PermissionCheckFilter());
        shiroFilterFactoryBean.setFilters(filterMap);
        //设置shiro过滤链
        Map<String, String> filterChainDefinitionMap = new LinkedHashMap<>();
        filterChainDefinitionMap.put(properties.getIndexUrl(), properties.getAnon());
        filterChainDefinitionMap.put(properties.getLoginUrl(), properties.getAnon());
        filterChainDefinitionMap.put(properties.getLogoutUrl(),
                properties.getOptional() + "," + properties.getAuthcToken());
        filterChainDefinitionMap.put(properties.getSwaggerUiUrl(), properties.getAnon());
        filterChainDefinitionMap.put(properties.getSwaggerResourceUrl(), properties.getAnon());
        filterChainDefinitionMap.put(properties.getWebjarsUrl(), properties.getAnon());
        filterChainDefinitionMap.put(properties.getApiDocsUrl(), properties.getAnon());
        filterChainDefinitionMap.put(properties.getAllUrl(), properties.getOptional() + "," +
                properties.getAuthcToken() + "," + properties.getPermission());
        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap);
        return shiroFilterFactoryBean;
    }

    /**
     * SecurityManger:用来管理shiro的Subject对象
     *
     * @return
     */
    @Bean
    public SecurityManager securityManager(UserRealm userRealm) {
        //web环境下的SecurityManager
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        securityManager.setRealm(userRealm);
        return securityManager;
    }

    /**
     * UserRealm: 负责身份认证与权限校验
     *
     * @param credentialsMatcher
     * @return
     */
    @Bean
    public UserRealm userRealm(CredentialsMatcher credentialsMatcher) {
        UserRealm userRealm = new UserRealm();
        userRealm.setCredentialsMatcher(credentialsMatcher);
        userRealm.setPermissionResolver(new ShiroPermissionResolver());
        return userRealm;
    }

    /**
     * 凭证校验器: UserRealm中的身份认证
     *
     * @return
     */
    @Bean
    public CredentialsMatcher credentialsMatcher() {
        HashedCredentialsMatcher hashedCredentialsMatcher = new HashedCredentialsMatcher();
        //设置hash算法与hash次数
        hashedCredentialsMatcher.setHashAlgorithmName(EncryptUtil.ALGORITHM);
        hashedCredentialsMatcher.setHashIterations(EncryptUtil.INTERATION);
        //设置加密方式,true为Hex,false为Base64
        hashedCredentialsMatcher.setStoredCredentialsHexEncoded(true);
        return hashedCredentialsMatcher;
    }

    /**
     * shiro生命周期处理器: 用来管理shiro bean的生命周期
     *
     * @return
     */
    @Bean
    public LifecycleBeanPostProcessor lifecycleBeanPostProcessor() {
        return new LifecycleBeanPostProcessor();
    }

    /**
     * 开启Shiro注解(@RequiresRoles,@RequiresPermissions),
     * 扫描上下文，寻找所有的Advistor(通知器），
     * 将这些Advisor应用到所有符合切入点的Bean
     *
     * @return
     */
    @Bean
    @DependsOn({"lifecycleBeanPostProcessor"})
    public DefaultAdvisorAutoProxyCreator defaultAdvisorAutoProxyCreator() {
        DefaultAdvisorAutoProxyCreator defaultAdvisorAutoProxyCreator = new DefaultAdvisorAutoProxyCreator();
        defaultAdvisorAutoProxyCreator.setProxyTargetClass(true);
        return defaultAdvisorAutoProxyCreator;
    }

    /**
     * 权限注解(如@RequiresRoles,@RequiresPermissions等)的通知器,
     * 匹配所有类，匹配所有加了认证注解的方法
     *
     * @param securityManager
     * @return
     */
    @Bean
    public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(SecurityManager securityManager) {
        AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor = new AuthorizationAttributeSourceAdvisor();
        authorizationAttributeSourceAdvisor.setSecurityManager(securityManager);
        return authorizationAttributeSourceAdvisor;
    }
}
