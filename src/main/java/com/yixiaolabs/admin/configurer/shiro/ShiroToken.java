package com.yixiaolabs.admin.configurer.shiro;


import org.apache.shiro.authc.AuthenticationToken;

/**
 * token
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2017-05-20 13:22
 */
public class ShiroToken implements AuthenticationToken {
    private String token;

    public ShiroToken(String token){
        this.token = token;
    }

    @Override
    public String getPrincipal() {
        return token;
    }

    @Override
    public Object getCredentials() {
        return token;
    }
}
