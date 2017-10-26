package com.monitor.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.monitor.dao.TbInfoMapper;
import com.monitor.pojo.TbInfo;
import com.monitor.service.ITbInfoService;

@Service("TbInfoService")
public class TbInfoService implements ITbInfoService {
	@Resource
	public TbInfoMapper tbInfoMapper;
	//根据stationid插入所有数据
	public int insertError(TbInfo gd) {
		
		return tbInfoMapper.insertError(gd);
	}
	
	//根据inventersn查询出所有信息
	public List<TbInfo> selectByInventersn(String inventersn){
		
		return tbInfoMapper.selectByInventersn(inventersn);
	}
}
