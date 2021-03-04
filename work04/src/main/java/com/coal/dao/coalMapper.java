package com.coal.dao;

import com.coal.pojo.coal;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface coalMapper {
    public coal getOne();
    public List<coal> getCO();
    public List<coal> getWasi();
    public String getCO_special(@Param("type") String type, @Param("name") String name);
    public String getWasi_special(@Param("type") String type, @Param("name") String name);
}
