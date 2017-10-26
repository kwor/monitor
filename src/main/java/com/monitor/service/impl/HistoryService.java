package com.monitor.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.monitor.dao.HistoryMapper;
import com.monitor.pojo.History;
import com.monitor.pojo.TbInfo;
import com.monitor.service.IHistoryService;

@Service("historyService")
public class HistoryService implements IHistoryService {

    @Resource
    private HistoryMapper historyDao;
    //根据ID查询所有
    public List<TbInfo> getHistoryByequipment_id(String inventersn) {
        List<TbInfo> inventersn1=this.historyDao.selectByequipment_id(inventersn);
        return inventersn1;
    }
    
    //根据ID查询最新数据
    public List<TbInfo> getHistoryByequipment_idNum(String inventersn,int offset,int limit) {
    	List<TbInfo> selectByequipment_idNum=this.historyDao.selectByequipment_idNum(inventersn,offset,limit);
    	return selectByequipment_idNum;
    }
    
    //根据时间查询
    public List<TbInfo> getHistoryByEquipment_idTime(String time1,String time2){
    	List<TbInfo> selectByEquipment_idTime=this.historyDao.selectByEquipment_idTime(time1, time2);
    	return selectByEquipment_idTime;
    }
    
    //根据时间查询单个设备
    public List<TbInfo> getHistoryByEquipment_idOneTime(String inventersn,String time1,String time2){
    	List<TbInfo> selectByEquipment_idOneTime=this.historyDao.selectByEquipment_idOneTime(inventersn, time1, time2);
    	return selectByEquipment_idOneTime;
    }

    //查询所有数据
    public List<TbInfo> selectAll(){
    	return this.historyDao.selectAll();
    }
    
}