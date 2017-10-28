package com.monitor.controller;
import java.io.Console;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.monitor.service.impl.GdAccountService;
import com.monitor.service.impl.SjAccountService;
import com.monitor.util.HttpTool;

 
@Controller
@RequestMapping("/")
public class SJController {
    
	@Resource
	private SjAccountService sjAccountService;
    @ResponseBody
    @RequestMapping(value="/getsjuser",method= {RequestMethod.GET})
    public String selectByequipmentIdNum() {
    	//String access_token=sjAccountService.getToken();
    
    	String access_token="9be9eb38dca04661bfb731a0de8f6b88";
    	String openid="15426";
     	String surl="http://api.saj-solar.com/user/c_user_list?page=1&perpage=100&ACCESS_TOKEN="+access_token;

    	String jsoninfo;
    	try {
			jsoninfo = new HttpTool().sendPost("", surl);
			System.out.println(jsoninfo);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	
    	return "1";
    }
}
