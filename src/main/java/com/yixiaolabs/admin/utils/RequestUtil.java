package com.yixiaolabs.admin.utils;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Administrator on 2018/2/20 0020.
 */
public class RequestUtil {

    public static HttpServletRequest getRequest(){
        ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
        return servletRequestAttributes.getRequest();
    }

    public static String getToken(){
        HttpServletRequest httpServletRequest = getRequest();
        return httpServletRequest.getHeader("X-Token");
    }
}
