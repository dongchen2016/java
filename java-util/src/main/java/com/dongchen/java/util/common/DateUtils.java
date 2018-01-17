package com.dongchen.java.util.common;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @author: mdd
 * @date:2017/12/4
 */
public class DateUtils {

    /**
     * 增加或者减少几天
     * @param
     * @return
     */
    public static Date addOrMinusDays(Date date, int days)
    {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.add(Calendar.DAY_OF_MONTH, days);
        return c.getTime();
    }

    /**
     * 日期转化为时间
     * yyyyMMdd,HHmmss,yyyyMMddHHmmss
     * @param
     * @return
     */
    public static String date2String(Date date, String formateStyle){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(formateStyle);
        return simpleDateFormat.format(date);
    }

    /**
     * 时间字符串转DATE
     *
     * @param str
     * @return
     */
    public static Date string2Date(String str, String format) {
        if (null == str || "".equals(str)) {
            return null;
        }
        // 定义日期/时间格式
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        Date date;
        try {
            // 转换日期/时间格式
            date = sdf.parse(str);
            // 判断转换前后时间是否一致
            if (!str.equals(sdf.format(date))) {
                date = null;
            }
        } catch (ParseException e) {
            date = null;
        }

        return date;
    }

    /**
     * 通过时间秒毫秒数判断两个时间的间隔
     * @param date1
     * @param date2
     * @return
     */
    public static int differentDaysByMillisecond(Date date1, Date date2)
    {
        int days = (int) ((date2.getTime() - date1.getTime()) / (1000*3600*24));
        return days;
    }

    /**
     * 比较两个时间大小
     * @param
     * @return
     */
    public static int compareTime(Date target, Date origin){
        long time1 = target.getTime();
        long time2 = origin.getTime();
        if (time2>time1){
            return 1;
        }else if (time2 == time1){
            return 0;
        }else {
            return -1;
        }
    }

    /**
     * type=yyyy，表示增加几年
     * type=MM,表示增加几个月
     * type=dd,表示增加几天
     * type=HH，表示增加几小时
     * type= mm,表示增加几分钟
     * type= ss,表示增加几秒钟
     * @param
     * @return
     */
    public static Date addTime(Date date, String type, int num)
    {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        if ("yyyy".equals(type)){
            c.add(Calendar.YEAR, num);
        }else if ("MM".equals(type)){
            c.add(Calendar.MONTH, num);
        }else if ("dd".equals(type)){
        c.add(Calendar.DAY_OF_MONTH, num);
        }else if ("HH".equals(type)){
            c.add(Calendar.HOUR_OF_DAY,num);
        }else if("mm".equals(type)){
            c.add(Calendar.MINUTE,num);
        }else if("ss".equals(type)){
            c.add(Calendar.SECOND,num);
        }
        return c.getTime();
    }

    public static void main(String[] args){

        System.out.println("当前时间+1天=" + addOrMinusDays(new Date(),1));
        System.out.println("当前时间-1天=" + addOrMinusDays(new Date(),-1));
        System.out.println("获取当前时间年月日" + date2String(new Date(),"yyyyMMdd"));
        System.out.println("获取当前时间时分秒" + date2String(new Date(),"HHmmss"));
        System.out.println("获取当前时间" + date2String(new Date(),"yyyyMMddHHmmss"));
    }
}
