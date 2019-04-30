package com.example.bankbloodproject.model;

public class patientModel {
    private String name;
    private String age;
    private String address;
    private String hospital;
    private String gender;
    private String telephone;
    private String nationalNumber;

    public patientModel() {
    }

    public patientModel(String name, String age, String address, String hospital, String gender, String telephone, String nationalNumber) {
        this.name = name;
        this.age = age;
        this.address = address;
        this.hospital = hospital;
        this.gender = gender;
        this.telephone = telephone;
        this.nationalNumber = nationalNumber;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setHospital(String hospital) {
        this.hospital = hospital;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public void setNationalNumber(String nationalNumber) {
        this.nationalNumber = nationalNumber;
    }

    public String getName() {
        return name;
    }

    public String getAge() {
        return age;
    }

    public String getAddress() {
        return address;
    }

    public String getHospital() {
        return hospital;
    }

    public String getGender() {
        return gender;
    }

    public String getTelephone() {
        return telephone;
    }

    public String getNationalNumber() {
        return nationalNumber;
    }
}
