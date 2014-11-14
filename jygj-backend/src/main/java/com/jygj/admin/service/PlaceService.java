package com.jygj.admin.service;

import java.util.List;

import com.jygj.admin.pojo.Area;
import com.jygj.admin.pojo.City;
import com.jygj.admin.pojo.Province;

public interface PlaceService {

	/**
	 * 查询所有省份信息
	 * 
	 * @return 返回省份信息列表
	 */
	List<Province> getProvinceList();

	/**
	 * 根据省份code查询城市信息
	 * 
	 * @param provinceCode
	 *            传入省份code
	 * @return 返回所在省份下的所有城市列表
	 */
	List<City> getCityList(String provinceCode);

	/**
	 * 根据城市code查询区县信息
	 * 
	 * @param cityCode
	 *            传入城市code
	 * @return 返回所在城市下的所有区县列表
	 */
	List<Area> getAreaList(String cityCode);

}
