package com.yixiaolabs.admin.dao;

import com.yixiaolabs.admin.core.Mapper;
import com.yixiaolabs.admin.model.Menu;
import com.yixiaolabs.admin.model.Role;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MenuMapper extends Mapper<Menu> {
    List<String> findAllPermissions(@Param("id") Integer id);
    List<Menu> findAllPermBean(@Param("id") Integer id);
}