package com.itcast.service.impl;

import com.itcast.dao.RolesDao;
import com.itcast.domain.Role;
import com.itcast.service.RolesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("roleService")
public class RolesServiceImpl implements RolesService {

    @Autowired
    private RolesDao rolesDao;

    public List<Role> findAll() throws Exception {
        return rolesDao.findAll();
    }

    public void save(Role role) throws Exception{
        rolesDao.save(role);
    }
}
