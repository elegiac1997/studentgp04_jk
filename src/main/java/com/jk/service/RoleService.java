package com.jk.service;

import com.jk.pojo.Role;

import java.util.List;
import java.util.Set;

public interface RoleService {
    Set<String> selectAllRoleByUsername(String username);
}
