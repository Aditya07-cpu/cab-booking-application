package com.cab.booking.application.dtos;

import com.cab.booking.application.enums.Gender;
import com.cab.booking.application.enums.VehicleType;

public class DriverDTO {
    private String id;
    private String name;
    private String mobileNumber;
    private Gender gender;
    private Integer age;
    private Long xCoordinates;
    private Long yCoordinates;
    private String vehicleName;
    private String registrationNumber;
    private VehicleType vehicleType;
    private boolean isAvailable;

    public DriverDTO() {
    }

    public DriverDTO(String id, String name, String mobileNumber, Gender gender, Integer age, Long xCoordinates, Long yCoordinates, String vehicleName, String registrationNumber, VehicleType vehicleType, boolean isAvailable) {
        this.id = id;
        this.name = name;
        this.mobileNumber = mobileNumber;
        this.gender = gender;
        this.age = age;
        this.xCoordinates = xCoordinates;
        this.yCoordinates = yCoordinates;
        this.vehicleName = vehicleName;
        this.registrationNumber = registrationNumber;
        this.vehicleType = vehicleType;
        this.isAvailable = isAvailable;
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

    public Long getxCoordinates() {
        return xCoordinates;
    }

    public void setxCoordinates(Long xCoordinates) {
        this.xCoordinates = xCoordinates;
    }

    public Long getyCoordinates() {
        return yCoordinates;
    }

    public void setyCoordinates(Long yCoordinates) {
        this.yCoordinates = yCoordinates;
    }

    public String getVehicleName() {
        return vehicleName;
    }

    public void setVehicleName(String vehicleName) {
        this.vehicleName = vehicleName;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    @Override
    public String toString() {
        return "DriverDTO{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", mobileNumber='" + mobileNumber + '\'' +
                ", gender=" + gender +
                ", age=" + age +
                ", xCoordinates=" + xCoordinates +
                ", yCoordinates=" + yCoordinates +
                ", vehicleName='" + vehicleName + '\'' +
                ", registrationNumber='" + registrationNumber + '\'' +
                ", vehicleType=" + vehicleType +
                ", isAvailable=" + isAvailable +
                '}';
    }
}
