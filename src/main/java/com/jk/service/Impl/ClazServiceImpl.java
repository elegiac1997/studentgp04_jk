package com.jk.service.Impl;

import com.jk.dao.ClazDAO;
import com.jk.pojo.Claz;
import com.jk.service.ClazService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
