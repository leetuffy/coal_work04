package com.coal.service.impl;

import com.coal.dao.coalMapper;
import com.coal.pojo.coal;
import com.coal.service.coalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class coalServiceImpl implements coalService {
    @Autowired
    private coalMapper coalMapper;
    @Override
    public coal getOne() {
        return coalMapper.getOne();
    }

    @Override
    public List<coal> getCO() {
        return coalMapper.getCO();
    }

    @Override
    public List<coal> getWasi() {
        return coalMapper.getWasi();
    }

    @Override
    public String getCO_special(String type, String name) {
        return coalMapper.getCO_special(type,name);
    }

    @Override
    public String getWasi_special(String type, String name) {
        return coalMapper.getWasi_special(type,name);
    }
}
