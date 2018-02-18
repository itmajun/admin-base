package com.yixiaolabs.admin.service.impl;

import com.yixiaolabs.admin.dao.RoleAuthMapper;
import com.yixiaolabs.admin.model.RoleAuth;
import com.yixiaolabs.admin.service.RoleAuthService;
import com.yixiaolabs.admin.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by CodeGenerator on 2018/02/18.
 */
@Service
@Transactional
public class RoleAuthServiceImpl extends AbstractService<RoleAuth> implements RoleAuthService {
    @Resource
    private RoleAuthMapper roleAuthMapper;

}
