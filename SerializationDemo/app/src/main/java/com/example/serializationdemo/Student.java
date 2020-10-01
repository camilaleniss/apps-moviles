package com.example.serializationdemo;

import java.io.Serializable;

public class Student implements Serializable {

    private String name;
    private String email;
    private String username;
    private String university;

    public Student() {
    }

    public Student(String name, String email, String username, String university) {
        this.name = name;
        this.email = email;
        this.username = username;
        this.university = university;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUniversity() {
        return university;
    }

    public void setUniversity(String university) {
        this.university = university;
    }
}
