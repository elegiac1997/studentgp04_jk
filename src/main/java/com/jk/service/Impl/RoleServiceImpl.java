package com.jk.service.Impl;

import com.jk.dao.RoleDAO;
import com.jk.pojo.Role;
import com.jk.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

/**
 * JK
 **/
@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleDAO roleDAO;
    @Override
    public Set<String> selectAllRoleByUsername(String username) {
        return roleDAO.selectAllRoleByUsername(username);
    }
}
