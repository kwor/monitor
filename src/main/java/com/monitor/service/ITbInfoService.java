package com.monitor.service;

import java.util.List;

import com.monitor.pojo.TbInfo;

public interface ITbInfoService {
	
	//根据stationid插入所有数据
	public int insertError(TbInfo gd);
	
	//根据inventersn查询出所有信息
	public List<TbInfo> selectByInventersn(String inventersn);

}
