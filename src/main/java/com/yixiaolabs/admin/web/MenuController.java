package com.yixiaolabs.admin.web;
import com.google.common.base.Strings;
import com.yixiaolabs.admin.core.Result;
import com.yixiaolabs.admin.core.ResultGenerator;
import com.yixiaolabs.admin.model.Menu;
import com.yixiaolabs.admin.service.MenuService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yixiaolabs.admin.utils.log.Log;
import org.springframework.web.bind.annotation.*;
import tk.mybatis.mapper.entity.Condition;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.util.List;

/**
* Created by CodeGenerator on 2018/02/18.
*/
@RestController
@RequestMapping("/system/menu")
public class MenuController {
    @Resource
    private MenuService menuService;

    @PostMapping("/add")
    @Log(type = "MENU_ADD",detail = "添加菜单")
    public Result add(Menu menu) {
        menuService.save(menu);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/delete")
    public Result delete(@RequestParam Integer id) {
        menuService.deleteById(id);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/update")
    public Result update(Menu menu) {
        menuService.update(menu);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/detail")
    public Result detail(@RequestParam Integer id) {
        Menu menu = menuService.findById(id);
        return ResultGenerator.genSuccessResult(menu);
    }

    @GetMapping("/list")
    public Result list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size
                        , String name, Integer type, String appid) {
        PageHelper.startPage(page, size);
        Condition condition = new Condition(Menu.class);
        Example.Criteria criteria = condition.createCriteria();
        if(name != null && !"".equals(name)){
            criteria.andLike("name", "%" + name + "%");
        }
        if(type !=null){
            criteria.andEqualTo("type", type);
        }
        if(!Strings.isNullOrEmpty(appid)){
            criteria.andLike("appid", "%" + appid + "%");
        }
        List<Menu> list = menuService.findByCondition(condition);
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }
}
