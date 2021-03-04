package com.coal.service;

import com.coal.pojo.coal;

import java.util.List;

public interface coalService {
    public coal getOne();
    public List<coal> getCO();
    public List<coal> getWasi();
    public String getCO_special(String type, String name);
    public String getWasi_special(String type, String name);
}
