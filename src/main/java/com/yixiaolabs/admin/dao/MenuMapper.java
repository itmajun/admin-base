package com.yixiaolabs.admin.dao;

import com.yixiaolabs.admin.core.Mapper;
import com.yixiaolabs.admin.model.Menu;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MenuMapper extends Mapper<Menu> {
    List<String> findAllPermissions(@Param("id") Integer id);
}