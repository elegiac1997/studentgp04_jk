package com.jk.dao;

import com.jk.pojo.Claz;
import com.jk.pojo.User;

import java.util.List;

/**
 * JK
 **/
public interface ClazDAO {
    List<Claz> selectAllClaz();
    List<User> selectUserByClaz_id(Integer claz_id);
    Integer insertClaz(Claz claz);
}
