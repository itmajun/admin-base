package com.yixiaolabs.admin.web;


import com.yixiaolabs.admin.core.Result;
import com.yixiaolabs.admin.core.ResultGenerator;
import com.yixiaolabs.admin.model.Admin;
import com.yixiaolabs.admin.service.AdminService;
import com.yixiaolabs.admin.service.TokenService;
import com.yixiaolabs.admin.utils.EncryptUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    @Autowired
    private AdminService adminService;
    @Autowired
    private TokenService tokenService;


    /**
     * 登陆
     * @param username
     * @param password
     * @return
     */
    @PostMapping("/login")
    public Result login(String username, String password){

        //参数校验
        if(username == null){
            return ResultGenerator.genFailResult("用户名不能为空");
        }
        if(password == null){
            return ResultGenerator.genFailResult("密码不能为空");
        }

        Admin admin = adminService.findBy("username", username);

        if(admin == null || !EncryptUtil.matches(EncryptUtil.encode(password), admin.getPassword())){
            return ResultGenerator.genFailResult("账号密码错误");
        }
        if(!admin.getIsEnabled()){
            return ResultGenerator.genFailResult("账户不可用,请联系管理员");
        }
        if(admin.getIsLocked()){
            return ResultGenerator.genFailResult("账号已被锁定,请联系管理员");
        }
        //gen token
        String token = tokenService.genToken(admin.getId());

        return ResultGenerator.genSuccessResult(token);

    }

    public static void main (String[] args){
        System.out.println(EncryptUtil.encode("admin123"));
    }




}
