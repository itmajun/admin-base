package com.yixiaolabs.admin.configurer.shiro;

import com.yixiaolabs.admin.model.Admin;
import com.yixiaolabs.admin.model.Token;
import com.yixiaolabs.admin.service.AdminService;
import com.yixiaolabs.admin.service.MenuService;
import com.yixiaolabs.admin.service.TokenService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Set;

@Component
public class ShiroRealm extends AuthorizingRealm {

    @Autowired
    private MenuService menuService;
    @Autowired
    private TokenService tokenService;
    @Autowired
    private AdminService adminService;

    @Override
    public boolean supports(AuthenticationToken token) {
        return token instanceof ShiroToken;
    }
    /**
     *  授权
     * @param principals
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        Admin admin = (Admin) principals.getPrimaryPrincipal();

        Set<String> permissions = menuService.getPermissions(admin.getId());

        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        info.setStringPermissions(permissions);
        return info;
    }

    /**
     * 认证
     * @param token
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        String accessToken = (String) token.getPrincipal();

        //根据accessToken，查询用户信息
        Token tokenEntity = tokenService.findBy("token", accessToken);
        //token失效
        if(tokenEntity == null || tokenEntity.getExpireTime().getTime() < System.currentTimeMillis()){
            throw new IncorrectCredentialsException("token失效，请重新登录");
        }

        //查询用户信息
        Admin user = adminService.findById(tokenEntity.getUserId());
        //账号锁定
        if(user.getIsLocked()){
            throw new LockedAccountException("账号已被锁定,请联系管理员");
        }
        if(!user.getIsEnabled()){
            throw new DisabledAccountException("账户不可用,请联系管理员");
        }

        SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(user, accessToken, getName());
        return info;
    }
}
