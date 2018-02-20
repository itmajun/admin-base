package com.yixiaolabs.admin.dao;

import com.yixiaolabs.admin.core.Mapper;
import com.yixiaolabs.admin.model.Role;

import java.util.List;

public interface RoleMapper extends Mapper<Role> {
    List<Role> findAllRoles(Integer id);
}