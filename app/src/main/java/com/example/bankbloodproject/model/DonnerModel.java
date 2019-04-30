package com.example.bankbloodproject.model;

public class DonnerModel {
    String name ;
    String national_number ;
    String password ;
    String gender ;
    String age ;
    String phone_number ;
    String address ;
    String time_to_connected ;
    String donate_person ;
    String Date_Donated ;

    public DonnerModel(String name, String national_number, String password, String gender, String age, String phone_number, String address, String time_available, String donate_name, String date_donate) {
        this.name = name;
        this.national_number = national_number;
        this.password = password;
        this.gender = gender;
        this.age = age;
        this.phone_number = phone_number;
        this.address = address;
        this.time_to_connected = time_available;
        this.donate_person = donate_name;
        this.Date_Donated = date_donate;
    }


    public DonnerModel() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNational_number() {
        return national_number;
    }

    public void setNational_number(String national_number) {
        this.national_number = national_number;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTime_available() {
        return time_to_connected;
    }

    public void setTime_available(String time_available) {
        this.time_to_connected = time_available;
    }

    public String getDonate_name() {
        return donate_person;
    }

    public void setDonate_name(String donate_name) {
        this.donate_person = donate_name;
    }

    public String getDate_donate() {
        return Date_Donated;
    }

    public void setDate_donate(String date_donate) {
        this.Date_Donated = date_donate;
    }
}
