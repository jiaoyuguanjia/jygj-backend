package com.jygj.admin.pojo;

import org.apache.commons.lang.StringUtils;

import com.jygj.admin.dao.entity.ResumeEntity;

/**
 * 
 * @author kc
 * 
 *         简历的pojo，javabean
 */
public class Resume {

	private Integer id;

	private String name;

	private String sex;

	private String year;

	private String month;

	private String provinceCode;

	private String cityCode;

	private String areaCode;

	private Integer jobYear;

	private String education;

	private String jobExperience;

	private String projectExperience;

	private String[] technology;

	public Resume() {
	}

	public Resume(ResumeEntity entity) {
		if (entity == null)
			return;
		this.id = entity.getId();
		this.name = entity.getName();
		this.sex = entity.getSex();
		this.year = entity.getYear();
		this.month = entity.getMonth();
		this.jobYear = entity.getJobYear();
		this.education = entity.getEducation();
		this.jobExperience = entity.getJobExperience();
		this.projectExperience = entity.getProjectExperience();
		this.technology = StringUtils.split(entity.getTechnology(), "_");
		this.provinceCode = entity.getProvinceCode();
		this.cityCode = entity.getCityCode();
		this.areaCode = entity.getAreaCode();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	public String getProvinceCode() {
		return provinceCode;
	}

	public void setProvinceCode(String provinceCode) {
		this.provinceCode = provinceCode;
	}

	public String getCityCode() {
		return cityCode;
	}

	public void setCityCode(String cityCode) {
		this.cityCode = cityCode;
	}

	public String getAreaCode() {
		return areaCode;
	}

	public void setAreaCode(String areaCode) {
		this.areaCode = areaCode;
	}

	public Integer getJobYear() {
		return jobYear;
	}

	public void setJobYear(Integer jobYear) {
		this.jobYear = jobYear;
	}

	public String getEducation() {
		return education;
	}

	public void setEducation(String education) {
		this.education = education;
	}

	public String getJobExperience() {
		return jobExperience;
	}

	public void setJobExperience(String jobExperience) {
		this.jobExperience = jobExperience;
	}

	public String getProjectExperience() {
		return projectExperience;
	}

	public void setProjectExperience(String projectExperience) {
		this.projectExperience = projectExperience;
	}

	public String[] getTechnology() {
		return technology;
	}

	public void setTechnology(String[] technology) {
		this.technology = technology;
	}

	public String getTechnologyString() {
		return StringUtils.join(technology, "_");
	}

	public EducationType getEducationType() {
		// valueOf方法是Enum类型定义的一个方法，将传入的code转换成指定的枚举类型
		return EducationType.valueOf(this.education);
	}

	public String getEducationCN() {
		if ("YJS".equals(this.education)) {
			return "研究生";
		} else if ("BK".equals(this.education)) {
			return "本科";
		} else if ("DZ".equals(this.education)) {
			return "大专";
		} else if ("GZ".equals(this.education)) {
			return "高中";
		}
		return this.education;
	}

	public ResumeEntity toEntity() {
		ResumeEntity entity = new ResumeEntity();
		entity.setId(id);
		entity.setName(name);
		entity.setSex(sex);
		entity.setYear(year);
		entity.setMonth(month);
		entity.setJobYear(jobYear);
		entity.setEducation(education);
		entity.setJobExperience(jobExperience);
		entity.setProjectExperience(projectExperience);
		entity.setTechnology(StringUtils.join(technology, "_"));
		entity.setProvinceCode(provinceCode);
		entity.setCityCode(cityCode);
		entity.setAreaCode(areaCode);
		return entity;
	}
}
