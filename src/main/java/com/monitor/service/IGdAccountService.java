package com.monitor.service;

import java.util.List;

import com.monitor.pojo.GdAccount;

public interface IGdAccountService {
	
	//根据账户查询所有信息
	public List<GdAccount> getByGdAccount(int num1,int num2);
	//查询所有
    List<GdAccount> selectAllAccount();

}
