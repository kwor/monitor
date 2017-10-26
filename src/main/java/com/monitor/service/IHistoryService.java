package com.monitor.service;

import java.util.List;

import com.monitor.pojo.History;
import com.monitor.pojo.TbInfo;

public interface IHistoryService {
	//根据ID查询所有
    public List<TbInfo> getHistoryByequipment_id(String inventersn);
    //根据ID查询最新数据
    public List<TbInfo> getHistoryByequipment_idNum(String inventersn,int offset,int limit);
    //根据时间查询
    public List<TbInfo> getHistoryByEquipment_idTime(String time1,String time2);
    //根据时间查询单个设备
    public List<TbInfo> getHistoryByEquipment_idOneTime(String inventersn,String time1,String time2);
    //查询所有数据
	public List<TbInfo> selectAll();
}