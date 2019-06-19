package com.itcast.dao;

import com.itcast.domain.Permission;

import java.util.List;

public interface PermissionDao {

    public Permission findByRoleId(String id) throws Exception;

    public List<Permission> findAll() throws Exception;

    public void save(Permission permission) throws Exception;

}
