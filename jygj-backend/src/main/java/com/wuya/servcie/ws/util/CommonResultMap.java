package com.wuya.servcie.ws.util;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SuppressWarnings("rawtypes")
public class CommonResultMap extends HashMap implements Map {
	private static final long	serialVersionUID	= -3469936673137441995L;
	
	private static final Logger logger = LoggerFactory.getLogger(CommonResultMap.class);

	public CommonResultMap(){
		this.setResult(CommonResult.ERROR);
		this.setMessage("");
	}
	
	@SuppressWarnings("unchecked")
	public void setResult(CommonResult result) {
		this.put("status", result.getCode());
	}
	
	@SuppressWarnings("unchecked")
	public void setResult(CommonResult result,String message) {
		this.put("status", result.getCode());
		this.setMessage(message);
		if(message == null && result.getCode() !=CommonResult.SUCCESS.getCode()){
			//result is error and message not set.
			this.setMessage("UNKNOWN ERROR");
		}
		if(result.getCode() == CommonResult.EXCEPTION.getCode()){
			logger.error(message);
		}
	}
	
	public void addToResultList(CommonResult result, String message){
		if(result != CommonResult.SUCCESS){
			this.setResult(result);
		}
		String msg = this.getMessage();
		if(msg == null){
			msg = "";
		}
		msg +=result.name()+":" +message+" \r\n<br/>";
		this.setMessage(msg);
	}
	
	public Integer getStatus(){
		return (Integer)this.get("status");
	}
	
	public boolean succeed(){
		boolean result = false;
		if(this.getStatus().equals(CommonResult.SUCCESS.getCode())){
			result = true;
		}
		return result;
	}
	
	@SuppressWarnings("unchecked")
	public void setMessage(String message) {
		this.put("msg", message);
	}
	
	@SuppressWarnings("unchecked")
	public void setData(Object obj){
		if(obj == null || (obj instanceof List && ((List)obj).size() == 0)){
			this.setMessage("empty");
		}
		this.put("DATA", obj);
		this.setResult(CommonResult.SUCCESS);
	}
	
	public Object getData(){
		return this.get("DATA");
	}
	
	public Integer getIntData(){
		Object data = this.getData();
		if(data != null && data instanceof Number){
			return Integer.parseInt(data.toString());
		}else{
			return null;
		}
	}
	
	public Float getFloatData(){
		Object data = this.getData();
		if(data != null && data instanceof Number){
			return Float.parseFloat(data+"");
		}else{
			return null;
		}
	}
	
	@SuppressWarnings("unchecked")
	public void setResultCount(int count){
		this.put("count", count);
	}
	
	@SuppressWarnings("unchecked")
	public void setResultSize(int size){
		this.put("size", size);
	}
	
	public String getMessage(){
		String msg = (String)this.get("msg");
		return msg;
	}

	public void setLoginPage(String loginPage) {
		this.put("LoginPage", loginPage);
	}
}
