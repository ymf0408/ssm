package com.itcast.service;

import com.itcast.domain.Role;

import java.util.List;

public interface RolesService {

    public List<Role> findAll() throws Exception;

    public void save(Role role) throws Exception;
}
