package com.wuya.dao;

import com.wuya.model.Povince;

public interface PovinceMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Povince record);

    int insertSelective(Povince record);

    Povince selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Povince record);

    int updateByPrimaryKey(Povince record);
}