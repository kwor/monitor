package com.monitor.service;

import java.util.List;

import com.monitor.pojo.GdAccount;
import com.monitor.pojo.GdSninfo;

public interface IGdSninfoService {
	
	//把stationid插入数据库
     public int insertSn(GdSninfo record);
	//查询stationid
	public List<String> selectStationid();
	public int updateByStationId(GdSninfo record);
}
