package com.jk.dao;

import com.jk.pojo.Role;

import java.util.List;
import java.util.Set;

/**
 * JK
 **/
public interface RoleDAO {
    Set<String> selectAllRoleByUsername(String username);
}
