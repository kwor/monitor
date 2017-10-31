package com.monitor.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.monitor.pojo.*;

public interface SjPlantMapper {
    int deleteByPrimaryKey(Integer id);
//把数据插入到plant里
    int insert(SjPlantinfo record);

    int insertSelective(SjPlantinfo record);

    SjPlantinfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SjPlantinfo record);

    int updateByPrimaryKey(SjPlantinfo record);
  //查询plant的所有数据
    List<SjPlantinfo> selectAll();
    //查询plant条数
    List<SjPlantinfo> selectTop(@Param("num1")int sum1,@Param("num2")int num2);
    //更新
    int updateByPlantId(SjPlantinfo record);
    
}