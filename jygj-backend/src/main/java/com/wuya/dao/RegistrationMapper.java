package com.wuya.dao;

import com.wuya.model.Registration;

public interface RegistrationMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Registration record);

    int insertSelective(Registration record);

    Registration selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Registration record);

    int updateByPrimaryKey(Registration record);
}
