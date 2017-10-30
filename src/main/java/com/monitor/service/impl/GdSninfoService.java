package com.monitor.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.monitor.dao.GdAccountMapper;
import com.monitor.dao.GdSninfoMapper;

import com.monitor.service.IGdSninfoService;
import com.monitor.pojo.GdAccount;
import com.monitor.pojo.GdSninfo;
@Service("GdSninfoService")
public class GdSninfoService implements IGdSninfoService{
	@Resource
	private GdSninfoMapper gdSninfoMapper;
	
	@Resource
	private GdAccountMapper gdAccountMapper;
	
	//把stationid插入数据库
 
    public int insertSn(GdSninfo record) 
    {
    	return gdSninfoMapper.insert(record);
    }

	//查询stationid
	public List<String> selectStationid() {
		return gdSninfoMapper.selectStationid();
	}
	
	////更新tb_gd_sninfo
	public int updateByStationId(GdSninfo record)
	{
		return gdSninfoMapper.updateByStationId(record);
	}

	@Override
	public List<GdSninfo> selectStationidTop(int num1, int num2) {
		// TODO Auto-generated method stub
		return gdSninfoMapper.selectStationidTop(num1, num2);
	}
	
	
	

	
	//根据账户查询所有信息
	public List<GdAccount> selectByGdAccount(int num1,int num2){
		
		return gdAccountMapper.selectByGdAccount(num1,num2);
	}
	//查询所有
	public List<GdAccount> selectAllAccount()
    {
    	return gdAccountMapper.selectAllAccount();
    }
	@Override
	public List<GdAccount> getByGdAccount(int num1, int num2) {
		// TODO Auto-generated method stub
		return null;
	}
}
