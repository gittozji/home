package me.imyu.home.security.realm;

import me.imyu.home.model.User;
import me.imyu.home.service.UserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

/**
 * Created by imyu on 2017/12/9.
 */
public class SimpleRealm extends AuthorizingRealm{

    UserService userService;

    public SimpleRealm() {

    }

    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        return null;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        String username = (String) authenticationToken.getPrincipal();
        User user = userService.findByUsername(username);
        if (null == user) {
            throw new UnknownAccountException();
        }
        return new SimpleAuthenticationInfo(user.getUsername(), user.getPassword(), getName());
    }
}
