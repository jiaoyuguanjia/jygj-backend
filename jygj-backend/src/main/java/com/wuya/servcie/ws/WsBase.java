package com.wuya.servcie.ws;

import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wuya.servcie.ws.util.CommonResult;
import com.wuya.servcie.ws.util.CommonResultMap;
import com.wuya.servcie.ws.util.JsonUtils;

public class WsBase {
	public static final Logger log = Logger.getLogger(WsBase.class);

	/**
	 * Convert result to JSON String<br>
	 * <strong>All TextDetail object will return string value</strong>
	 * @param map
	 * @return
	 */
	protected String returnJsonResult(CommonResultMap map){
		String ret = null;
		try{
			ret = JsonUtils.toJSON(map,JsonUtils.JSON_EXCLUDE_FIELDS, JsonUtils.DEFAULT_JSON_DATE_PATTERN);
		}catch(Exception e){
			ret = "{\"status\": "+CommonResult.EXCEPTION.getCode()+", \"msg\": \"转换结果出错\"}";
			log.error(e.getMessage() == null ? e.toString() : e.getMessage());
		}
		return ret;
	}
	
	
	protected void handleException(CommonResultMap map, Exception e, String returnMessage){
		if(e != null){
			map.setResult(CommonResult.ERROR, returnMessage);
		}
	}
	
	/**
	 * WebService 出错时会自动调用此方法
	 * @param e
	 * @return
	 */
	@ExceptionHandler
	protected @ResponseBody String handle(Exception e){
		log.error(e.getMessage());
		CommonResultMap map = new CommonResultMap();
		map.setMessage(e.getMessage() == null ? e.toString() : e.getMessage());
		return returnJsonResult(map);
	}
}
