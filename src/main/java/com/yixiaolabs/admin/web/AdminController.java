package com.yixiaolabs.admin.web;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.common.collect.Maps;
import com.yixiaolabs.admin.core.Result;
import com.yixiaolabs.admin.core.ResultGenerator;
import com.yixiaolabs.admin.model.Admin;
import com.yixiaolabs.admin.model.Menu;
import com.yixiaolabs.admin.model.Role;
import com.yixiaolabs.admin.service.AdminService;
import com.yixiaolabs.admin.service.MenuService;
import com.yixiaolabs.admin.service.RoleService;
import com.yixiaolabs.admin.service.TokenService;
import com.yixiaolabs.admin.utils.RequestUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;
import java.util.Set;

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
    @Autowired
    private RoleService roleService;
    @Autowired
    private MenuService menuService;

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
    public Result detail() {

        /** 封装 adminInfo **/
        Map<String, Object> result = Maps.newHashMap();
        Admin admin = adminService.findById(tokenService.findBy("token", RequestUtil.getToken()).getUserId());

        if(admin == null){
            return ResultGenerator.genFailResult("用户不存在");
        }

        // 查询 用户下的所有 角色, 所有权限
        List<Role> roles = roleService.findAllRoles(admin.getId());
        Set<Menu> menus = menuService.getPermBean(admin.getId());

        result.put("admin", admin);
        result.put("roles", roles);
        result.put("menus", menus);
        return ResultGenerator.genSuccessResult(result);
    }

    @PostMapping("/list")
    public Result list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
        PageHelper.startPage(page, size);
        List<Admin> list = adminService.findAll();
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }
}
