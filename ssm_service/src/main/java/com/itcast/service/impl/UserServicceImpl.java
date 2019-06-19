package com.itcast.service.impl;

import com.itcast.dao.UserDao;
import com.itcast.domain.Role;
import com.itcast.domain.UserInfo;
import com.itcast.service.UserServicce;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service("userService")
@Transactional
public class UserServicceImpl implements UserServicce {

    @Autowired
    private UserDao userDao;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserInfo userInfo = null;
        try {
            userInfo = userDao.findByUsername(username);
        } catch (Exception e) {
            e.printStackTrace();
        }
        List<Role> roleList = userInfo.getRoles();
        List<SimpleGrantedAuthority> authority = getAuthority(roleList);
        User user = new User(userInfo.getUsername(),userInfo.getPassword(),
                    userInfo.getStatus() == 0 ? false : true,true,true,true,authority);
        return user;
    }

    private List<SimpleGrantedAuthority> getAuthority(List<Role> roleList){
        List<SimpleGrantedAuthority> authorities = new ArrayList<SimpleGrantedAuthority>();
        for (Role role : roleList) {
            authorities.add(new SimpleGrantedAuthority("ROLE_" + role.getRoleName()));
        }
        return authorities;
    }

    public List<UserInfo> findAll() throws Exception {
        return userDao.findAll();
    }

    public void save(UserInfo userInfo) throws Exception {
        userInfo.setPassword(bCryptPasswordEncoder.encode(userInfo.getPassword()));
        userDao.save(userInfo);
    }

    public UserInfo findById(String id) throws Exception {
        return userDao.findById(id);
    }
}
