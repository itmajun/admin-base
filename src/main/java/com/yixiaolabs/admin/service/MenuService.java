package com.yixiaolabs.admin.service;
import com.yixiaolabs.admin.model.Menu;
import com.yixiaolabs.admin.core.Service;
import com.yixiaolabs.admin.model.Role;

import java.util.List;
import java.util.Set;


/**
 * Created by CodeGenerator on 2018/02/18.
 */
public interface MenuService extends Service<Menu> {

    Set<String> getPermissions(Integer id);
    Set<Menu> getPermBean(Integer id);
}
