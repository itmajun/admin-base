package com.yixiaolabs.admin.service.impl;

import com.yixiaolabs.admin.dao.MenuMapper;
import com.yixiaolabs.admin.model.Menu;
import com.yixiaolabs.admin.service.MenuService;
import com.yixiaolabs.admin.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by CodeGenerator on 2018/02/18.
 */
@Service
@Transactional
public class MenuServiceImpl extends AbstractService<Menu> implements MenuService {
    @Resource
    private MenuMapper menuMapper;

}
