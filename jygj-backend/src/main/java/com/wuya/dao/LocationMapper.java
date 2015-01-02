package com.wuya.dao;

import com.wuya.model.Location;

public interface LocationMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Location record);

    int insertSelective(Location record);

    Location selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Location record);

    int updateByPrimaryKey(Location record);
}