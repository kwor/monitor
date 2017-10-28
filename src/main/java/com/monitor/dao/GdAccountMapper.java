package com.monitor.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.monitor.pojo.GdAccount;

public interface GdAccountMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(GdAccount record);

    int insertSelective(GdAccount record);

    GdAccount selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(GdAccount record);

    int updateByPrimaryKey(GdAccount record);
    
    //查询条数
    List<GdAccount> selectByGdAccount(@Param("num1")int sum1,@Param("num2")int num2);
    //查询所有
    List<GdAccount> selectAllAccount();
}