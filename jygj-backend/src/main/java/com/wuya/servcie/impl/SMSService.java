package com.wuya.servcie.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import com.system.util.CommonResult;
import com.system.util.SysCache;
import com.wuya.dao.SendSMSMapper;
import com.wuya.model.SendSMS;

@Service
public class SMSService {
	private Logger log = Logger.getLogger(SMSService.class);
	
	@Autowired
	private SendSMSMapper sendSMSMapper;
	
	public Integer saveAndSendSMS(SendSMS sms) {
		Assert.notNull(sms, "[SendSMS] must not be null");
		sms.setSentResult(CommonResult.NOT_START);
		sendSMSMapper.insert(sms);
		
		String result = "";
		String sendSMS = SysCache.getInstance().getSysConfig("disable.send.sms");
		if("true".equals(sendSMS)) {
			result = "0";
		}else {
			result = sendSMS(sms);
		}
		if(result!=null && result.equals("0")) {
			updateSmsStatus(sms, result, CommonResult.SUCCESS);
		}else {
			updateSmsStatus(sms, result, CommonResult.ERROR);
		}
		int ret = sms.getId();
		return ret;
	}
	
	private String sendSMS(SendSMS sms) {
		String ret = "";
		try{
//			String smsGateway = SysCache.getInstance().getSysConfig("sms_gateway");
//			String spCode = SysCache.getInstance().getSysConfig("sms_spcode");
//			String loginName = SysCache.getInstance().getSysConfig("sms_loginname");
//			String password = SysCache.getInstance().getSysConfig("sms_password");
//			HttpClient httpclient = new HttpClient();
//			PostMethod post = new PostMethod(smsGateway);
//			post.getParams().setParameter(HttpMethodParams.HTTP_CONTENT_CHARSET,"gbk");
//			post.addParameter("SpCode", spCode);
//			post.addParameter("LoginName", loginName);
//			post.addParameter("Password", password);
//			post.addParameter("MessageContent", sms.getContent());
//			post.addParameter("UserNumber", sms.getSmsTo());
//			post.addParameter("SerialNumber", sms.getSid());
//			post.addParameter("ScheduleTime", "");
//			post.addParameter("f", "1");
//			httpclient.executeMethod(post);
//			String info = new String(post.getResponseBody(),"gbk");
//			String[] arr = info.split("&");
//			if(arr!=null && arr.length>0) {
//				int i = arr[0].indexOf("=");
//				if(i != -1) {
//					ret = arr[0].substring(i + 1);
//				}
//			}
		}catch (Exception e) {
			e.printStackTrace();
			log.error(e.getMessage());
		}
		return ret;
	}

	private void updateSmsStatus(SendSMS sms, String result, CommonResult status) {
		Assert.notNull(sms,"[sms] must not be null");
		Assert.notNull(result,"[result] must not be null");
		Assert.notNull(status,"[StatusEnum] must not be null");
		Map<String, Object> map = new HashMap<String, Object>();
		List<SendSMS> list = new ArrayList<SendSMS>();
		list.add(sms);
		map.put("ids", list);
		map.put("result", result);
		map.put("status", status.getCode());
//		sendSMSMapper.updateStatusByIds(map);
	}
	
}
