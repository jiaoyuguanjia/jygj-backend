package com.wuya.servcie.ws;

import com.wuya.servcie.ws.util.CommonResult;
import com.wuya.servcie.ws.util.CommonResultMap;
import com.wuya.servcie.ws.util.JsonUtils;

public class WsBase {

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
//			String lang = AppContext.get() == null ? null: AppContext.get().getLanguage();
//			ret = "{\"status\": "+CommonResult.EXCEPTION.getCode()+", \"msg\": \""+SysUtil.getLocaleText("error.convert.result.to.json", lang)+"\"}";
//			log.error(e.getMessage() == null ? e.toString() : e.getMessage());
		}
		return ret;
	}
	
	
	protected void handleException(CommonResultMap map, Exception e, String returnMessage){
		if(e != null){
			map.setResult(CommonResult.ERROR, returnMessage);
		}
	}
}
