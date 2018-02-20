package com.yixiaolabs.admin.service.impl;

import com.google.common.collect.Sets;
import com.yixiaolabs.admin.core.AbstractService;
import com.yixiaolabs.admin.dao.MenuMapper;
import com.yixiaolabs.admin.model.Menu;
import com.yixiaolabs.admin.service.MenuService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.Set;


/**
 * Created by CodeGenerator on 2018/02/18.
 */
@Service
@Transactional
public class MenuServiceImpl extends AbstractService<Menu> implements MenuService {
    @Resource
    private MenuMapper menuMapper;

    @Override
    public Set<String> getPermissions(Integer id) {
        List<String> permissions = menuMapper.findAllPermissions(id);

        if(permissions != null && permissions.size() > 0 ){
            return Sets.newHashSet(permissions);
        }

        return null;

    }

    @Override
    public Set<Menu> getPermBean(Integer id) {
        List<Menu> permissions = menuMapper.findAllPermBean(id);

        //格式化menu

        if(permissions != null && permissions.size() > 0 ){
            return Sets.newHashSet(permissions);
        }

        return null;

    }
}
