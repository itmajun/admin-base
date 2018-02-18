package com.yixiaolabs.admin.service.impl;

import com.yixiaolabs.admin.dao.AuthMapper;
import com.yixiaolabs.admin.model.Auth;
import com.yixiaolabs.admin.service.AuthService;
import com.yixiaolabs.admin.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by CodeGenerator on 2018/02/18.
 */
@Service
@Transactional
public class AuthServiceImpl extends AbstractService<Auth> implements AuthService {
    @Resource
    private AuthMapper authMapper;

}
