package com.monitor.service;

import java.util.List;

import com.monitor.pojo.GdAccount;
import com.monitor.pojo.GdSninfo;

public interface IGdSninfoService {
	
	//把stationid插入数据库
     public int insertSn(GdSninfo record);
	//查询stationid
	public List<String> selectStationid();
	public List<GdSninfo> selectStationidTop(int num1,int num2);
	public int updateByStationId(GdSninfo record);
	
	
	//根据账户查询所有信息
	public List<GdAccount> getByGdAccount(int num1,int num2);
	//查询所有
    List<GdAccount> selectAllAccount();
}
