package com.cab.booking.application.dtos;

import com.cab.booking.application.enums.Gender;

public class UserDTO {

    private String id;
    private String name;
    private String mobileNumber;
    private Gender gender;
    private Integer age;

    public UserDTO() {
    }

    public UserDTO(String id, String name, String mobileNumber, Gender gender, Integer age) {
        this.id = id;
        this.name = name;
        this.mobileNumber = mobileNumber;
        this.gender = gender;
        this.age = age;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "UserDTO{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", mobileNumber='" + mobileNumber + '\'' +
                ", gender=" + gender +
                ", age=" + age +
                '}';
    }
}
