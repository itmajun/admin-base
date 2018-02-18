package com.yixiaolabs.admin.service.impl;

import com.yixiaolabs.admin.dao.AdminRoleMapper;
import com.yixiaolabs.admin.model.AdminRole;
import com.yixiaolabs.admin.service.AdminRoleService;
import com.yixiaolabs.admin.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by CodeGenerator on 2018/02/18.
 */
@Service
@Transactional
public class AdminRoleServiceImpl extends AbstractService<AdminRole> implements AdminRoleService {
    @Resource
    private AdminRoleMapper adminRoleMapper;

}
