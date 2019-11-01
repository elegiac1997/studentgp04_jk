package com.jk.service.Impl;

import com.jk.constant.MyConstant;
import com.jk.dao.UserDAO;
import com.jk.pojo.User;
import com.jk.service.UserService;
import org.apache.shiro.crypto.hash.Sha256Hash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.UUID;

/**
 * JK
 **/
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDAO userDAO;

    @Override
    public Integer insertUser(User user) {
        String salt = UUID.randomUUID().toString();
        user.setSalt(salt);
        String s = new Sha256Hash(user.getPassword(),salt, MyConstant.ITERCOUNT).toBase64();
        user.setPassword(s);
        user.setRegist_time(new Date());
        return userDAO.insertUser(user);
    }

    @Override
    public User findByUserName(String username) {
        return userDAO.findByUserName(username);
    }

    @Override
    public Integer insertUserRole(Integer user_id, Integer role_id) {
        return userDAO.insertUserRole(user_id,role_id);
    }

    @Override
    public Integer updateUser(User user) {
        return userDAO.updateUser(user);
    }
}
