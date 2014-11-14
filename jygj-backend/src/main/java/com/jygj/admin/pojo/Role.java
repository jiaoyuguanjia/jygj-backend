package com.jygj.admin.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 
 * @author Jinjiang
 * 
 *         角色信息
 */
public class Role {

	private int id;
	private String name;
	private Date createTime;
	private List<Function> functionList = new ArrayList<Function>();

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public List<Function> getFunctionList() {
		return functionList;
	}

	public void setFunctionList(List<Function> functionList) {
		this.functionList = functionList;
	}

}
