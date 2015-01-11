package com.wuya.servcie.ws;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.system.util.CommonResult;
import com.system.util.CommonResultMap;
import com.wuya.SignupVo;

public class MobileUserServcie extends WsBase{	
	/**
	 * 发送注册验证码
	 * @param phoneNum<br>
	 * 输出：<br>
	 * 成功发送<br>
	 * {"status":0,"msg":"验证码发送成功"}<br>
	 * 异常：<br>
	 * {"status":2,"msg":"该手机已经被注册"}<br>
	 * {"status":3,"msg":"手机参数错误"}<br>
	 * {"status":-1,"msg":"验证码发送失败"}<br>
	 * {"status":-2,"msg":"系统异常"}<br>
	 * @return
	 */
	@RequestMapping(value="/signup/sendVerificationCode/{phoneNum}", method = RequestMethod.GET)
	@ResponseBody
	public String sendVerificationCode(@PathVariable("userId") Integer phoneNum){
		//TODO
		/**
		 * 1. 验证手机号码是否有问题
		 * 2. 验证手机是否已经被注册过
		 * 3. 发送验证码
		 * 5. 不管成功与否都需要保存记录：手机号码，验证码，sms_type=1 到表send_sms，sent_result=1 or 2
		 * 4. 发送成功把验证码缓存半小时
		 * 5. 特殊处理：如果发现缓存里面有，需要发送同一个验证码（防止半小时内多次发送）
		 * 6. 异常处理
		 */
		CommonResultMap map = new CommonResultMap();
		map.setResult(CommonResult.SUCCESS, "验证码发送成功");
		return returnJsonResult(map);
	}
	
	
	/**
	 * 用户注册
	 * @param signupVo<br>
	 * 输入：
	 * {"mobileNo":1829384732,"verificationCode":"124556","userType":2,"password":"123123","device_code":"rwesd"}<br>
	 *     --用户类型userType：1，老师；2，学生<br>
	 * 输出：<br>
	 * 注册成功<br>
	 * {"status":0,"msg":"注册成功"，"DATA":{"token":"wewewsds"}}<br>
	 * 异常：<br>
	 * {"status":2,"msg":"该手机已经注册过"}<br>
	 * {"status":3,"msg":"验证码验证失败"}<br>
	 * {"status":-2,"msg":"系统异常"}<br>
	 * @return
	 */
	@RequestMapping(value="/signup", method = RequestMethod.POST)
	@ResponseBody
	public String signup(@RequestBody SignupVo signupVo){
		//TODO
		/**
		 * 1. 验证验证码是否正确
		 * 2. 验证手机是否已经被注册过
		 * 3. 验证通过，保存用户信息到表user，同时插入一条记录到表tutor或者表student
		 * 4. 注册成功，用户即为登录状态
		 * 5. 生成token
		 * 6. 保存token到表user_token
		 * 7. 把token放入缓存Map<token, User>
		 * 8. 异常处理
		 */
		return null;
	}
	/**
	 * 登录
	 * @param signupVo<br>
	 * 输入：
	 * {"mobileNo":1829384732,"password":"123123"}<br>
	 * 输出：<br>
	 * 登录成功<br>
	 * {"status":0,"msg":"登录成功"，"DATA":{"token":"wewewsds"}}<br>
	 * 异常：<br>
	 * {"status":1,"msg":"用户名不存在"}<br>
	 * {"status":3,"msg":"密码错误"}<br>
	 * {"status":-2,"msg":"系统异常"}<br>
	 * @return
	 */
	@RequestMapping(value="/login", method = RequestMethod.POST)
	@ResponseBody
	public String login(@RequestBody SignupVo signupVo){
		return null;
	}
	/**
	 * 退出
	 * @param token<br>
	 * 输入：
	 * {"mobileNo":1829384732,"password":"123123"}<br>
	 * 输出：<br>
	 * 登录成功<br>
	 * {"status":0,"msg":"登录成功"，"DATA":{"token":"wewewsds"}}<br>
	 * 异常：<br>
	 * {"status":1,"msg":"用户名不存在"}<br>
	 * {"status":3,"msg":"密码错误"}<br>
	 * {"status":-2,"msg":"系统异常"}<br>
	 * @return
	 */
	@RequestMapping(value="/logout/{token}", method = RequestMethod.GET)
	@ResponseBody
	public String logout(@PathVariable String token){
		return null;
	}
}
