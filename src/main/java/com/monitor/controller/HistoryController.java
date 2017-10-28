package com.monitor.controller;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
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
   

//获取所有数据
    @ResponseBody
    @RequestMapping(value="/all",method= {RequestMethod.GET})
    public List<TbInfo> selectAll(){
    	return this.historyService.selectAll();
    }
}