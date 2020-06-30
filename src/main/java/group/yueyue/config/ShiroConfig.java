package group.yueyue.config;

import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.CookieRememberMeManager;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.servlet.SimpleCookie;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;

/**
 * Create by lp on 2020/6/24
 * shiro配置类
 */
@Configuration
public class ShiroConfig {
    @Bean
    public ShiroRealm customRelam() {
        return new ShiroRealm();

    }

    @Bean
    public SecurityManager securityManager() {
        DefaultWebSecurityManager defaultWebSecurityManager = new DefaultWebSecurityManager();
        defaultWebSecurityManager.setRealm(customRelam());
        defaultWebSecurityManager.setRememberMeManager(rememberMeManager());
        return defaultWebSecurityManager;
    }

    @Bean(name = "shiroFilterFactoryBean")
    public ShiroFilterFactoryBean shiroFilterFactoryBean(SecurityManager securityManager) {
        /*我们的项目主页是/。进入后会被拦截跳转到/login页面，进行登录，成功后地址
         * 变成/succes。然后跳转到成功页面*/
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        shiroFilterFactoryBean.setSecurityManager(securityManager());
        shiroFilterFactoryBean.setLoginUrl("/login");
        shiroFilterFactoryBean.setUnauthorizedUrl("/403");
        LinkedHashMap<String, String> fileterMap = new LinkedHashMap<String, String>();
        /*主页映射直接放行*/
        fileterMap.put("/login", "anon");
        fileterMap.put("/logout", "logout");
        fileterMap.put("/**", "user");
        shiroFilterFactoryBean.setFilterChainDefinitionMap(fileterMap);
        return shiroFilterFactoryBean;
    }

    /**
     * @Author:lp on 2020/6/30 10:27
     * @Param:
     * @return:CookieRememberMeManager
     * @Description:shiro提供的cookies管理技术
     */
    @Bean
    public CookieRememberMeManager rememberMeManager() {
        CookieRememberMeManager cookieRememberMeManager = new CookieRememberMeManager();
        cookieRememberMeManager.setCookie(remembercookies());
        return cookieRememberMeManager;

    }

    @Bean(name = "remembercookies")
    public SimpleCookie remembercookies() {
        SimpleCookie simpleCookie = new SimpleCookie("rememberme");
        //cookies的保存时间20秒
        simpleCookie.setMaxAge(20);
        return simpleCookie;

    }
}
