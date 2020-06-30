package group.yueyue.config;

import group.yueyue.DAO.IMP.ImpUserDao;
import group.yueyue.Unity.User;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Create by lp on 2020/6/24
 * 自定义的权限源
 * 继承我们的认证类
 */
public class ShiroRealm extends AuthorizingRealm {
    @Autowired
    private ImpUserDao impUserDao;
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        return null;
    }
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        String userName = (String) authenticationToken.getPrincipal();
        String password = new String((char[]) authenticationToken.getCredentials());
        User find_user = impUserDao.findUser(userName);
        if (find_user == null) {
            throw new UnknownAccountException("用户名不存在");
        } else if (!find_user.getPassword().equals(password)) {
            throw new IncorrectCredentialsException("用户密码错误");
        }
        SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(userName, password, getName());
        return info;

    }
}
