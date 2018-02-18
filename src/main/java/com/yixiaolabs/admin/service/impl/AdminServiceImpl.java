package com.yixiaolabs.admin.service.impl;

import com.yixiaolabs.admin.dao.AdminMapper;
import com.yixiaolabs.admin.model.Admin;
import com.yixiaolabs.admin.service.AdminService;
import com.yixiaolabs.admin.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by CodeGenerator on 2018/02/18.
 */
@Service
@Transactional
public class AdminServiceImpl extends AbstractService<Admin> implements AdminService {
    @Resource
    private AdminMapper adminMapper;

}
