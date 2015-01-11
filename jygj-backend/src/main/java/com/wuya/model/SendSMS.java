package com.wuya.model;

import java.util.Date;

public class SendSMS {

	private Integer id;
	private String sid;
	private String sms_type;
	private String content;
	private String phone_number;
	private Integer sent_result;
	private Integer userd;
	private Date create_time;
	private Date modify_time;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getSid() {
		return sid;
	}

	public void setSid(String sid) {
		this.sid = sid;
	}

	public String getSms_type() {
		return sms_type;
	}

	public void setSms_type(String sms_type) {
		this.sms_type = sms_type;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getPhone_number() {
		return phone_number;
	}

	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}

	public Integer getSent_result() {
		return sent_result;
	}

	public void setSent_result(Integer sent_result) {
		this.sent_result = sent_result;
	}

	public Integer getUserd() {
		return userd;
	}

	public void setUserd(Integer userd) {
		this.userd = userd;
	}

	public Date getCreate_time() {
		return create_time;
	}

	public void setCreate_time(Date create_time) {
		this.create_time = create_time;
	}

	public Date getModify_time() {
		return modify_time;
	}

	public void setModify_time(Date modify_time) {
		this.modify_time = modify_time;
	}
}
