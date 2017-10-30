package com.monitor.service.impl;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.monitor.dao.SjPlantMapper;
import com.monitor.dao.SjSninfoMapper;
import com.monitor.pojo.SjPlantinfo;
import com.monitor.pojo.SjSninfo;
import com.monitor.service.ISjService;
import com.monitor.util.GetRequest;
import com.monitor.util.HttpTool;
@Service("SjService")
public class SjService implements ISjService {

	@Resource
	private SjPlantMapper sjPlantMapper;
	@Resource
	private SjSninfoMapper sjSninfoMapper;
	
 	@Override
	public String getToken() {
		// TODO Auto-generated method stub
 		GetRequest gr=new GetRequest();
 		String jsoninfo=gr.getData();
		return jsoninfo;
	}

	@Override
	public int insert(SjPlantinfo record) {
		// TODO Auto-generated method stub
		
		return sjPlantMapper.insert(record);
	}

	@Override
	public int insert(SjSninfo record) {
		// TODO Auto-generated method stub
		return sjSninfoMapper.insert(record);
	}

	@Override
	public List<SjPlantinfo> selectTop(int num1, int num2) {
		// TODO Auto-generated method stub
		return sjPlantMapper.selectTop(num1, num2);
	}

	@Override
	public List<SjPlantinfo> selectAll() {
		// TODO Auto-generated method stub
		return sjPlantMapper.selectAll();
	}

}
