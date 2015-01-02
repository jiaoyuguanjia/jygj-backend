package com.wuya.servcie.ws;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wuya.model.User;
import com.wuya.servcie.IUserService;
import com.wuya.servcie.ws.util.CommonResult;
import com.wuya.servcie.ws.util.CommonResultMap;

@Controller
public class HelloWorldController extends WsBase{
	
	@Autowired
	private IUserService userService;
	

	@RequestMapping(value="/user/{userId}", method = RequestMethod.GET)
	@ResponseBody
	public String getUserById(@PathVariable("userId") Integer id){
		System.out.println("enter get user by id by userId:"+id);
		CommonResultMap map = new CommonResultMap();
		try {
			User user = userService.findUserById(id);
			if(user != null){
				map.setData(user);
			}else{
				map.setResult(CommonResult.NOT_FOUND, "未找到用户");
			}
		} catch (Exception e) {
			handleException(map, e, e.getMessage());
		}
		return returnJsonResult(map);
	}


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
	
	


}