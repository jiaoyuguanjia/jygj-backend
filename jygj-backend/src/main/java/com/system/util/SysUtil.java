package com.system.util;

import java.beans.PropertyDescriptor;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Method;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.URL;
import java.net.URLConnection;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

public class SysUtil {
	private static Logger logger = Logger.getLogger(SysUtil.class);

    public static String getServerInfo() {
        StringBuffer sb = new StringBuffer();

        Enumeration<NetworkInterface> netInterfaces = null;
        try {
            netInterfaces = NetworkInterface.getNetworkInterfaces();
            while (netInterfaces.hasMoreElements()) {
                NetworkInterface ni = netInterfaces.nextElement();
                sb.append("DisplayName:" + ni.getDisplayName() + "\r\n");
                sb.append("Name:" + ni.getName() + "\r\n");
                Enumeration<InetAddress> ips = ni.getInetAddresses();
                while (ips.hasMoreElements()) {
                    sb.append("IP:" + ips.nextElement().getHostAddress() + "\r\n");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return sb.toString();
    }

    public static boolean validateCardID(String cardNumber) {
        return new IDValidator(cardNumber).validate();
    }
    
    public static Date getBirthDateFromIdCard(String idCard){
    	IDValidator card = new IDValidator(idCard);
    	if(card.validate()){
    		return card.getBirthDate();
    	}else{
    		logger.warn("IDCard:"+idCard+" is not valid");
    		return null;
    	}
    }
    
    public static Boolean isIDMale(String idCard){
    	Boolean isMale = null;
    	IDValidator card = new IDValidator(idCard);
    	if(card.validate()){
    		isMale = card.isMale();
    	}else{
    		logger.warn("IDCard:"+idCard+" is not valid");
    	}
    	return isMale;
    }
    
    
   
   /**
    * 
    * @param str �?截�?�的字符串
    * @param count �?截�?�的字符数
    * @return String[]
    */
   public static String[] substringByBytes(String str, int count){
	   String returnedStr1 = "";
	   String returnedStr2 = "";
	   
	   if(StringUtils.isNotBlank(str) && count >=0){
		   int currentIndex = 0;
		   int indexEnd = 0;
		   char[] strCharArray = str.toCharArray();
		   int strCharArrayLength = strCharArray.length;
		   for(int i=0;i<strCharArrayLength;i++){
			   String strEle = str.valueOf(strCharArray[i]);
				  byte[] b = null;
				try {
					b = strEle.getBytes("UTF-8");
				} catch (UnsupportedEncodingException e) {
					e.printStackTrace();
				}
				//
				if((currentIndex + ( b== null ? 0: b.length) ) > count){
//					if((currentIndex + b.length) != count)
//						currentIndex = currentIndex + b.length;
					if(StringUtils.isBlank(returnedStr2))
						indexEnd = count*2 - (count - (currentIndex));
					if((currentIndex + ( b== null ? 0: b.length) ) > (indexEnd))
						break;
					else{
						returnedStr2 = returnedStr2+strCharArray[i];
						currentIndex = currentIndex + ( b== null ? 0: b.length);
					}
				}else{
					returnedStr1 = returnedStr1+strCharArray[i];
					currentIndex = currentIndex + ( b== null ? 0: b.length);
				}
		   }
	   }
	   
	   
	   
	   return new String[]{returnedStr1,returnedStr2};
   }
   public static int getBytesLength(String value){
   	int length = 0;
   	if(StringUtils.isNotBlank(value)){
   		byte[] b = null;
			try {
				b = value.getBytes("UTF-8");
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
				length = value.length() *3;
			}
   		length = (b== null ? 0: b.length);
   	}
   	return length;
  }
   
   /**
    * 判断是�?�连续多�?相�?��?�字符
    * @param msg
    * @return
    */
   public static boolean validateLoggerMessage(String msg) {
   	Pattern pattern = Pattern.compile("^\\s{0,10}(\\W)\\1{1,}\\s{0,10}$|^[\\s{1,}]?$");
       Matcher matcher = pattern.matcher(msg);
       return matcher.matches();
   }
   
    
  public static Date getLatestDayDate( ){
    	Calendar c = Calendar.getInstance();
		if(c.get(Calendar.HOUR_OF_DAY) > 12){
			c.add(Calendar.DATE, 1);
		}
   		c.set(Calendar.HOUR_OF_DAY, 8);
    	c.set(Calendar.MINUTE, 0);
    	c.set(Calendar.SECOND, 0);
    	c.set(Calendar.MILLISECOND, 0);
    	return c.getTime();
    }
  
  
  public static Date getBeginOfADay(int adjustDays) {
	  Calendar c = Calendar.getInstance();
	  c.set(Calendar.HOUR_OF_DAY, 0);
  	  c.set(Calendar.MINUTE, 0);
  	  c.set(Calendar.SECOND, 0);
  	  c.set(Calendar.MILLISECOND, 0);
  	  if(adjustDays != 0){
  		  c.add(Calendar.DATE, adjustDays);
  	  }
  	  return c.getTime();
  }
  
	
	
  public static String invokeRemoteAddress(String Address){
			String  ret = null;
			if(StringUtils.isBlank(Address)){
				logger.error("input empty for readRemoteSuccess");
			}else{
				logger.info("invoke remote address: ");
				logger.info(Address);
				StringBuffer document = new StringBuffer();
				try{
					URL url = new URL(Address);//远程url
					URLConnection conn = url.openConnection();
					BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
					String line = null;
					while ((line = reader.readLine()) != null){
						document.append(line + "\r\n");
					}
					reader.close();
					ret = document.toString();
					logger.info("invoke result: ");
					logger.info(ret);
				}catch(Exception e) {
					ret = null;
					logger.error(e.getMessage());
				}
			}
			return ret;
		}
	  
	  public static String MD5Digest(String text){
		  MessageDigest md;
		  try {
			  md = MessageDigest.getInstance("MD5");
			  md.update(text.getBytes());
			  byte b[] = md.digest(); 
			  int i; 
			  StringBuffer buf = new StringBuffer(""); 
			  for (int offset = 0; offset < b.length; offset++) { 
				  i = b[offset]; 
				  if(i<0) i+= 256; 
				  if(i<16) buf.append("0"); 
				  buf.append(Integer.toHexString(i)); 
			  } 
			  return buf.toString();
		  } catch (NoSuchAlgorithmException e) {
			  e.printStackTrace();
		  }
			return null;
	  }
	  
	  
		public static Map<String, Object> convertBeanToMap(Object bean) {
			Map<String, Object> result = new HashMap<String, Object>();
			try{
				PropertyDescriptor[] pds = PropertyUtils.getPropertyDescriptors(bean);
				for ( PropertyDescriptor pd : pds ) {
					result.put(pd.getName(), pd.getReadMethod().invoke(bean, null));
				}
			}catch(Exception e){
				throw new RuntimeException(e.getMessage());
			}
			return result;
		}
		
		public static boolean isDevMode(){
		   boolean result = false;
		   String env = SysCache.getInstance().getSysConfig("env");
		   if(env != null){
			   if(env.equalsIgnoreCase("tomcat") || env.equalsIgnoreCase("dev")){
				   result = true;
			   }
		   }else{
			   Logger.getLogger(SysUtil.class).error("error get env config");
		   }
		   return result;
	   }
		   
	   public static boolean isLiveMode(){
		   boolean result = false;
		   String env = SysCache.getInstance().getSysConfig("env");
		   if(env != null){
			   if(env.equalsIgnoreCase("live")){
				   result = true;
			   }
		   }else{
			   Logger.getLogger(SysUtil.class).error("error get env config");
		   }
		   return result;
	   }
	   
	   public static Timestamp addMinutes(Timestamp srcTime, Integer minutes) {
			Calendar cal = Calendar.getInstance();  
			cal.setTime(srcTime); 
			cal.set(Calendar.MINUTE, cal.get(Calendar.MINUTE)+Integer.valueOf(minutes));
			Timestamp timestamp = new Timestamp(cal.getTime().getTime());
			return timestamp;
	   }
	   
	   
      public static Locale convertStringToLocale(String localeString){
		   Locale locale = null;
		   if (StringUtils.isNotBlank(localeString)) {
			   String[] localStringArray = localeString.split("_");
			   if(localStringArray != null && localStringArray.length == 2){
				   locale = new Locale(localStringArray[0].toLowerCase(), localStringArray[1].toUpperCase());
			   }			   
		   }
		   return locale;
	   }
	   
	   public static List<?> convertList(List<?> from, Class<?> targetClass, String methodName){
		   if(from == null || from.isEmpty()){
			   return null;
		   }else if(StringUtils.isBlank(methodName) || !methodName.startsWith("convert")){
			   logger.error("Can't convert "+from+" to "+targetClass+" by using method "+methodName);
			   return null;
		   }
		   Class<?> fromClass = from.get(0).getClass();
		   Method convertMethod  = null;
		   try {
			  convertMethod = fromClass.getMethod(methodName, null);
		   } catch (Exception e) {
			   e.printStackTrace();
			   return null;
		   }
		   
		   List targetList = new ArrayList();
		   
		   Iterator it = from.iterator();
		   while(it.hasNext()){
			   Object fromObject = it.next();
			   try {
				   Object targetObj = convertMethod.invoke(fromObject);
				   targetList.add(targetObj);
				} catch (Exception e) {
					e.printStackTrace();
					return null;
				} 
		   }
		   
		   
		   return targetList;
	   }
	   
	   public static long convertStringToNumber(String str){
		   long number = 0l;
		   if(StringUtils.isNotBlank(str)){
			   for(int i = 0; i < str.length() ; i ++){
				   number += str.charAt(i);
			   }
		   }
		   return number;
	   }
	   
	   public static String getClientIpAddr(HttpServletRequest request) {
		    String ip = request.getHeader("X-Real-IP");
		    if(StringUtils.isBlank(ip)){
		    	ip = request.getRemoteAddr();
		    }
	        return ip;
		}
	   
	   
      public static int countChinese(String str){
		   int count=0;
		   String regEx = "[\\u4e00-\\u9fa5]";
		   Pattern p = Pattern.compile(regEx);
		   Matcher m = p.matcher(str);
		   while (m.find()) {
			   for (int i = 0; i <= m.groupCount(); i++) {
				   count=count+1;
			   }
		   }
		   return count;
	   } 
	   
	   public static String convertDateToString(Date date, String format){
		   String dateStr = "";
		   if (date != null) {
			   dateStr = new SimpleDateFormat(format).format(date);
		   }
		   return dateStr;
	   }
	   
}