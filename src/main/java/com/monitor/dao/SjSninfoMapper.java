package com.monitor.dao;

import com.monitor.pojo.*;

public interface SjSninfoMapper {
    int deleteByPrimaryKey(Integer id);
//把数据信息插入到info表里
    int insert(SjSninfo record);

    int insertSelective(SjSninfo record);

    SjSninfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SjSninfo record);

    int updateByPrimaryKey(SjSninfo record);
}