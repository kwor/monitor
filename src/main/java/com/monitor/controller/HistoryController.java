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
import com.google.gson.Gson;
import com.monitor.dao.GdStationField;
import com.monitor.dao.XmStationField;
import com.monitor.pojo.History;
import com.monitor.pojo.TbInfo;
import com.monitor.service.IHistoryService;
import com.monitor.service.ITbInfoService;
import com.monitor.util.RequestJson;

@Controller
@RequestMapping("/")
public class HistoryController {

    @Resource
    private IHistoryService historyService;
    @Resource
	private ITbInfoService gdErrorService;
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
    	Gson gson = new Gson();
    	//获取字节流长度
    	int totalBytes = request.getContentLength();
    	if(totalBytes>0) {
    		try {
    			
    			String str=new RequestJson().getRequestJsonString(request);
    			XmStationField field = null;
    			field = gson.fromJson(str, XmStationField.class);
    			TbInfo gd=new TbInfo();
    			gd.setAddtime(field.getZd());
    			gd.setStationid(field.getG());
    			gd.setInventersn(field.getZa());
    			gd.setIdesc("小麦逆变器，此处setInventersn=采集器sn");
    			gd.setPower("0");
    			gd.setStatus("Offline");
    			gd.setEday(field.getX1bd());
    			gd.setEtotal(field.getX1bc());
    			gd.setErrormsg(field.getX1fs());
    			//错误信息反馈
    			gdErrorService.insertError(gd);
    			
    		} catch (IOException e2) {
    			// TODO Auto-generated catch block
    			e2.printStackTrace();
    		}
    	 
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