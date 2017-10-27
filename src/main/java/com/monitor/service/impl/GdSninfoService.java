package com.monitor.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.monitor.dao.GdSninfoMapper;

import com.monitor.service.IGdSninfoService;

@Service("GdSninfoService")
public class GdSninfoService implements IGdSninfoService{
	@Resource
	private GdSninfoMapper gdSninfoMapper;
	
	//把stationid插入数据库
	public int insertSn(String stationId,String userName,String stationName,String station_pic,String currentPower,String capacity,String value_eDayTotal,String value_eTotal,String value_dayIncome,String value_totalIncome) {
		return gdSninfoMapper.insertSn(stationId,userName,stationName,station_pic,currentPower,capacity,value_eDayTotal,value_eTotal,value_dayIncome,value_totalIncome);
	}

	//查询stationid
	public List<String> selectStationid() {
		return gdSninfoMapper.selectStationid();
	}
}