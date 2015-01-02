package com.wuya.dao;

import com.wuya.model.TutoringTiming;

public interface TutoringTimingMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TutoringTiming record);

    int insertSelective(TutoringTiming record);

    TutoringTiming selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TutoringTiming record);

    int updateByPrimaryKey(TutoringTiming record);
}