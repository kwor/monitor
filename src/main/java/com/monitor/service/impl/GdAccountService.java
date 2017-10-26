package com.monitor.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.monitor.dao.GdAccountMapper;
import com.monitor.pojo.GdAccount;
import com.monitor.service.IGdAccountService;

@Service("GdAccountService")
public class GdAccountService implements IGdAccountService{
	@Resource
	private GdAccountMapper gdAccountMapper;
	
	//根据账户查询所有信息
	public List<GdAccount> selectByGdAccount(int num1,int num2){
		
		return gdAccountMapper.selectByGdAccount(num1,num2);
	}

	@Override
	public List<GdAccount> getByGdAccount(int num1, int num2) {
		// TODO Auto-generated method stub
		return null;
	}

}
