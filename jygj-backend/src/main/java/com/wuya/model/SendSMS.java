package com.wuya.model;

import java.util.Date;

import com.system.util.CommonResult;

public class SendSMS {
    private Integer id;

    private String sid;

    private String smsType;

    private String content;

    private String phoneNumber;

    private Integer sentResult;

    private Integer userd;

    private Date createTime;

    private Date modifyTime;

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

    public String getSmsType() {
        return smsType;
    }

    public void setSmsType(String smsType) {
        this.smsType = smsType;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Integer getSentResult() {
        return sentResult;
    }

    public void setSentResult(CommonResult sentResult){
    	this.sentResult = sentResult.getCode();
    }
    
    public void setSentResult(Integer sentResult) {
        this.sentResult = sentResult;
    }

    public Integer getUserd() {
        return userd;
    }

    public void setUserd(Integer userd) {
        this.userd = userd;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }
}
