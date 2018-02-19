package com.yixiaolabs.admin.web;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yixiaolabs.admin.core.Result;
import com.yixiaolabs.admin.core.ResultGenerator;
import com.yixiaolabs.admin.model.Admin;
import com.yixiaolabs.admin.service.AdminService;
import com.yixiaolabs.admin.service.TokenService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
* Created by CodeGenerator on 2018/02/18.
*/
@RestController
@RequestMapping("/admin")
public class AdminController {
    @Resource
    private AdminService adminService;
    @Autowired
    private TokenService tokenService;

    @PostMapping("/add")
    public Result add(Admin admin) {
        adminService.save(admin);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/delete")
    public Result delete(@RequestParam Integer id) {
        adminService.deleteById(id);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/update")
    public Result update(Admin admin) {
        adminService.update(admin);
        return ResultGenerator.genSuccessResult();
    }

    @GetMapping("/info")
    public Result detail(@RequestHeader HttpHeaders headers) {
        String token = headers.get("X-Token").get(0);
        Admin admin = adminService.findById(tokenService.findBy("token", token).getUserId());
        return ResultGenerator.genSuccessResult(null);
    }

    @PostMapping("/list")
    public Result list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
        PageHelper.startPage(page, size);
        List<Admin> list = adminService.findAll();
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }
}
