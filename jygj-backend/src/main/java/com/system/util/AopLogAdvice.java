package com.system.util;

import org.apache.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;

public class AopLogAdvice{
	private static Logger log = Logger.getLogger(AopLogAdvice.class);
	
	

    //方法执行的前后调用  
    public Object runOnAround(ProceedingJoinPoint point) throws Throwable{  
        String method = point.getSignature() == null ? "UNKNOWN_METHOD": point.getSignature().toString();
        Object[] params = point.getArgs();
        String paramList = "";
        if(params != null){
	        for(Object obj: params){
	        	paramList += obj == null ? "null": obj.toString()+" | ";
	        }
        }else{
        	paramList = "";
        }
        log.info("START "+method+" with Parameter=> "+paramList);
        Object object = point.proceed();  
//        log.info("END "+method+" , return value: "+object);
    	return object;
    }  

}
