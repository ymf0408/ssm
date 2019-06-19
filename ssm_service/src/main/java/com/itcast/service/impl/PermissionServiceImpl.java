package com.itcast.service.impl;

import com.itcast.dao.PermissionDao;
import com.itcast.domain.Permission;
import com.itcast.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("permissionService")
public class PermissionServiceImpl implements PermissionService {

    @Autowired
    private PermissionDao permissionDao;

    public List<Permission> findAll() throws Exception {
        return permissionDao.findAll();
    }

    public void save(Permission permission) throws Exception {
        permissionDao.save(permission);
    }
}
