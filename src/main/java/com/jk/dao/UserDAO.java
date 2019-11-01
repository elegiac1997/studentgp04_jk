package com.jk.dao;

import com.jk.pojo.User;
import org.apache.ibatis.annotations.Param;

/**
 * JK
 **/
public interface UserDAO {
    Integer insertUser(User user);
    User findByUserName(String username);
    Integer insertUserRole(@Param("user_id") Integer user_id,@Param("role_id") Integer role_id);
}
