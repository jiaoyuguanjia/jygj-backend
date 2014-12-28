package com.jygj.ws;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.RandomStringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.jygj.ws.util.CommonResult;
import com.jygj.ws.util.CommonResultMap;
import com.jygj.ws.util.JsonUtils;

@Controller
public class HelloWorldController {
	
	@RequestMapping(value="/test/{count}", method = RequestMethod.GET)
	@ResponseBody
	public String createBlankCustomer(@PathVariable("count") Integer count){
		System.out.println("enter test count");
		CommonResultMap map = new CommonResultMap();
		try{
			if(count != null && count > 0){
				List<String> test = new ArrayList<String>();
				for (int i = 0; i < count; i++) {
					test.add(RandomStringUtils.randomAlphabetic(10));
				}
				map.setData(test);
			}else{
				map.setResult(CommonResult.MISSING_PARAM, "传入参数有误");
			}
			
		}catch(Exception e){
			handleException(map, e, e.getMessage());
		}
		return returnJsonResult(map);
	}
	
	
	

	private void handleException(CommonResultMap map, Exception e, String returnMessage){
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
	private @ResponseBody String handle(Exception e){
		System.err.print(e.getStackTrace());
		CommonResultMap map = new CommonResultMap();
		map.setMessage(e.getMessage() == null ? e.toString() : e.getMessage());
		return returnJsonResult(map);
	}
	
	
	/**
	 * Convert result to JSON String<br>
	 * <strong>All TextDetail object will return string value</strong>
	 * @param map
	 * @return
	 */
	private String returnJsonResult(CommonResultMap map){
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

}