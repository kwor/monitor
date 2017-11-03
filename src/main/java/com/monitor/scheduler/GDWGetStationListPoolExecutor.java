package com.monitor.scheduler;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;


/**
 * 线程池管理器
 * @author zhaoql
 *
 */
public class GDWGetStationListPoolExecutor implements Runnable {
	
	
	public final static GDWGetStationListPoolExecutor TASK_POOL=new GDWGetStationListPoolExecutor();
	
	ExecutorService executorService=Executors.newFixedThreadPool(5);
	
	private LinkedBlockingQueue<TaskExecutor> que=new LinkedBlockingQueue<TaskExecutor>();

	public GDWGetStationListPoolExecutor(){
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
