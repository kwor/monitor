package com.monitor.controller;
import java.io.IOException;
import java.util.Iterator;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
 import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
 
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
 
import com.monitor.pojo.TbInfo;
import com.monitor.pojo.XmStationField;
import com.monitor.service.ITbInfoService;

import com.monitor.util.RequestJson;

 
@Controller
@RequestMapping("/")
public class XmController {
	@Resource
	private ITbInfoService tbInfoService;
 //小麦平台数据获取
    @RequestMapping(value="/getinfo",method= {RequestMethod.POST},consumes = "application/json")
    public String getinfo(HttpServletRequest request) {
    	Gson gson = new Gson();
    	JsonParser parser = new JsonParser();
    	//获取字节流长度
    	int totalBytes = request.getContentLength();
    	if(totalBytes>0) {
    		try {
    			String str=null;
    			str=new RequestJson().getRequestJsonString(request);
    			//System.out.println(str);
    			XmStationField field = null;
    			 
    			JsonElement jsonstr=parser.parse(str);
    			
    			JsonArray jsonArray2=null;
    			   if(jsonstr.isJsonArray()) {
    				   jsonArray2=jsonstr.getAsJsonArray();
    			   }
    			   Iterator it2=jsonArray2.iterator();
    			   while (it2.hasNext()) {
    				   JsonElement e2 = (JsonElement) it2.next();
    	    			field = gson.fromJson(e2, XmStationField.class);
    	    			TbInfo gd=new TbInfo();
    	    			gd.setAddtime(field.getZd());
    	    			gd.setStationid(field.getG());
    	    			gd.setInventersn(field.getZa());
    	    			gd.setIdesc("小麦逆变器，此处setInventersn=采集器sn");
    	    			gd.setPower("0");
    	    			gd.setStatus("Offline");
    	    			gd.setEday(field.getX1bd());
    	    			gd.setEtotal(field.getX1bc());
    	    			//错误信息反馈
    	    			if(field.getX1fs().equals("")) {
    	    				gd.setErrormsg("N/A");
    	    			}else {
    	    				gd.setErrormsg(field.getX1fs());
    	    			}

    	    			tbInfoService.insertInfo(gd);

    			   }
    	    			
    		} catch (IOException e2) {
    			// TODO Auto-generated catch block
    			e2.printStackTrace();
    		} 
    	}

        return "returnr";
    }
    
}
