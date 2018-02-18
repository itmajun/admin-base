package com.yixiaolabs.admin.web;
import com.yixiaolabs.admin.core.Result;
import com.yixiaolabs.admin.core.ResultGenerator;
import com.yixiaolabs.admin.model.RoleAuth;
import com.yixiaolabs.admin.service.RoleAuthService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
* Created by CodeGenerator on 2018/02/18.
*/
@RestController
@RequestMapping("/role/auth")
public class RoleAuthController {
    @Resource
    private RoleAuthService roleAuthService;

    @PostMapping("/add")
    public Result add(RoleAuth roleAuth) {
        roleAuthService.save(roleAuth);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/delete")
    public Result delete(@RequestParam Integer id) {
        roleAuthService.deleteById(id);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/update")
    public Result update(RoleAuth roleAuth) {
        roleAuthService.update(roleAuth);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/detail")
    public Result detail(@RequestParam Integer id) {
        RoleAuth roleAuth = roleAuthService.findById(id);
        return ResultGenerator.genSuccessResult(roleAuth);
    }

    @PostMapping("/list")
    public Result list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
        PageHelper.startPage(page, size);
        List<RoleAuth> list = roleAuthService.findAll();
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }
}
