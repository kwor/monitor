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
    
    //把stationid插入数据库
    int insertSn(@Param("stationId")String stationId,@Param("userName")String userName,@Param("stationName")String stationName,@Param("station_pic")String station_pic,@Param("currentPower")String currentPower,@Param("capacity")String capacity,@Param("value_eDayTotal")String value_eDayTotal,@Param("value_eTotal")String value_eTotal,@Param("value_dayIncome")String value_dayIncome,@Param("value_totalIncome")String value_totalIncome);

    
    //查询stationid
    List<String> selectStationid();
}