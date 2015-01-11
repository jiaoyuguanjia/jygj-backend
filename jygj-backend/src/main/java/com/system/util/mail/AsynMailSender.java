package com.system.util.mail;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;


public class AsynMailSender implements Runnable {
	private static Logger log = Logger.getLogger(AsynMailSender.class);
	
	private MailSenderInfo mail;
	private MailSentCallback callback;
	
	public AsynMailSender(String to,String subject,
			String content, MailSentCallback callback) throws Exception {
		this(MailSenderInfo.getDefaultMailInfo(to, null),subject, content, callback);
	}
	
	private AsynMailSender(MailSenderInfo mail,String subject,
			String content, MailSentCallback callback) {
		this(mail, null, null, subject, content, callback);
	}
	
	private AsynMailSender(MailSenderInfo mail,String optToAddress, String optBccAddress, String subject,
			String content, MailSentCallback callback) {
		this.mail = mail;
		if(StringUtils.isNotBlank(optBccAddress)){
			this.mail.setBccAddress(optBccAddress);
		}
		if(StringUtils.isNotBlank(optToAddress)){
			this.mail.setToAddress(optToAddress);
		}
		if(StringUtils.isNotBlank(subject)){
			this.mail.setSubject(subject);
		}
		if(StringUtils.isNotBlank(content)){
			this.mail.setContent(content);
		}
		this.callback = callback;
	}
	
	public AsynMailSender(MailSenderInfo mail,String optToAddress, String optBccAddress, String subject,
			String content) {
		this(mail, optToAddress, optBccAddress, subject, content, null);
	}

	

	@Override
	public void run() {
		log.info("Send mail in AsynMailSender ....");
		MailSender mailSender = MailSender.getInstance();
		boolean result = mailSender.sendSimpleMail(mail, null, null, mail.getSubject(), mail.getContent());
		if (callback != null) {
			if(result){
				callback.success(mail);
			}else{
				callback.error(mail);
			}
		}
	}

}
