package com.wuya.model;

public class TutorWithBLOBs extends Tutor {

	private String profile;
	private String edu_background;
	private String work_exp;
	private String remark;

	public String getProfile() {
		return profile;
	}

	public void setProfile(String profile) {
		this.profile = profile;
	}

	public String getEdu_background() {
		return edu_background;
	}

	public void setEdu_background(String edu_background) {
		this.edu_background = edu_background;
	}

	public String getWork_exp() {
		return work_exp;
	}

	public void setWork_exp(String work_exp) {
		this.work_exp = work_exp;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}
}
