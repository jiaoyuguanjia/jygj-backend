package com.jygj.admin.action.ajax;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jygj.admin.pojo.Area;
import com.jygj.admin.pojo.City;
import com.jygj.admin.pojo.Province;
import com.jygj.admin.service.PlaceService;

@Controller
public class PlaceAjax {
	
	@Autowired
	private PlaceService placeService;

	@ResponseBody
	@RequestMapping(value="/ajaxGetProvinceList.json", method=RequestMethod.POST)
	public List<Province> ajaxGetProvinceList() {
		return placeService.getProvinceList();
	}
	
	@ResponseBody
	@RequestMapping(value="/ajaxGetCityList.json", method=RequestMethod.POST)
	public List<City> ajaxGetCityList(String provinceCode) {
		return placeService.getCityList(provinceCode);
	}
	
	@ResponseBody
	@RequestMapping(value="/ajaxGetAreaList.json", method=RequestMethod.POST)
	public List<Area> ajaxGetAreaList(String cityCode) {
		return placeService.getAreaList(cityCode);
	}
}
