package com.system.util;

import java.util.HashMap;
import java.util.Map;

import sun.awt.AppContext;

public class PagingTool {

	private int iDisplayStart = 0;
	private int iDisplayLength = 10;
	private int iTotalDisplayRecords;
	private Map<String, Object> params = new HashMap<String, Object>();

	public PagingTool() {

	}
	
	public PagingTool(Integer iDisplayStart, Integer iDisplayLength, String lang) {
		this.iDisplayStart = iDisplayStart;
		this.iDisplayLength = iDisplayLength;
		this.params.put("lang", lang);
	}
	
	public PagingTool(Integer iDisplayStart, Integer iDisplayLength) {
		this.iDisplayStart = iDisplayStart;
		this.iDisplayLength = iDisplayLength;
	}

	public Integer getiDisplayStart() {
		return iDisplayStart;
	}

	public void setiDisplayStart(Integer iDisplayStart) {
		if(iDisplayStart != null){
			this.iDisplayStart = iDisplayStart;
		}else{
			System.err.print("iDisplayStart is null");
		}
	}

	public Integer getiDisplayLength() {
		return iDisplayLength;
	}

	public void setiDisplayLength(Integer iDisplayLength) {
		if(iDisplayLength != null){
			this.iDisplayLength = iDisplayLength;
		}else{
			System.err.print("iDisplayLength is null");
		}
	}

	public Integer getiTotalDisplayRecords() {
		return iTotalDisplayRecords;
	}

	public void setiTotalDisplayRecords(Integer iTotalDisplayRecords) {
		this.iTotalDisplayRecords = iTotalDisplayRecords;
	}

	public Map<String, Object> getParams() {
		return params;
	}

	public void setParams(Map<String, Object> params) {
		this.params = params;
	}
	
	@Override
	public String toString() {
		return "PagingTool [iDisplayStart=" + iDisplayStart
				+ ", iDisplayLength=" + iDisplayLength
				+ ", iTotalDisplayRecords=" + iTotalDisplayRecords
				+ ", params=" + params + "]";
	}
	
}
