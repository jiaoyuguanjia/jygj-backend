package com.system.util.mail;

import java.util.Properties;

import org.apache.commons.lang.StringUtils;

import com.system.util.SysCache;

public class MailSenderInfo {

	private String mailServerHost;
	private String mailServerPort = "25";
	private String fromAddress;
	private String toAddress;
	private String ccAddress;
	private String userName;
	private String password;
	private String replyTo;
	private String bccAddress;
	private boolean sendInNewThread;
	private String errorMsg;
	
	
	public MailSenderInfo() {
		SysCache cache = SysCache.getInstance();
		this.setMailServerHost(cache.getSysConfig("mail_smtphost"));
		this.setMailServerPort(cache.getSysConfig("mail_serverport"));
		this.setValidate(Boolean.parseBoolean(cache.getSysConfig("mail_auth")));
		this.setUserName(cache.getSysConfig("mail_username"));
		this.setPassword(cache.getSysConfig("mail_password"));
		this.setFromAddress(cache.getSysConfig("mail_from"));
	}
	
	public MailSenderInfo(String toAddress) {
		this();
		if(StringUtils.isNotEmpty(toAddress)){
			this.setToAddress(toAddress);// to
		}else{
			throw new RuntimeException("email resiver missing");
		}
	}
	
	public MailSenderInfo(String toAddress, String subject, String content) {
		this(toAddress);
		if(StringUtils.isNotBlank(subject) && StringUtils.isNotBlank(content)){
			this.setSubject(subject);
			this.setContent(content);
		}else{
			throw new RuntimeException("email subject and content are required");
		}
	}
	
	
	public MailSenderInfo(String toAddress, String ccAddress, String replyTo,
			String bccAddress) {
		this(toAddress);
		this.ccAddress = ccAddress;
		this.replyTo = replyTo;
		this.bccAddress = bccAddress;
	}

	public String getBccAddress() {
		return bccAddress;
	}

	public void setBccAddress(String bccAddress) {
		this.bccAddress = bccAddress;
	}

	public String getReplyTo() {
		return replyTo;
	}

	public void setReplyTo(String replyTo) {
		this.replyTo = replyTo;
	}

	private boolean validate = false;
	private String subject;
	private String content;
	private String[] attachFileNames;

	public Properties getProperties() {
		Properties p = new Properties();
		p.put("mail.smtp.host", this.mailServerHost);
		p.put("mail.smtp.port", this.mailServerPort);
		p.put("mail.smtp.auth", validate ? "true" : "false");
		return p;
	}

	public String getMailServerHost() {
		return mailServerHost;
	}

	public void setMailServerHost(String mailServerHost) {
		this.mailServerHost = mailServerHost;
	}

	public String getMailServerPort() {
		return mailServerPort;
	}

	public void setMailServerPort(String mailServerPort) {
		this.mailServerPort = mailServerPort;
	}

	public boolean isValidate() {
		return validate;
	}

	public void setValidate(boolean validate) {
		this.validate = validate;
	}

	public String[] getAttachFileNames() {
		return attachFileNames;
	}

	public void setAttachFileNames(String[] fileNames) {
		this.attachFileNames = fileNames;
	}

	public String getFromAddress() {
		return fromAddress;
	}

	public void setFromAddress(String fromAddress) {
		this.fromAddress = fromAddress;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getToAddress() {
		return toAddress;
	}

	public void setToAddress(String toAddress) {
		this.toAddress = toAddress;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String textContent) {
		this.content = textContent;
	}

	public String getCcAddress() {
		return ccAddress;
	}

	public void setCcAddress(String ccAddress) {
		this.ccAddress = ccAddress;
	}

	@Override
	public String toString() {
		String ret = "MailSenderInfo[ to:" + this.toAddress + ", ";
		if (StringUtils.isNotBlank(replyTo)) {
			ret += "replyTo:" + this.replyTo + ", ";
		}
		ret += "subject:" + this.subject + "]";
		return ret;
	}
	
	public boolean isSendInNewThread() {
		return sendInNewThread;
	}

	public void setSendInNewThread(boolean sendInNewThread) {
		this.sendInNewThread = sendInNewThread;
	}
	
	public static MailSenderInfo getDefaultMailInfo(String toAddress,String optBccAddress) throws Exception{
		MailSenderInfo mailInfo = new MailSenderInfo(toAddress);
		if(StringUtils.isNotEmpty(optBccAddress)){
			mailInfo.setBccAddress(optBccAddress);//bcc
		}
		return mailInfo;		
	}

	public String getErrorMsg() {
		return errorMsg;
	}

	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}

}
