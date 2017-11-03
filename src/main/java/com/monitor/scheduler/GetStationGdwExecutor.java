package com.monitor.scheduler;

public class GetStationGdwExecutor implements TaskExecutor{

	private String stationId;
	
	public GetStationGdwExecutor(String stationId){
		this.stationId=stationId;
	}
	
	@Override
	public void run() {
		System.out.println(stationId);
		
	}

}
