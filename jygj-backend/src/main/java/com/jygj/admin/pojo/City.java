package com.jygj.admin.pojo;

import com.jygj.admin.dao.entity.CityEntity;



/**
 * 
 * @author Jinjiang
 * 
 *         市
 */
public class City {

	private Integer id;

	private String code;

	private String name;

	private Province province;

	public City() {
		province = new Province();
	}

	public City(CityEntity entity) {
		this();
		this.id = entity.getId();
		this.code = entity.getCode();
		this.name = entity.getName();
		this.province.setCode(entity.getProvinceCode());
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

	public Province getProvince() {
		return province;
	}

	public void setProvince(Province province) {
		this.province = province;
	}

}
