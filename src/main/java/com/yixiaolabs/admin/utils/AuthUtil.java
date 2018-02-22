package com.yixiaolabs.admin.utils;

import com.yixiaolabs.admin.model.Admin;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;

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

    public boolean checkPermission(String permission){
        boolean flag = false;
        Subject currentUser = SecurityUtils.getSubject();//获取当前用户

        try{
            currentUser.checkPermission(permission);//检查是否有对应权限
            flag = true;
        }catch (Exception exception){

        }

        return flag;
    }

    public boolean hasRole(String role){
        boolean flag = false;
        Subject currentUser = SecurityUtils.getSubject();//获取当前用户

        try{
            currentUser.hasRole(role);//检查是否有对应权限
            flag = true;
        }catch (Exception exception){

        }

        return flag;
    }

}
