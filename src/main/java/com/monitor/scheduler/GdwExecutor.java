package com.monitor.scheduler;

import java.util.ArrayList;
import java.util.List;

public class GdwExecutor implements TaskExecutor{

    private String account;
    
	public GdwExecutor(String account){
		this.account=account;
	}
	
	@Override
	public void run() {
		//TODO COPY
		//获取多个 station
		System.out.println("使用 "+account+" 获取电站信息");
		//遍历station
		List<String> stationList=new ArrayList<String>();
		stationList.add(account+"888888");
		stationList.add(account+"999999");
		for(String stationId:stationList){
			GetStationGdwExecutor executor=new GetStationGdwExecutor(stationId);
			GetGdwStationPoolExecutor.TASK_POOL.addTask(executor);
		}
		
	}

}
