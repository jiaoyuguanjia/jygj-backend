package com.wuya.dao;

import com.wuya.model.Rgistration;

public interface RgistrationMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Rgistration record);

    int insertSelective(Rgistration record);

    Rgistration selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Rgistration record);

    int updateByPrimaryKey(Rgistration record);
}