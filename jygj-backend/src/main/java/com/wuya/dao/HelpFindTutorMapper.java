package com.wuya.dao;

import com.wuya.model.HelpFindTutor;

public interface HelpFindTutorMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(HelpFindTutor record);

    int insertSelective(HelpFindTutor record);

    HelpFindTutor selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(HelpFindTutor record);

    int updateByPrimaryKey(HelpFindTutor record);
}