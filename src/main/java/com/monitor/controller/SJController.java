package com.monitor.controller;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonPrimitive;
import com.google.gson.reflect.TypeToken;
import com.monitor.pojo.GdAccount;
import com.monitor.pojo.GdStationError;
import com.monitor.pojo.SjAlarmField;
import com.monitor.pojo.SjPlantField;
import com.monitor.pojo.SjPlantinfo;
import com.monitor.pojo.SjSninfo;
import com.monitor.pojo.SjSninfoField;
import com.monitor.pojo.TbInfo;
import com.monitor.service.ITbInfoService;
import com.monitor.service.impl.SjService;
import com.monitor.util.HttpTool;
import com.mysql.jdbc.Field;

 
@Controller
@RequestMapping("/")
public class SJController {
    
	@Resource
	private SjService sjService;
	@Resource
	private ITbInfoService tbInfoService;
	

    @ResponseBody
    @RequestMapping(value="/getplant/{page}",method= {RequestMethod.GET})
    public String selectplant(HttpServletRequest request,@PathVariable(value="page")int page) {
    	//String access_token=sjAccountService.getToken();//这里的返回结果需要解析
        //int page=1;
    	String access_token="9be9eb38dca04661bfb731a0de8f6b88";
     	String surl="http://api.saj-solar.com/plant/list?page="+page+"&perpage=100&access_token="+access_token;
    	
		JsonParser parser = new JsonParser();
		Gson gson = new Gson();
		 
    	String jsoninfo;
    	try {
			jsoninfo =  HttpTool.sendPost("", surl);
 			
		   JsonElement el2=parser.parse(jsoninfo);
		   //System.out.println(el2);
		   JsonObject element = el2.getAsJsonObject();
		   
		   JsonObject dataJson = element.getAsJsonObject("data");
		   
		   JsonArray arrayJson = dataJson.getAsJsonArray("plants");
		   
		   //System.out.println(arrayJson);
		   if(dataJson.isJsonArray()) {
			   arrayJson=dataJson.getAsJsonArray();
		   }
		   //System.out.println(jsonArray2);
		   
		   GdStationError field2=null;
		   Iterator it2=arrayJson.iterator();
		   while (it2.hasNext()) {
			JsonElement e2 = (JsonElement) it2.next();
			SjPlantField field=gson.fromJson(e2, SjPlantField.class);
	       
			SjPlantinfo sj=new SjPlantinfo();
			sj.setCity(field.getCity());
			sj.setCountry(field.getCountry());
			sj.setCreateDate(field.getCreate_date());
			sj.setCurrentPower(field.getCurrent_power());
			sj.setImageUrl(field.getImage_url());
			sj.setInstaller(field.getInstaller());
			sj.setLatitude(field.getLatitude());
			sj.setName(field.getName());
			sj.setOperator(field.getOperator_());
			sj.setPeakPower(field.getPeak_power());
			sj.setPlantId(field.getPlant_id());
			sj.setStatus(field.getStatus());
			sj.setTotalEnergy(field.getTotal_energy());
			sj.setUserId(field.getUser_id());
			sj.setLocale(field.getLocale());
			sj.setLongitude(field.getLongitude());
			sjService.insert(sj);
		   // System.out.println("field.getPlant_id():"+field.getPlant_id());
		   	
	    	}
		//*/
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	
    	return "1";
    }
    @ResponseBody
    @RequestMapping(value="/getplantdata/{num1}/{num2}",method= {RequestMethod.GET})
    public String selectplantdata(HttpServletRequest request,@PathVariable(value="num1")int num1,@PathVariable(value="num2")int num2) {
    	//String access_token=sjAccountService.getToken();//这里的返回结果需要解析
    	String access_token="9be9eb38dca04661bfb731a0de8f6b88";
    	
    	List<SjPlantinfo> plantlist=sjService.selectTop(num1, num2);
    	Iterator list = plantlist.iterator();
        
    	// 循环账户列表
    	while (list.hasNext()) {
    		SjPlantinfo sjPlantinfo = (SjPlantinfo) list.next();
    		String plant_id=sjPlantinfo.getPlantId();
     	String surl="http://api.saj-solar.com/device/list?page=1&perpage=100&plant_id="+plant_id+"&access_token="+access_token;
		JsonParser parser = new JsonParser();
		Gson gson = new Gson();
    	String jsoninfo;
    	try {
		   jsoninfo =  HttpTool.sendPost("", surl);
		   JsonElement el2=parser.parse(jsoninfo);
 		   JsonObject element = el2.getAsJsonObject();
		   JsonObject dataJson = element.getAsJsonObject("data");
		   JsonArray devicesJson = dataJson.getAsJsonArray("devices");
		   JsonArray jsonArray2=null;
		   if(devicesJson.isJsonArray()) {
			   jsonArray2=devicesJson.getAsJsonArray();
		   }
		   
		   Iterator it2=jsonArray2.iterator();
		   while (it2.hasNext()) {
				JsonElement e2 = (JsonElement) it2.next();
				SjSninfoField field=gson.fromJson(e2, SjSninfoField.class);
				//插入sn数据到库
				SjSninfo sj=new SjSninfo();
				sj.setDeviceId(field.getDevice_id());
				sj.setDeviceSn(field.getDevice_sn());
				sj.setDtype(field.getDType());
				sj.setEmonth(field.getEMonth());
				sj.setEtoday(field.getEToday());
				sj.setEtotal(field.getETotal());
				sj.setLastUpdateTime(field.getLast_update_time());
				sj.setManufacturer(field.getManufacturer());
				sj.setModel(field.getModel());
				sj.setSyspower(field.getSysPower());
				sj.setType(field.getType());
				sj.setTzone(field.getTZone());
				sj.setUpdatadate(field.getUpdataDate());
				
				int res=sjService.insert(sj);
				//*/
				if(res>0) {
					TbInfo gd=new TbInfo();
					//获取当前时间戳
			        long time = System.currentTimeMillis();
			        String nowTimeStamp = String.valueOf(time / 1000);
			        
					gd.setAddtime(nowTimeStamp);
					gd.setStationid(field.getDevice_id());
					gd.setInventersn(field.getDevice_sn());
					gd.setIdesc("三晶逆变器");
					gd.setPower("0");
					gd.setStatus("Offline");
					gd.setEday(field.getEToday());
					gd.setEtotal(field.getETotal());
					
					gd.setErrormsg("N/A");
					
					//错误信息反馈
					tbInfoService.insertInfo(gd);
				}
				
		   }
		 

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	}
    	
    	return "1";
    }
}
