package com.monitor.dao;

import com.monitor.pojo.*;

public interface SjSninfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SjSninfo record);

    int insertSelective(SjSninfo record);

    SjSninfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SjSninfo record);

    int updateByPrimaryKey(SjSninfo record);
}