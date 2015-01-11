package com.system.util.mail;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import com.system.util.SysCache;
import com.system.util.SysUtil;
import com.system.util.TextUtils;
import com.system.util.ThreadPool;
import com.system.util.mail.MailSenderInfo;
import com.system.util.mail.SimpleMailSender;

public class MailSender {
	
	private Logger logger = Logger.getLogger(MailSender.class);
	
	private static MailSender instance = null;

	public static synchronized MailSender getInstance() {
		if (instance == null) {
			instance = new MailSender();
		}
		return instance;
	}
	
	public MailSenderInfo getDefaultMailInfo(String toAddress,String optBccAddress) throws Exception{
		return MailSenderInfo.getDefaultMailInfo(toAddress, optBccAddress);
	}
	
	public boolean sendSimpleMail(MailSenderInfo mail,String optToAddress, String optBccAddress, String subject,String content) {
		boolean result = false;		
		if(mail.isSendInNewThread()){
			synchronized (this) {
				mail.setSendInNewThread(false);
				ThreadPool.getInstance().addToPool(new Thread(new AsynMailSender(mail, optToAddress, optBccAddress, subject, content)));
				return true;	
			}
		}
		if(StringUtils.isNotEmpty(optToAddress)){
		   mail.setToAddress(optToAddress);
		}else if(StringUtils.isBlank(mail.getToAddress())){
		   logger.error("No mail receipt");
		   mail.setErrorMsg("No mail receipt");
		   return false;
		}
		if(StringUtils.isNotEmpty(optBccAddress)){
			mail.setBccAddress(optBccAddress);
		}
		mail.setSubject(subject);
		logger.info("mail info -----"+mail.toString());
		if(StringUtils.isNotEmpty(content)){
			mail.setContent(content);
			if(setUpTestEmail(mail)){
				result = SimpleMailSender.sendHtmlMail(mail);
			}else{
				System.out.println("dev mode mail not send:\n");
				if(SysUtil.isDevMode()){
					System.out.println(content+"\n");
				}else{
					System.out.println(mail.toString());
					System.out.println(TextUtils.Html2Text(mail.getContent())+"\n");
				}
				 result = true;
			}
		}else{
			logger.error("No mail content");
			mail.setErrorMsg("No mail content");
			return result;
		}
		
		return result;
	}
	
	public boolean sendSimpleMail(String toAddress,String subject,String content) throws Exception{
		MailSenderInfo mailInfo = getDefaultMailInfo(toAddress, null);
		return sendSimpleMail(mailInfo, toAddress, null, subject, content);
	}
	
	private boolean setUpTestEmail(MailSenderInfo mail){
		boolean sendThisEmail = true;
		if(SysUtil.isLiveMode()){
			return true;
		}
		SysCache cache = SysCache.getInstance();
		String sendMail = cache.getSysConfig("send_mail");
		String send_all_test_mail = cache.getSysConfig("send_all_test_mail");
		String maskEmail = cache.getSysConfig("sys.maskemail.host");
		if(SysUtil.isDevMode() && "false".equals(sendMail)){
			sendThisEmail = false;
		}else if(!SysUtil.isLiveMode() && "false".equals(send_all_test_mail) && (mail.getBccAddress() == null || !mail.getBccAddress().contains("test_")) && ( mail.getToAddress().contains("test_") || mail.getToAddress().contains(maskEmail))){
			sendThisEmail = false;
		}
		String oldMailTo = mail.getToAddress();
		if(SysUtil.isDevMode()){
			String mail_to = cache.getSysConfig("mail_to");
			String default_mail_cc = cache.getSysConfig("mail_cc");
			String default_mail_bcc = cache.getSysConfig("mail_bcc");
			logger.info("dev mode ----- set mail to address to dev address:"+mail_to);
			logger.info("dev mode ----- original mail to :"+oldMailTo);
			mail.setToAddress(mail_to);
			if(mail.getCcAddress() != null){
				logger.info("dev mode update cc, original mail cc:"+mail.getCcAddress());
				if(StringUtils.isNotBlank(default_mail_cc)){
					logger.info("set cc address to "+default_mail_cc);
					mail.setCcAddress(default_mail_cc);
				}else{
					mail.setCcAddress(null);
				}
			}
			if(mail.getBccAddress() != null){
				logger.info("dev mode update bcc, original mail bcc:"+mail.getBccAddress());
				if(StringUtils.isNotBlank(default_mail_bcc)){
					logger.info("set bcc address to "+default_mail_bcc);
					mail.setBccAddress(default_mail_bcc);
				}else{
					mail.setBccAddress(null);
				}
			}
			mail.setSubject("[To:"+oldMailTo+"]"+mail.getSubject());
		}
		if(!SysUtil.isLiveMode()){
			String subject = "["+SysCache.getInstance().getSysConfig("project.name")+" "+SysCache.getInstance().getSysConfig("env")+"]"+mail.getSubject();
			mail.setSubject(subject);
		}
		return sendThisEmail;
	}
}