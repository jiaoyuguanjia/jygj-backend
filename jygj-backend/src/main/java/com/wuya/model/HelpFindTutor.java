package com.wuya.model;

public class HelpFindTutor {
    private Integer id;

    private Integer studentId;

    private String myRequirement;

    private String myName;

    private Integer myMobileNo;

    private Integer findStatus;

    private String studentProfile;

    private Integer matchedTutorId;

    private String matchedTutorName;

    private Integer matchedTutorPhone;

    private String matchedTutorProfile;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public String getMyRequirement() {
        return myRequirement;
    }

    public void setMyRequirement(String myRequirement) {
        this.myRequirement = myRequirement == null ? null : myRequirement.trim();
    }

    public String getMyName() {
        return myName;
    }

    public void setMyName(String myName) {
        this.myName = myName == null ? null : myName.trim();
    }

    public Integer getMyMobileNo() {
        return myMobileNo;
    }

    public void setMyMobileNo(Integer myMobileNo) {
        this.myMobileNo = myMobileNo;
    }

    public Integer getFindStatus() {
        return findStatus;
    }

    public void setFindStatus(Integer findStatus) {
        this.findStatus = findStatus;
    }

    public String getStudentProfile() {
        return studentProfile;
    }

    public void setStudentProfile(String studentProfile) {
        this.studentProfile = studentProfile == null ? null : studentProfile.trim();
    }

    public Integer getMatchedTutorId() {
        return matchedTutorId;
    }

    public void setMatchedTutorId(Integer matchedTutorId) {
        this.matchedTutorId = matchedTutorId;
    }

    public String getMatchedTutorName() {
        return matchedTutorName;
    }

    public void setMatchedTutorName(String matchedTutorName) {
        this.matchedTutorName = matchedTutorName == null ? null : matchedTutorName.trim();
    }

    public Integer getMatchedTutorPhone() {
        return matchedTutorPhone;
    }

    public void setMatchedTutorPhone(Integer matchedTutorPhone) {
        this.matchedTutorPhone = matchedTutorPhone;
    }

    public String getMatchedTutorProfile() {
        return matchedTutorProfile;
    }

    public void setMatchedTutorProfile(String matchedTutorProfile) {
        this.matchedTutorProfile = matchedTutorProfile == null ? null : matchedTutorProfile.trim();
    }
}