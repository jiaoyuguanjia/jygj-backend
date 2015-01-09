package com.wuya.servcie.ws;


import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

public class MobileTutorService extends WsBase{
	/**
	 * 设置个人基本信息
	 * 输入：
	 * {"token":"eerrrwww","realName":"陈开强","gender":1,"icon":"http://www.wuya.im/img.png","teachingAge":2,"profession":1,"profile":"我很单纯"}<br>
	 * 输出：<br>
	 * 成功<br>
	 * {"status":0,"msg":"保存成功"}<br>
	 * 异常：<br>
	 * {"status":1,"msg":"未登录"}<br>
	 * {"status":2,"msg":"系统异常"}<br>
	 * @return
	 */
	@RequestMapping(value="/totur/savePersonalBasicInfo", method = RequestMethod.GET)
	@ResponseBody
	public String savePersonalBasicInfo(){
		return null;
	}
	/**
	 * 获取个人基本信息
	 * @param token<br>
	 * 输出：<br>
	 * 成功<br>
	 * {"status":0,"msg":"保存成功","DADA":{"token":"eerrrwww","realName":"陈开强","gender":1,"icon":"http://www.wuya.im/img.png","teachingAge":2,"profession":1,"profile":"我很单纯"}}<br>
	 * 异常：<br>
	 * {"status":1,"msg":"未登录"}<br>
	 * {"status":2,"msg":"系统异常"}<br>
	 * @return
	 */
	@RequestMapping(value="/totur/getPersonalBasicInfo/{token}", method = RequestMethod.GET)
	@ResponseBody
	public String getPersonalBasicInfo(@PathVariable("token") String token){
		return null;
	}
	/**
	 * 设置授课方式
	 * @param token<br>
	 * 输入：
	 * {"token":"eerrrwww","tutoringType":1,"tutoringTiming":"1,2,5","remark":"约课备注","tutoringArea":"1,2,5"}<br>
	 * 输出：<br>
	 * 成功<br>
	 * {"status":0,"msg":"保存成功","DADA":{"token":"eerrrwww","realName":"陈开强","gender":1,"icon":"http://www.wuya.im/img.png","teachingAge":2,"profession":1,"profile":"我很单纯"}}<br>
	 * 异常：<br>
	 * {"status":1,"msg":"未登录"}<br>
	 * {"status":2,"msg":"系统异常"}<br>
	 * @return
	 */
	@RequestMapping(value="/totur/saveTutoringType", method = RequestMethod.POST)
	@ResponseBody
	public String saveTutoringType(){
		return null;
	}
	/**
	 * 获取授课方式
	 * @param token<br>
	 * 输出：<br>
	 * 成功<br>
	 * {"status":0,"msg":"保存成功","DADA":{"tutoringType":1,"tutoringTiming":"1,2,5","remark":"约课备注","tutoringArea":"1,2,5"}}<br>
	 * 异常：<br>
	 * {"status":1,"msg":"未登录"}<br>
	 * {"status":2,"msg":"系统异常"}<br>
	 * @return
	 */
	@RequestMapping(value="/totur/saveTutoringType", method = RequestMethod.POST)
	@ResponseBody
	public String saveTutoringType(@PathVariable("token") String token){
		return null;
	}	
}
