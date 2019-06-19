package com.itcast.service;

import com.itcast.domain.Permission;

import java.util.List;

public interface PermissionService {

    public List<Permission> findAll()throws Exception;

    public void save(Permission permission) throws Exception;

}
