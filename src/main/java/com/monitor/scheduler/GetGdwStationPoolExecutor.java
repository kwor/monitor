package com.monitor.scheduler;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * 获取gdw电站信息
 * @author zhaoql
 *
 */
public class GetGdwStationPoolExecutor implements Runnable {

public final static GetGdwStationPoolExecutor TASK_POOL=new GetGdwStationPoolExecutor();
	
	ExecutorService executorService=Executors.newFixedThreadPool(5);
	
	private LinkedBlockingQueue<TaskExecutor> que=new LinkedBlockingQueue<TaskExecutor>();

	public GetGdwStationPoolExecutor(){
		Thread t=new Thread(this);
		t.setDaemon(true);
		t.start();
	}
	
	
	@Override
	public void run() {
		while(true){			
			try {
				TaskExecutor executor = que.take();
				executorService.execute(executor);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}		
		}
		
	}
	
	public void addTask(TaskExecutor executor){
		try {
			que.put(executor);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
