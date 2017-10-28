package com.monitor.controller;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import javax.annotation.Resource;
import javax.json.Json;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.monitor.dao.GdStationField;
import com.monitor.pojo.GdAccount;
import com.monitor.pojo.TbInfo;
import com.monitor.pojo.GdSninfo;
import com.monitor.pojo.GdStationError;
import com.monitor.service.ITbInfoService;
import com.monitor.service.IGdSninfoService;
import com.monitor.service.impl.GdAccountService;
import com.monitor.util.HttpTool;

import java.io.FileNotFoundException;
import java.io.FileReader;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonIOException;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;

@Controller
@RequestMapping("/")
public class GdAccountController {

	@Resource
	private GdAccountService gdAccountService;
	@Resource
	private IGdSninfoService gdSninfoService;
	@Resource
	private ITbInfoService gdErrorService;
	@ResponseBody
	//根据账户查询所有信息
	@RequestMapping(value="account/{num1}/{num2}",method= {RequestMethod.GET})
	public List<GdAccount> selectByGdAccount(HttpServletRequest request,@PathVariable(value="num1")int num1,@PathVariable(value="num2")int num2){		
		JsonParser parser = new JsonParser();  //创建json解析器
		Gson gson = new Gson();
		List<String> stationIdList = null;
		// 1 先获取账户列表
		List<GdAccount> accountlist= gdAccountService.selectByGdAccount(num1,num2);		
		Iterator list = accountlist.iterator();
		// 如果有账户信息，则先查出tb_gd_sninfo表中的 stationId,用于后面判断是插入还是更新
		if(list.hasNext())
		{
			stationIdList = gdSninfoService.selectStationid();
		}
		// 循环账户列表
		while (list.hasNext()) {
			GdAccount gdaccount = (GdAccount) list.next();
			//获取account表里的所有数据
			String account = gdaccount.getAccount();
		    //通过account获取stationId的地址
		    String url = "http://www.goodwe-power.com/mobile/GetMyPowerStationByUser?userName="+account;
		    HttpURLConnection connection = null;		 		 		 			
		    try {
				 //通过get方式获取地址并获取stationId
				 String jsoninfo=new HttpTool().sendPost("", url);
				 //获取出Json格式，进行解析
				 JsonElement el = parser.parse(jsoninfo);			 
				 JsonArray jsonArray = null;
				 if(el.isJsonArray()){
				 jsonArray = el.getAsJsonArray();			 			
			 }			 
			 //遍历JsonArray对象
			 GdStationField field = null;
			 Iterator it = jsonArray.iterator();
			 while(it.hasNext()){
				 JsonElement e = (JsonElement)it.next();			 			
				 //JsonElement转换为JavaBean对象
				 field = gson.fromJson(e, GdStationField.class);	
				 //fza 2017.10.27  
				 GdSninfo snInfo = new GdSninfo(account,field.getStationId(), field.getStationName(), field.getStation_pic(),
						 field.getCurrentPower().substring(0,field.getCurrentPower().length()-2), 
						 field.getCapacity().substring(0,field.getCapacity().length()-2), 
						 field.getValue_eDayTotal().substring(0,field.getValue_eDayTotal().length()-3), 
						 field.getValue_eTotal().substring(0,field.getValue_eTotal().length()-3), 					 
						 field.getValue_dayIncome(),
						 field.getValue_totalIncome());

				 //如果tb_gd_sninfo有数据
				 if(stationIdList.size() > 0)
				 {
					 //判断如果存在执行更新操作，如果不存在执行插入操作
					 if(stationIdList.contains(field.getStationId()))
					 {
						 //更新tb_gd_sninfo
						 gdSninfoService.updateByStationId(snInfo);
					 }
					 else
					 {
						 //把stationid插入数据库
						 gdSninfoService.insertSn(snInfo);
					 }
				 }
				//如果tb_gd_sninfo没有有数据，直接插入
				 else {
					 //把stationid插入数据库
					 gdSninfoService.insertSn(snInfo);
				}
			 }
		} 
			catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return null;
	}	
	@ResponseBody
	@RequestMapping(value="insertInfo",method= {RequestMethod.GET})
	public List<String> insertError() {
		List<String> stationid=gdSninfoService.selectStationid();
		Iterator stationid2=stationid.iterator();
		while (stationid2.hasNext()) {
			String stationid3 = (String) stationid2.next();
			
		
		JsonParser parser = new JsonParser();
		Gson gson = new Gson();
		  //通过stationId获取电站信息列表地址 
		   String url2="http://www.goodwe-power.com/mobile/GetMyDeviceListById?stationId="+stationid3;
		   String jsoninfo2;
		try {
			jsoninfo2 = new HttpTool().sendPost("", url2);
		
		   JsonElement el2=parser.parse(jsoninfo2);
		   JsonArray jsonArray2=null;
		   if(el2.isJsonArray()) {
			   jsonArray2=el2.getAsJsonArray();
		   }
		   GdStationError field2=null;
		   Iterator it2=jsonArray2.iterator();
		   while (it2.hasNext()) {
			JsonElement e2 = (JsonElement) it2.next();
			field2=gson.fromJson(e2, GdStationError.class);
			//获取当前时间戳
	        long time = System.currentTimeMillis();
	        String nowTimeStamp = String.valueOf(time / 1000);
			//错误列表接口
			TbInfo gd=new TbInfo();
			gd.setAddtime(nowTimeStamp);
			gd.setStationid(stationid3);
			gd.setInventersn(field2.getInventersn());
			gd.setIdesc(field2.getIdesc());
			gd.setPower(field2.getPower());
			gd.setStatus(field2.getStatus());
			gd.setEday(field2.getEday());
			gd.setEtotal(field2.getEtotal());
			gd.setErrormsg(field2.getErrormsg());
			//错误信息反馈
			gdErrorService.insertInfo(gd);
		   	
		}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
		   return null;
	}
}
