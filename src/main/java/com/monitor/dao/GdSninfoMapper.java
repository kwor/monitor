package com.monitor.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.monitor.pojo.GdSninfo;

public interface GdSninfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(GdSninfo record);

    int insertSelective(GdSninfo record);

    GdSninfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(GdSninfo record);

    int updateByPrimaryKey(GdSninfo record);
    
  
    //查询stationid
    List<String> selectStationid();
    
    List<GdSninfo> selectStationidTop(@Param("num1")int sum1,@Param("num2")int num2);
    int updateByStationId(GdSninfo record);
}