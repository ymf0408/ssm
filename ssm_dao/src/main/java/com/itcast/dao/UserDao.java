package com.itcast.dao;

import com.itcast.domain.UserInfo;

import java.util.List;

public interface UserDao {

    public UserInfo findByUsername(String username) throws Exception;

    public List<UserInfo> findAll() throws Exception;

    public void save(UserInfo userInfo) throws Exception;

    public UserInfo findById(String id) throws Exception;
}
