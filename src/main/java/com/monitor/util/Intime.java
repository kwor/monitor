package com.monitor.util;

 import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Intime {
 
	public static boolean isBelong(){

	    SimpleDateFormat df = new SimpleDateFormat("HH:mm");//设置日期格式
	    Date now =null;
	    Date beginTime = null;
	    Date endTime = null;
	    try {
	        now = df.parse(df.format(new Date()));
	        beginTime = df.parse("06:00");
	        endTime = df.parse("18:00");
	    } catch (Exception e) {
	        e.printStackTrace();
	    }

	    Boolean flag = belongCalendar(now, beginTime, endTime);
	    return flag;
	}

/**
     * 判断时间是否在时间段内
     * @param nowTime
     * @param beginTime
     * @param endTime
     * @return
     */
    public static boolean belongCalendar(Date nowTime, Date beginTime, Date endTime) {
        Calendar date = Calendar.getInstance();
        date.setTime(nowTime);

        Calendar begin = Calendar.getInstance();
        begin.setTime(beginTime);

        Calendar end = Calendar.getInstance();
        end.setTime(endTime);

        if (date.after(begin) && date.before(end)) {
            return true;
        } else {
            return false;
        }
    }
}
