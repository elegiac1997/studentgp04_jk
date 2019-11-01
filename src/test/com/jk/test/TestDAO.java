package com.jk.test;

import com.jk.dao.UserDAO;
import com.jk.pojo.User;
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

    @Test
    public void testdao(){
//        User user = new User(null,"jiankun3","123456","666666","男",new Date(),1122);
//        userDAO.insertUser(user);


        //System.out.println(userDAO.findByUserName("jiankun3"));

        userDAO.insertUserRole(1,1);
    }

}
