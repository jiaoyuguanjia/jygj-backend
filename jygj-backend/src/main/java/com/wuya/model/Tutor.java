package com.wuya.model;

public class Tutor {
    private Integer id;

    private Integer userId;

    private Integer profession;

    private Integer teachingAge;

    private Integer tutoringType;

    private Integer locationId;

    private Integer isHide;

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

    public Integer getTutoringType() {
        return tutoringType;
    }

    public void setTutoringType(Integer tutoringType) {
        this.tutoringType = tutoringType;
    }

    public Integer getLocationId() {
        return locationId;
    }

    public void setLocationId(Integer locationId) {
        this.locationId = locationId;
    }

    public Integer getIsHide() {
        return isHide;
    }

    public void setIsHide(Integer isHide) {
        this.isHide = isHide;
    }
}