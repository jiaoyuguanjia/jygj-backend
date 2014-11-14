package com.jygj.admin.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jygj.admin.dao.PlaceDao;
import com.jygj.admin.dao.entity.AreaEntity;
import com.jygj.admin.dao.entity.CityEntity;
import com.jygj.admin.dao.entity.ProvinceEntity;
import com.jygj.admin.pojo.Area;
import com.jygj.admin.pojo.City;
import com.jygj.admin.pojo.Province;
import com.jygj.admin.service.PlaceService;

@Service
public class PlaceServiceImpl implements PlaceService {
	
	@Autowired
	private PlaceDao placeDao;

	@Override
	public List<Province> getProvinceList() {
		List<Province> provinceList = new ArrayList<Province>();
		for(ProvinceEntity entity: placeDao.getProvinceList()) {
			provinceList.add(new Province(entity));
		}
		return provinceList;
	} 

	@Override
	public List<City> getCityList(String provinceCode) {
		List<City> cityList = new ArrayList<City>();
		for(CityEntity entity: placeDao.getCityList(provinceCode)) {
			cityList.add(new City(entity));
		}
		return cityList;
	}

	@Override
	public List<Area> getAreaList(String cityCode) {
		List<Area> areaList = new ArrayList<Area>();
		for(AreaEntity entity: placeDao.getAreaList(cityCode)) {
			areaList.add(new Area(entity));
		}
		return areaList;
	}

}
