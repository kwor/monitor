package com.monitor.dao;

import java.util.List;

import com.monitor.pojo.*;

public interface SjSninfoMapper {
    int deleteByPrimaryKey(Integer id);
//把数据信息插入到info表里
    int insert(SjSninfo record);

    int insertSelective(SjSninfo record);

    SjSninfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SjSninfo record);

    int updateByPrimaryKey(SjSninfo record);
    //查询所有deviceId
    List<SjSninfo> selectDeviceId();
    
    //根据device_id 更新记录
    int updateByDeviceId(SjSninfo record);
}