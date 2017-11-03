package com.monitor.scheduler;

import java.util.List;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;


/**
 * 固得威任务执行器
 * @author zhaoql
 *
 */
@Service("gdwTaskSchedule")
public class GdwTask extends AbsTask{

	
	private Logger logger=Logger.getLogger(GdwTask.class);
	

	/**
	 * 任务执行启始
	 */
	@Override
	public void schedule() {
		
		logger.info("开始采集固德威用电信息...");
		
		List<String> accountList=GlobalCache.ACCOUNT_CACHE;
		//查询当前固德威帐户表中的总数量，如果总数量不等于缓存的数量。
		
		
		for(String account: accountList){
			GdwExecutor exe=new GdwExecutor(account);
			GDWGetStationListPoolExecutor.TASK_POOL.addTask(exe);
		}
		
	}
	
	/*public static void main(String[] args){
		GlobalCache.ACCOUNT_CACHE.add("1");
		GlobalCache.ACCOUNT_CACHE.add("2");
		GdwTask t=new GdwTask();
		t.schedule();
		while(true){
			try {
				Thread.sleep(1000*10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
*/
	
}
