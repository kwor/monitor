package com.monitor.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.monitor.pojo.TbInfo;
import com.monitor.service.impl.TbInfoService;

@Controller
@RequestMapping("/")
@ResponseBody
public class TbInfoController {
	
	@Resource
	private TbInfoService tbInfoService;
	@RequestMapping(value="selectByInventersn/{inventersn}",method= {RequestMethod.GET})
	public List<TbInfo> selectByInventersn(@PathVariable(value="inventersn")String inventersn){
		
		return tbInfoService.selectByInventersn(inventersn);
		
	}

}
