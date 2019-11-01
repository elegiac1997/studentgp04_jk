package com.jk.service.Impl;

import com.jk.dao.ClazDAO;
import com.jk.pojo.Claz;
import com.jk.pojo.User;
import com.jk.service.ClazService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * JK
 **/
@Service
public class ClazServiceImpl implements ClazService {
    @Autowired
    private ClazDAO clazDAO;

    @Override
    public List<Claz> selectAllClaz() {
        return clazDAO.selectAllClaz();
    }

    @Override
    public List<User> selectUserByClaz_id(Integer claz_id) {
        return clazDAO.selectUserByClaz_id(claz_id);
    }

    @Override
    public Integer insertClaz(Claz claz) {
        claz.setCreate_time(new Date());
        return clazDAO.insertClaz(claz);
    }
}
