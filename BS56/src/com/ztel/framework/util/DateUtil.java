package com.ztel.framework.util;
import java.util.*;

import org.springframework.stereotype.Component;

import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class DateUtil {
	
	 public static String getyyyy_mm_dd()
	 {
		 java.text.SimpleDateFormat formatter = new java.text.SimpleDateFormat("yyyy-MM-dd");
		   String time = formatter.format(new java.util.Date());
		   return time;
	 }
	 
	 public static Date getDateyyyy_mm_dd() throws ParseException 
	 {
		 SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		 Date date = formatter.parse(formatter.format(new Date())); 
		 return date;
	 }
	 
	 public static String getPreyyyy_mm_dd()
	 {
		 java.text.SimpleDateFormat formatter = new java.text.SimpleDateFormat("yyyy-MM-dd");
		   String time = formatter.format(new java.util.Date());
		   int pre = Integer.parseInt(time.substring(0,4))-1;
		   String pretime= Integer.toString(pre)+time.substring(4);
		   return pretime;
	 }    
	 public static String getYesterdayyyyy_mm_dd()
	 {
		 String yearmonth=getyyyy();
		 String day=getdd();
		 int pre = Integer.parseInt(day)-1;
		 java.text.SimpleDateFormat formatter = new java.text.SimpleDateFormat("yyyy-MM-dd");
		 Calendar calendar = Calendar.getInstance();
		  calendar.set(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH)-1, calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
		  String maxDate=formatter.format(calendar.getTime()); 
		  String pretime="";
		 if(pre==0)
		 {
			 pretime=maxDate;
		 }
		 else
		 {
		  pretime=yearmonth+"-"+Integer.toString(pre);
		 }
		 return pretime;
	 }    
	 public static String getyyyy_mm_dd_hh_mi()
	 { 
		 java.text.SimpleDateFormat formatter = new java.text.SimpleDateFormat("yyyy-MM-dd HH:MM");
		   String time = formatter.format(new java.util.Date());
		   return time;
		   
	 }
	 public static String getyyyy_mm_dd_hh_mi_s()
	 { 
		 java.text.SimpleDateFormat formatter = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		 String time = formatter.format(new java.util.Date());
		 return time;
		 
	 }
	 
	 public static Date getDateyyyy_mm_dd_hh_mi_s() throws Exception{
		 SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		 Date date = formatter.parse(formatter.format(new Date())); 
		 return date;
	 }
	 
	 
	 public static String getyyyy_mm()
	 {
		 java.text.SimpleDateFormat formatter = new java.text.SimpleDateFormat("yyyy-MM");
		   String time = formatter.format(new java.util.Date());
		   return time;
	 }
	 
	 public static String getyyyy_mm_01()
	 {
		 java.text.SimpleDateFormat formatter = new java.text.SimpleDateFormat("yyyy-MM");
		   String time = formatter.format(new java.util.Date());
		   return time+"-01";
	 }
	 
	 public static String getyyyymm()
	 {
		 java.text.SimpleDateFormat formatter = new java.text.SimpleDateFormat("yyyyMM");
		   String time = formatter.format(new java.util.Date());
		   return time;
	 }
	 public static String getyyyymmdd()
	 {
		 java.text.SimpleDateFormat formatter = new java.text.SimpleDateFormat("yyyyMMdd");
		   String time = formatter.format(new java.util.Date());
		   return time;
	 }
	 public static String getyyyy()
	 {
		 java.text.SimpleDateFormat formatter = new java.text.SimpleDateFormat("yyyy");
		   String time = formatter.format(new java.util.Date());
		   return time;
	 }
	 public static String getmm()
	 {
		 java.text.SimpleDateFormat formatter = new java.text.SimpleDateFormat("MM");
		   String time = formatter.format(new java.util.Date());
		   return time;
	 }
	 public static String getdd()
	 {
		 java.text.SimpleDateFormat formatter = new java.text.SimpleDateFormat("dd");
		   String time = formatter.format(new java.util.Date());
		   return time;
	 }
	 
	 /**
	  * ȡ�ϸ��µ��·�
	  * @return
	  */
	 public static String getmm_sy()
	 {
		 java.text.SimpleDateFormat formatter = new java.text.SimpleDateFormat("yyyyMM");
		 String bysj = formatter.format(new java.util.Date());
		 String sysj="";
		 int syjInt = Integer.parseInt(bysj)-1;//timecon���ϸ���ʱ��
			if(Integer.toString(syjInt).substring(4).equals("00")){
				sysj = Integer.toString(Integer.parseInt(bysj.substring(0,4))-1)+"12";
			}
			else
			{
				sysj=Integer.toString(syjInt);
			}
			sysj = sysj.substring(4);

		 return sysj;
	 }
	 
	 /**
	  * ȡ����ʱ����ϸ��µ��·�
	  * @return
	  */
	 public static String getmm_sy(String sj)
	 {

		 String bysj = sj;
		 String sysj="";
		 int syjInt = Integer.parseInt(bysj)-1;//timecon���ϸ���ʱ��
			if(Integer.toString(syjInt).substring(4).equals("00")){
				sysj = Integer.toString(Integer.parseInt(bysj.substring(0,4))-1)+"12";
			}
			else
			{
				sysj=Integer.toString(syjInt);
			}
			//sysj = sysj.substring(4);

		 return sysj;
	 }
	 
	 /**
	  * �жϵ�ǰ���������ڼ�
	  * @param pTime
	  * @return
	  * @throws Exception
	  */
	 public static int dayForWeek(String pTime) throws Exception {   
		 SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");   
		 Calendar c = Calendar.getInstance();   
		 c.setTime(format.parse(pTime));   
		 int dayForWeek = 0;   
		 if(c.get(Calendar.DAY_OF_WEEK) == 1){   
		  dayForWeek = 7;   
		 }else{   
		  dayForWeek = c.get(Calendar.DAY_OF_WEEK) - 1;   
		 }   
		 return dayForWeek;   
		}  

	 /**
	  * ȡ��ǰ�������ܵ�����һ�������������
	  * @return
	  */
	 public static Map getFirstAndEndInWeek() {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");  
		Map map = new HashMap();
		 
		Calendar c = Calendar.getInstance();
		// Ĭ��ʱ��ÿ�ܵ�һ��Ϊ�����գ���Ҫ����һ��
		c.setFirstDayOfWeek(Calendar.MONDAY);
		Date current = c.getTime();
		c.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
		Date first = c.getTime();
		c.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);
		Date last = c.getTime();
		
		map.put("monday", format.format(first));
		map.put("sunday", format.format(last));
		
		return map;
	}
	 
	 /**
	  * ȡ����ȵĵ�һ��1��1��
	  */
	 public  static String getFirstDayOfTheYear(){
		 String year=getyyyy();
		 int january=Calendar.JANUARY+1;
		 String time=year+"-"+january+"-"+january;
		 return time;
	 }
	 
	 /**
	  * ȡĳһ���ĳһ���ж�����
	  * @param year
	  * @param month
	  * @return
	  */
	 public static int getDayCount(String year,String month){
			int count=0;
			Calendar cal = Calendar.getInstance();
			cal.set(Calendar.YEAR, Integer.parseInt(year));
			cal.set(Calendar.MONTH, Integer.parseInt(month)-1);//Java�·ݴ�0��ʼ��
			count=cal.getActualMaximum(Calendar.DAY_OF_MONTH);
			return count;
		}
	 
	 /**
	  * ȡ��һ����,������ݼ��·�
	  * @return 
	  */
	 public static String getyyyy_mm_sy()
	 {
		 java.text.SimpleDateFormat formatter = new java.text.SimpleDateFormat("yyyy-MM");
		 String bysj = formatter.format(new java.util.Date());
		 String sysj="";
		 int syjInt = Integer.parseInt(bysj.substring(5))-1;//timecon���ϸ���ʱ��
			if(syjInt==0){
				sysj = Integer.toString(Integer.parseInt(bysj.substring(0,4))-1)+"-12";
			}
			else
			{
				if(syjInt<10){
					sysj=bysj.substring(0,5)+"0"+syjInt;
				}else{
					sysj=bysj.substring(0,5)+syjInt;
				}
			}
		 return sysj;
		 
		 
	 }
	 
	 /**
	  * ȡָ�����ڵ�����
	  * @param date
	  * @return
	  */
	 public static String getYesterdayyyyy_mm_dd(String date)
	 {
		 java.text.SimpleDateFormat formatter = new java.text.SimpleDateFormat("yyyy-MM-dd");
		 try {
			date=formatter.format(formatter.parse(date));
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		 String year=date.substring(0,4);
		 String month=date.substring(5,7);
		 String day=date.substring(8);
		 int pre = Integer.parseInt(day)-1;
		 if(pre==0){
			 if("01".equals(month)||"1".equals(month)){
				 year=Integer.parseInt(year)-1+"";
				 month="12";
				 day="31";
			 }else{
				 month=Integer.parseInt(month)-1+"";
				 day=getDayCount(year, month)+"";
			 }
		 }else{
			 day=pre+"";
		 }
		 String retime="";
		try {
			retime = formatter.format(formatter.parse(year+"-"+month+"-"+day));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		 return retime;
	 } 
	 
	 /**
	  * ȡ��ǰʱ��,������ʱ��
	  * @return 
	  */
	 public static String getGMT_8()
	 {
		 String str="";
		 String pattern = "yyyy-MM-dd HH:mm:ss";
	     TimeZone timezone=TimeZone.getTimeZone("GMT+08:00");
	     java.text.SimpleDateFormat df = new java.text.SimpleDateFormat(pattern);
	     df.setTimeZone(timezone);
	     java.util.Date date = new java.util.Date();
	     str = df.format(date);
	     if(str.length()>19)str=str.substring(0,19);
	     return str;
	 }
	 
	 /**
	  * ȡ��ǰʱ���1970������������������������ˮ��
	  * @return 
	  */
	 public static long getSecond()
	 {
		 java.util.Date date = new java.util.Date();
		 long second = date.getTime()/1000;
		 return second;
	 }
	 
	 /**
	  * ȡ��ǰʱ���1970������������������������ˮ��,������ˮ�������ƣ�����ϣ������ܿ�����7λ��
	  * @return 
	  */
	 public static String getLessSecond()
	 {
		 java.util.Date date = new java.util.Date();
		 String second = date.getTime()/1000+"";
		 String lessSecond = second.substring(second.length()-7,second.length());
		 return lessSecond;
	 }
	 
	 /**
	  * ת��ʱ���ʽ����2012-5-5ת��20120505
	  * @return 
	  */
	 public static String transferyyyy_mm_ddToyyyyMMDD(String yyyy_mm_dd)
	 {
		 if(yyyy_mm_dd==null || yyyy_mm_dd.indexOf("-")<0 || yyyy_mm_dd.length()<8)
			 return getyyyymmdd();
		 String[] time =  yyyy_mm_dd.split("-");
		 String MM = time[1];
		 String DD = time[2];
		 if (time[1].length()<2) MM = "0"+time[1];
		 if (time[2].length()<2) DD = "0"+time[2];
		 
		 return time[0]+MM+DD;
	 }
	 
	 /**
		 * ��������ʱ���ʱ����λΪ�룬ʱ���ʽΪ��yyyy-MM-dd HH:mm:ss
		 * @param begtime
		 * @param endtime
		 * @return
		 * @throws ParseException 
		 */
		public static long getLag(String begtime,String endtime) throws ParseException{
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			long seconds=0;
			Date d1 = df.parse(begtime);
		    Date d2 = df.parse(endtime);
		    long diff = d2.getTime() - d1.getTime();
		    seconds = diff / 1000;
			return seconds;
		}
		
		/**
		 * ȡ��ǰ����Ϊ���ڼ�  1Ϊ������  һ������
		 * @param date
		 * @return
		 */
		public static int getWeek(String date){
			int week=0;
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			Calendar c = Calendar.getInstance();
			try {
				c.setTime(format.parse(date));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        week=c.get(Calendar.DAY_OF_WEEK);
			return week;
		}
		
		public static void main(String[] args){
		}
}
