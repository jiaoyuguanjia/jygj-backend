package com.wuya.model;

public class Tutor {
    private Integer id;

    private Integer userId;

    private Integer profession;

    private Integer teachingAge;

    private String tutoringTiming;

    private Integer tutoringType;

    private Integer isHide;

    private String tutoringArea;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getProfession() {
        return profession;
    }

    public void setProfession(Integer profession) {
        this.profession = profession;
    }

    public Integer getTeachingAge() {
        return teachingAge;
    }

    public void setTeachingAge(Integer teachingAge) {
        this.teachingAge = teachingAge;
    }

    public String getTutoringTiming() {
        return tutoringTiming;
    }

    public void setTutoringTiming(String tutoringTiming) {
        this.tutoringTiming = tutoringTiming;
    }

    public Integer getTutoringType() {
        return tutoringType;
    }

    public void setTutoringType(Integer tutoringType) {
        this.tutoringType = tutoringType;
    }

    public Integer getIsHide() {
        return isHide;
    }

    public void setIsHide(Integer isHide) {
        this.isHide = isHide;
    }

    public String getTutoringArea() {
        return tutoringArea;
    }

    public void setTutoringArea(String tutoringArea) {
        this.tutoringArea = tutoringArea;
    }
}
