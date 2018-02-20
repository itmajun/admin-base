package com.yixiaolabs.admin.configurer.shiro;

import com.alibaba.fastjson.JSON;
import com.google.common.base.Strings;
import com.yixiaolabs.admin.core.Result;
import com.yixiaolabs.admin.core.ResultCode;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.web.filter.authc.AuthenticatingFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

/**
 * oauth2过滤器
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2017-05-20 13:00
 */
public class ShiroFilter extends AuthenticatingFilter {

    private final Logger logger = LoggerFactory.getLogger(ShiroFilter.class);

    @Override
    protected AuthenticationToken createToken(ServletRequest request, ServletResponse response){
        //获取请求token
        String token = getRequestToken((HttpServletRequest) request);

        if(Strings.isNullOrEmpty(token)){
            return null;
        }
        return new ShiroToken(token);
    }

    @Override
    protected boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue) {
        return false;
    }

    @Override
    protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws Exception {
        //获取请求token，如果token不存在，直接返回401
        String token = getRequestToken((HttpServletRequest) request);
        if(Strings.isNullOrEmpty(token)){
            HttpServletResponse httpResponse = (HttpServletResponse) response;
            responseResult(httpResponse, new Result().setCode(ResultCode.UNAUTHORIZED).setMessage("无效的授权"));

            return false;
        }

        return executeLogin(request, response);
    }

    private void responseResult(HttpServletResponse response, Result result) {
        response.setCharacterEncoding("UTF-8");
        response.setHeader("Content-type", "application/json;charset=UTF-8");
        response.setStatus(200);
        try {
            response.getWriter().write(JSON.toJSONString(result));
        } catch (IOException ex) {
            logger.error(ex.getMessage());
        }
    }

    @Override
    protected boolean onLoginFailure(AuthenticationToken token, AuthenticationException e, ServletRequest request, ServletResponse response) {
        HttpServletResponse httpResponse = (HttpServletResponse) response;
        httpResponse.setContentType("application/json;charset=utf-8");
        //处理登录失败的异常
        Throwable throwable = e.getCause() == null ? e : e.getCause();
        responseResult(httpResponse, new Result().setCode(ResultCode.UNAUTHORIZED).setMessage(throwable.getMessage()));

        return false;
    }

    /**
     * 获取请求的token
     */
    private String getRequestToken(HttpServletRequest httpRequest){
        //从header中获取token
        String token = httpRequest.getHeader("X-Token");

        //如果header中不存在token，则从参数中获取token
        if(Strings.isNullOrEmpty(token)){
            token = httpRequest.getParameter("token");
        }

        return token;
    }

    @Override
    protected boolean preHandle(ServletRequest request, ServletResponse response) throws Exception {
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        HttpServletResponse httpServletResponse = (HttpServletResponse) response;
        httpServletResponse.setHeader("Access-control-Allow-Origin", httpServletRequest.getHeader("Origin"));
        httpServletResponse.setHeader("Access-Control-Allow-Methods", "GET,POST,OPTIONS,PUT,DELETE");
        httpServletResponse.setHeader("Access-Control-Allow-Headers", httpServletRequest.getHeader("Access-Control-Request-Headers"));
        // 跨域时会首先发送一个option请求，这里我们给option请求直接返回正常状态
        if (httpServletRequest.getMethod().equals(RequestMethod.OPTIONS.name())) {
            httpServletResponse.setStatus(HttpStatus.OK.value());
            return false;
        }
        return super.preHandle(request, response);
    }
}
