package com.jygj.admin.dao;

import java.util.List;

import com.jygj.admin.dao.entity.AreaEntity;
import com.jygj.admin.dao.entity.CityEntity;
import com.jygj.admin.dao.entity.ProvinceEntity;


public interface PlaceDao {

	List<ProvinceEntity> getProvinceList();

	List<CityEntity> getCityList(String provinceCode);

	List<AreaEntity> getAreaList(String cityCode);

}
