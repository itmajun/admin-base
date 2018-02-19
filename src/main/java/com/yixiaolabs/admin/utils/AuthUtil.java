package com.yixiaolabs.admin.utils;

import com.yixiaolabs.admin.model.Admin;
import org.apache.shiro.SecurityUtils;

public class AuthUtil {

    public static Admin currentAdmin(){
        Object principal = SecurityUtils.getSubject().getPrincipal();
        if(principal == null){
            return null;
        }
        return (Admin) principal;
    }

    public static Integer currentId(){
        Admin admin = currentAdmin();
        if(admin == null){
            return -1;
        }
        return admin.getId();
    }

    public static String currentName(){
        Admin admin = currentAdmin();
        if(admin == null){
            return "";
        }
        return admin.getName();
    }

}
