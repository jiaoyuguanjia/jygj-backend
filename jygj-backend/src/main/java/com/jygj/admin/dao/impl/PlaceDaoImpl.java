package com.jygj.admin.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.jygj.admin.common.HibernateSessionFactory;
import com.jygj.admin.dao.PlaceDao;
import com.jygj.admin.dao.entity.AreaEntity;
import com.jygj.admin.dao.entity.CityEntity;
import com.jygj.admin.dao.entity.ProvinceEntity;

@Repository
@SuppressWarnings("unchecked")
public class PlaceDaoImpl implements PlaceDao {

	@Override
	public List<ProvinceEntity> getProvinceList() {
		String hql = "from ProvinceEntity order by id";
		return (List<ProvinceEntity>) HibernateSessionFactory.list(hql);
	}

	@Override
	public List<CityEntity> getCityList(String provinceCode) {
		String hql = "from CityEntity where province_code = ? order by id";
		return (List<CityEntity>) HibernateSessionFactory.find(new String[]{provinceCode}, hql);
	}

	@Override
	public List<AreaEntity> getAreaList(String cityCode) {
		String hql = "from AreaEntity where city_code = ? order by id";
		return (List<AreaEntity>) HibernateSessionFactory.find(new String[]{cityCode}, hql);
	}

}
