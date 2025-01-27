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
//把数据插入plant里
	@Override
	public int insert(SjPlantinfo record) {
		// TODO Auto-generated method stub
		
		return sjPlantMapper.insert(record);
	}
//通过plant访问接口回调数据，获得device_id,在通过device_id访问接口，获取设备信息，插入info表里
	@Override
	public int insert(SjSninfo record) {
		// TODO Auto-generated method stub
		return sjSninfoMapper.insert(record);
	}
//查询plant条数
	@Override
	public List<SjPlantinfo> selectTop(int num1, int num2) {
		// TODO Auto-generated method stub
		return sjPlantMapper.selectTop(num1, num2);
	}
//查询plant的所有数据
	@Override
	public List<SjPlantinfo> selectAll() {
		// TODO Auto-generated method stub
		return sjPlantMapper.selectAll();
	}
//查询plant的所有数据
	public List<SjSninfo> selectDeviceId() {
		// TODO Auto-generated method stub
		return sjSninfoMapper.selectDeviceId();
	}
	public int updateByDeviceId(SjSninfo record) {
		return sjSninfoMapper.updateByDeviceId(record);
	}
	public int updateByPlantId(SjPlantinfo record) {
		return sjPlantMapper.updateByPlantId(record);
	}

}
