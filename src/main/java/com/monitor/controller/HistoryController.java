package com.monitor.controller;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONArray;
import com.monitor.pojo.History;
import com.monitor.pojo.TbInfo;
import com.monitor.service.IHistoryService;

@Controller
@RequestMapping("/")
public class HistoryController {

    @Resource
    private IHistoryService historyService;
    @ResponseBody
//根据ID查询所有数据
    @RequestMapping(value="/SNCode/{inventersn}", method = {RequestMethod.GET})
    public List<TbInfo> selectByequipmentId( Model model,@PathVariable(value="inventersn") String inventersn) {
         List<TbInfo> history = this.historyService.getHistoryByequipment_id(inventersn);       
         return history;             
    }
    
//根据ID查询最新数据
    @ResponseBody
    @RequestMapping(value="/SNCode/{inventersn}/{offset}/{limit}",method= {RequestMethod.GET})
    public List<TbInfo> selectByequipmentIdNum(@PathVariable(value="inventersn") String inventersn,@PathVariable(value="offset") int offset,@PathVariable(value="limit") int limit) {
    	List<TbInfo> history = this.historyService.getHistoryByequipment_idNum(inventersn,offset,limit);
    	return history;
    }
   
//根据时间查询
    @ResponseBody
    @RequestMapping(value="/DataFrom/{time1}/DataTo/{time2}",method= {RequestMethod.GET})
    public List<TbInfo> selectByEquipmentIdTime(@PathVariable(value="time1") String time1,@PathVariable(value="time2") String time2) {
    	List<TbInfo> history = this.historyService.getHistoryByEquipment_idTime(time1, time2);
    	return history;
    }
    
 //根据时间查询单个设备
    @ResponseBody
    @RequestMapping(value="/SNCode/{inventersn}/DataFrom/{time1}/DataTo/{time2}",method= {RequestMethod.GET})
    public List<TbInfo> selectByEquipmentIdOneTime(@PathVariable(value="inventersn")String inventersn,@PathVariable(value="time1")String time1,@PathVariable(value="time2")String time2) {
    	List<TbInfo> history = this.historyService.getHistoryByEquipment_idOneTime(inventersn, time1, time2);
    	 
    	return history;
    }
   
    
 //获取逆变器数据
    @RequestMapping(value="/getinfo",method= {RequestMethod.POST},consumes = "application/json")
   
    public String getinfo(HttpServletRequest request) {
    	

		// 读取请求内容
 
    	 int totalBytes = request.getContentLength();
	        System.out.println("当前数据总长度:" + totalBytes);
		
        File newfile = new File("testnew.txt");
    	FileOutputStream fos = null;
		try {
			fos = new FileOutputStream(newfile);
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
    	OutputStreamWriter osw = new OutputStreamWriter(fos);
    	BufferedWriter bw = new BufferedWriter(osw);
    	try {
    	    
   
    		
    		 /*
    	    Map map=request.getParameterMap();  
    	    Set keSet=map.entrySet();
     	    System.out.println("size"+keSet.size());
     	    
     	    
     	   
    	    for(Iterator itr=keSet.iterator();itr.hasNext();){  

    	        Map.Entry me=(Map.Entry)itr.next();  
    	        Object ok=me.getKey();  
    	        Object ov=me.getValue();  
    	        String[] value=new String[1];  
    	        
    	        if(ov instanceof String[]){  
    	            value=(String[])ov;  
    	        }else{  
    	            value[0]=ov.toString();  
    	        }  
    	  
    	        for(int k=0;k<value.length;k++){  
    	        	
    	        	bw.write(ok+"="+value[k]);
    	        	
    	            System.out.println(ok+"="+value[k]);  
    	            
    	            
    	            
    	        }  
    	      }  
    		//*/
    		
    	
    	System.out.println("done");
    	bw.close();
    	osw.close();
    	fos.close();
    	} catch (IOException e) {
    	// TODO Auto-generated catch block
    	e.printStackTrace();
    	}
    	


        return "returnr";
    }
    
//获取所有数据
    @ResponseBody
    @RequestMapping(value="/all",method= {RequestMethod.GET})
    public List<TbInfo> selectAll(){
    	return this.historyService.selectAll();
    }
}