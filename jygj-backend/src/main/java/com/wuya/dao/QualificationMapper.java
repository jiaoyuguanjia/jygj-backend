package com.wuya.dao;

import com.wuya.model.Qualification;

public interface QualificationMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Qualification record);

    int insertSelective(Qualification record);

    Qualification selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Qualification record);

    int updateByPrimaryKey(Qualification record);
}
