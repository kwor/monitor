package com.monitor.controller;
import java.io.IOException;
import java.util.Iterator;

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
import com.monitor.pojo.GdStationError;
import com.monitor.pojo.SjPlantField;
import com.monitor.pojo.TbInfo;
import com.monitor.service.impl.SjService;
import com.monitor.util.HttpTool;

 
@Controller
@RequestMapping("/")
public class SJController {
    
	@Resource
	private SjService sjAccountService;
    @ResponseBody
    @RequestMapping(value="/getplant/{page}",method= {RequestMethod.GET})
    public String selectByequipmentIdNum(HttpServletRequest request,@PathVariable(value="page")int page) {
    	//String access_token=sjAccountService.getToken();//这里的返回结果需要解析
        //int page=1;
    	String access_token="9be9eb38dca04661bfb731a0de8f6b88";
     	String surl="http://api.saj-solar.com/plant/list?page="+page+"&perpage=100&access_token="+access_token;
    	
		JsonParser parser = new JsonParser();
		Gson gson = new Gson();
		 
    	String jsoninfo;
    	try {
			jsoninfo = new HttpTool().sendPost("", surl);
 			
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
	       
		 
		   	
	    	}
		//*/
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	
    	return "1";
    }
}
