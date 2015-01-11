package com.system.util;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;


/**
 * 生成20位不重复的数字编号
 * 年月日时分秒毫秒
 * 再加计数器数字
 * @author Michael
 * Jan 21, 2014
 */
public class SidGenerator {
	private static SidGenerator instance;
	private int counter = 0;
	private static final SimpleDateFormat format = new SimpleDateFormat("yyMMddHHmmssSSS");
	private static final DecimalFormat dFormat = new DecimalFormat("00000");
	
	private SidGenerator(){}
	
	public static synchronized SidGenerator getInstance() {
		if(instance == null){
			instance = new SidGenerator();
		}
		return instance;
	}
	
	private String getDateString(){
		return format.format(Calendar.getInstance().getTime());
	}
	
	/**
	 * 获得计数器字符，当计数器达到最大值即重置为0
	 * @return
	 */
	public synchronized String getCounterString(){
		String ret = "00001";
		if(counter >= 99999){
			counter = 0;
		}
		++ counter;
		ret = dFormat.format(counter);
		return ret;
	}
	
	public String generateSid(){
		return getDateString()+getCounterString();
	}
}
