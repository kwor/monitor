package com.monitor.service;

import java.util.List;

import com.monitor.pojo.GdAccount;
import com.monitor.pojo.SjPlantinfo;
import com.monitor.pojo.SjSninfo;

public interface ISjService {
	 
	 public String getToken();
	 
	 int insert(SjPlantinfo record);
	 
	 int insert(SjSninfo record);
		
	 //根据账户查询所有信息
	 List<SjPlantinfo> selectTop(int num1,int num2);
	 List<SjPlantinfo> selectAll();
	 
	 List<SjSninfo> selectDeviceId();
	 public int updateByDeviceId(SjSninfo record);
}
