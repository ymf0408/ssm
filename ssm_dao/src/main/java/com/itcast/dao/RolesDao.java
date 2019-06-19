package com.itcast.dao;

import com.itcast.domain.Role;

import java.util.List;

public interface RolesDao {

    public Role findByUserId(String id)throws Exception;

    public List<Role> findAll() throws Exception;

    public void save(Role role) throws Exception;
}
