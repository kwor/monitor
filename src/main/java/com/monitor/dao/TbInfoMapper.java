package com.monitor.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.monitor.pojo.TbInfo;

public interface TbInfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TbInfo record);

    int insertSelective(TbInfo record);

    TbInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TbInfo record);

    int updateByPrimaryKey(TbInfo record);
    
    //根据stationid插入所有数据
    int insertError(TbInfo record);
    
    //根据inventersn查询出所有数据
    List<TbInfo> selectByInventersn(String inventersn);
}