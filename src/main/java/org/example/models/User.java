package org.example.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class User {

    @JsonProperty("email")
    private String email;
    @JsonProperty("name")
    private String name;
    @JsonProperty("rollNo")
    private String rollNo;
    @JsonProperty("age")
    private int age;
    @JsonProperty("designation")
    private String designation;

    public User() {
    }

    public User(String email, String name, String rollNo, int age, String designation) {
        this.email = email;
        this.name = name;
        this.rollNo = rollNo;
        this.age = age;
        this.designation = designation;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRollNo() {
        return rollNo;
    }

    public void setRollNo(String rollNo) {
        this.rollNo = rollNo;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    @Override
    public String toString() {
        return "User{" +
                "email='" + email + '\'' +
                ", name='" + name + '\'' +
                ", rollNo='" + rollNo + '\'' +
                ", age=" + age +
                ", designation='" + designation + '\'' +
                '}';
    }
}
