package com.wuya.model;

public class Tutor {

	private Integer id;
	private Integer user_id;
	private Integer profession;
	private Integer teaching_age;
	private String tutoring_timing;
	private Integer tutoring_type;
	private Integer is_hide;
	private String tutoring_area;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getUser_id() {
		return user_id;
	}

	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}

	public Integer getProfession() {
		return profession;
	}

	public void setProfession(Integer profession) {
		this.profession = profession;
	}

	public Integer getTeaching_age() {
		return teaching_age;
	}

	public void setTeaching_age(Integer teaching_age) {
		this.teaching_age = teaching_age;
	}

	public String getTutoring_timing() {
		return tutoring_timing;
	}

	public void setTutoring_timing(String tutoring_timing) {
		this.tutoring_timing = tutoring_timing;
	}

	public Integer getTutoring_type() {
		return tutoring_type;
	}

	public void setTutoring_type(Integer tutoring_type) {
		this.tutoring_type = tutoring_type;
	}

	public Integer getIs_hide() {
		return is_hide;
	}

	public void setIs_hide(Integer is_hide) {
		this.is_hide = is_hide;
	}

	public String getTutoring_area() {
		return tutoring_area;
	}

	public void setTutoring_area(String tutoring_area) {
		this.tutoring_area = tutoring_area;
	}
}
