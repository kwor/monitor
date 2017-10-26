package com.monitor.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.monitor.pojo.History;
import com.monitor.pojo.TbInfo;

public interface HistoryMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(History record);

    int insertSelective(History record);
//根据设备ID查询所有条数
    List<TbInfo> selectByequipment_id(String inventersn);
    
//根据设备ID查询最新数据
    List<TbInfo> selectByequipment_idNum(@Param("inventersn")String equipment_id,@Param("offset") int offset, @Param("limit") int limit);

//根据时间查询
    List<TbInfo> selectByEquipment_idTime(@Param("time1")String time1,@Param("time2")String time2);

//根据时间查询单个设备
    List<TbInfo> selectByEquipment_idOneTime(@Param("inventersn") String equipment_id,@Param("time1")String time1,@Param("time2")String time2);
    
    int updateByPrimaryKeySelective(History record);

    int updateByPrimaryKey(History record);
    
//查询所有数据
	List<TbInfo> selectAll();
}