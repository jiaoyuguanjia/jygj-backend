package com.wuya.dao;

import com.wuya.model.SendSMS;

public interface SendSMSMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SendSMS record);

    int insertSelective(SendSMS record);

    SendSMS selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SendSMS record);

    int updateByPrimaryKey(SendSMS record);
}
