package com.wuya.model;

public class Course {

	private Integer id;
	private Integer tutor_id;
	private Integer category_id;
	private Integer tuition;
	private Integer duration;
	private Integer approval_status;
	private String remark;
	private Integer is_hide;
	private String course_intro;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getTutor_id() {
		return tutor_id;
	}

	public void setTutor_id(Integer tutor_id) {
		this.tutor_id = tutor_id;
	}

	public Integer getCategory_id() {
		return category_id;
	}

	public void setCategory_id(Integer category_id) {
		this.category_id = category_id;
	}

	public Integer getTuition() {
		return tuition;
	}

	public void setTuition(Integer tuition) {
		this.tuition = tuition;
	}

	public Integer getDuration() {
		return duration;
	}

	public void setDuration(Integer duration) {
		this.duration = duration;
	}

	public Integer getApproval_status() {
		return approval_status;
	}

	public void setApproval_status(Integer approval_status) {
		this.approval_status = approval_status;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Integer getIs_hide() {
		return is_hide;
	}

	public void setIs_hide(Integer is_hide) {
		this.is_hide = is_hide;
	}

	public String getCourse_intro() {
		return course_intro;
	}

	public void setCourse_intro(String course_intro) {
		this.course_intro = course_intro;
	}
}
