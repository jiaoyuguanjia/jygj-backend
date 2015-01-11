package com.system.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateConverter {
	
	public static String convertDate2String(Date date, String pattern) {
		SimpleDateFormat f = new SimpleDateFormat(pattern);
		return f.format(date);
	}

	public static String convertDate2String(Date date) {
		String pattern = "MM月dd日";
		return DateConverter.convertDate2String(date, pattern);
	}
	
	public static String convertDate2LongString(Date date){
		String pattern = "yyyy-MM-dd HH:mm:ss";
		return DateConverter.convertDate2String(date, pattern);
	}
	
	public static String convertDate2LongStringFormat2(Date date){
		String pattern = "yyyy/MM/dd HH:mm:ss";
		return DateConverter.convertDate2String(date, pattern);
	}

}
