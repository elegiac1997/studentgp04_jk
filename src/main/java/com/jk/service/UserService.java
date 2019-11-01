package com.jk.service;

import com.jk.pojo.User;
import org.apache.ibatis.annotations.Param;

/**
 * JK
 **/
public interface UserService {
    Integer insertUser(User user);
    User findByUserName(String username);
    Integer insertUserRole(@Param("user_id") Integer user_id, @Param("role_id") Integer role_id);
    Integer updateUser(User user);
}
