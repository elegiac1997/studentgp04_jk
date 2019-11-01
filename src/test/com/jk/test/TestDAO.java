package com.jk.test;

import com.jk.dao.ClazDAO;
import com.jk.dao.RoleDAO;
import com.jk.dao.UserDAO;
import com.jk.pojo.Claz;
import com.jk.pojo.User;
import com.jk.service.RoleService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;

/**
 * JK
 **/

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class TestDAO {
    @Autowired
    private UserDAO userDAO;
    @Autowired
    private ClazDAO clazDAO;
    @Autowired
    private RoleDAO roleDAO;
    @Autowired
    private RoleService roleService;

    @Test
    public void testdao(){
//        User user = new User(3,"jiankun3",null,null,"男",null,1122);
////        userDAO.insertUser(user);
//
//
//        //System.out.println(userDAO.findByUserName("jiankun3"));
//
////        userDAO.insertUserRole(1,1);
//        //System.out.println(clazDAO.selectAllClaz());
////        System.out.println(clazDAO.selectUserByClaz_id(12));
////        Claz claz = new Claz(null,"15656",new Date());
////        clazDAO.insertClaz(claz);
//        userDAO.updateUser(user);
       // System.out.println(roleDAO.selectAllRoleByUsername("demo02"));
        System.out.println(roleService.selectAllRoleByUsername("demo02"));
    }

}
