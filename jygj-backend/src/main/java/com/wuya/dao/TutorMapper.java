package com.wuya.dao;

import com.wuya.model.Tutor;
import com.wuya.model.TutorWithBLOBs;

public interface TutorMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TutorWithBLOBs record);

    int insertSelective(TutorWithBLOBs record);

    TutorWithBLOBs selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TutorWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(TutorWithBLOBs record);

    int updateByPrimaryKey(Tutor record);
}