package com.jygj.admin.pojo;

import com.jygj.admin.dao.entity.AreaEntity;


/**
 * 
 * @author Jinjiang
 * 
 *         区
 */
public class Area {

	private Integer id;

	private String code;

	private String name;

	private City city;

	public Area() {
		city = new City();
	}

	public Area(AreaEntity entity) {
		this();
		this.id = entity.getId();
		this.code = entity.getCode();
		this.name = entity.getName();
		this.city.setCode(entity.getCityCode());
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public City getCity() {
		return city;
	}

	public void setCity(City city) {
		this.city = city;
	}

}
