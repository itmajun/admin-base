package com.yixiaolabs.admin.service.impl;

import com.yixiaolabs.admin.dao.RoleMapper;
import com.yixiaolabs.admin.model.Role;
import com.yixiaolabs.admin.service.RoleService;
import com.yixiaolabs.admin.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;


/**
 * Created by CodeGenerator on 2018/02/18.
 */
@Service
@Transactional
public class RoleServiceImpl extends AbstractService<Role> implements RoleService {
    @Resource
    private RoleMapper roleMapper;

    @Override
    @Transactional(readOnly = true)
    public List<Role> findAllRoles(Integer id) {
        return roleMapper.findAllRoles(id);
    }
}
