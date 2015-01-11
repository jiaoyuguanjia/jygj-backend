package com.wuya.model;

public class Qualification {

	private Integer id;
	private Integer tutor_id;
	private Integer qualification_type;
	private String img_url;
	private String certificate_des;
	private Integer approval_status;
	private String remark;

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

	public Integer getQualification_type() {
		return qualification_type;
	}

	public void setQualification_type(Integer qualification_type) {
		this.qualification_type = qualification_type;
	}

	public String getImg_url() {
		return img_url;
	}

	public void setImg_url(String img_url) {
		this.img_url = img_url;
	}

	public String getCertificate_des() {
		return certificate_des;
	}

	public void setCertificate_des(String certificate_des) {
		this.certificate_des = certificate_des;
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
}
