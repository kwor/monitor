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
		String surl="https://api.saj-solar.com/accessToken?client_id=15426&client_secret=2E7D9390-D68C-436D-A632-798422781066&grant_type=2E7D9390-D68C-436D-A632-798422781066&scope=read,write";
		String jsoninfo = null;
		try {
			jsoninfo = new HttpTool().sendPost("", surl);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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

}
