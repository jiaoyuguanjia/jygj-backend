package com.system.util.mail;

import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.Address;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.mail.internet.MimeUtility;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

public class SimpleMailSender {
	private static Logger logger = Logger.getLogger(SimpleMailSender.class);

	public static boolean sendHtmlMail(MailSenderInfo mailInfo) {
		logger.info("Send html email..");
		MyAuthenticator authenticator = null;
		Properties pro = mailInfo.getProperties();
		if (mailInfo.isValidate()) {
			authenticator = new MyAuthenticator(mailInfo.getUserName(),
					mailInfo.getPassword());
		}
		try {
		Session sendMailSession = Session
				.getInstance(pro, authenticator);
			Message mailMessage = new MimeMessage(sendMailSession);
			if(mailInfo.getReplyTo() !=null){
				//set reply to address
				Address reply = new InternetAddress(mailInfo.getReplyTo());
				mailMessage.setReplyTo(new Address[]{reply});
			}
			Address from = new InternetAddress(mailInfo.getFromAddress());
			mailMessage.setFrom(from);
			
			mailMessage.addRecipients(Message.RecipientType.TO, splitAddress(mailInfo.getToAddress()));
			
			if (StringUtils.isNotEmpty(mailInfo.getCcAddress())) {
				logger.info("cc to "+mailInfo.getCcAddress());
				mailMessage.setRecipients(Message.RecipientType.CC,splitAddress(mailInfo.getCcAddress()));
			}
			
			//bcc
			if(StringUtils.isNotEmpty(mailInfo.getBccAddress())){
				logger.info("bcc to "+mailInfo.getBccAddress());
				mailMessage.setRecipients(Message.RecipientType.BCC, splitAddress(mailInfo.getBccAddress()));
			}
			
			try {
				mailMessage.setSubject(MimeUtility.encodeText(mailInfo.getSubject(),MimeUtility.mimeCharset("UTF-8"),null));
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
				mailMessage.setSubject(mailInfo.getSubject());
			}
			
			mailMessage.setSentDate(new Date());
			Multipart mainPart = new MimeMultipart();
			BodyPart html = new MimeBodyPart();
			html.setContent(mailInfo.getContent(), "text/html; charset=utf-8");
			mainPart.addBodyPart(html);
			
			//add attachments
			if(mailInfo.getAttachFileNames()!=null && mailInfo.getAttachFileNames().length>0){
				String[] attachments = mailInfo.getAttachFileNames();
				for (int i = 0; i < attachments.length; i++) {
					MimeBodyPart mbp = new MimeBodyPart();
					String fileName = attachments[i];
					FileDataSource fds = new FileDataSource(fileName);
					mbp.setDataHandler(new DataHandler(fds)); 
					mbp.setFileName(fds.getName());
					mainPart.addBodyPart(mbp);
				}				
			}
			
			mailMessage.setContent(mainPart);
			Transport.send(mailMessage);
			logger.info("Send html mail to "+mailInfo.getToAddress().toString()+", success");
			return true;
		} catch (MessagingException ex) {
			logger.error("Send html mail error:\n"+ex.getMessage());
			mailInfo.setErrorMsg(ex.getMessage());
			ex.printStackTrace();
		}
		return false;
	}
	
	/**
	 * @author Michael,Apr 26, 2012
	 * @param address
	 * @return
	 * @throws AddressException
	 */
	private static Address[] splitAddress(String address) throws AddressException{
		Address[] addresses = null;
		if(StringUtils.isNotBlank(address)){
			String[] mailList = address.split(",");
			addresses =new InternetAddress[mailList.length];
			for(int i=0;i<mailList.length;i++){
				addresses[i]=new InternetAddress(mailList[i]);
			}			
		}
		return addresses;
	}
}
