package com.yixiaolabs.admin.service;
import com.yixiaolabs.admin.model.Role;
import com.yixiaolabs.admin.core.Service;

import java.util.List;


/**
 * Created by CodeGenerator on 2018/02/18.
 */
public interface RoleService extends Service<Role> {

    List<Role> findAllRoles(Integer id);
}
