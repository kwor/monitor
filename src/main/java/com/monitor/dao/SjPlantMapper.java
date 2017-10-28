package com.monitor.dao;

import com.monitor.pojo.*;

public interface SjPlantMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SjPlantinfo record);

    int insertSelective(SjPlantinfo record);

    SjPlantinfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SjPlantinfo record);

    int updateByPrimaryKey(SjPlantinfo record);
}