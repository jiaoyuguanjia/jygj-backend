package com.jygj.admin.pojo;

import com.jygj.admin.dao.entity.ProvinceEntity;

/**
 * 
 * @author Jinjiang
 * 
 *         省
 */
public class Province {

	private Integer id;

	private String code;

	private String name;

	public Province() {
	}

	public Province(ProvinceEntity entity) {
		this.id = entity.getId();
		this.code = entity.getCode();
		this.name = entity.getName();
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
}
