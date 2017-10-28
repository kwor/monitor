package com.monitor.service;

import com.monitor.pojo.SjPlantinfo;
import com.monitor.pojo.SjSninfo;

public interface ISjService {
	 
	 public String getToken();
	 
	 int insert(SjPlantinfo record);
	 
	 int insert(SjSninfo record);
}
