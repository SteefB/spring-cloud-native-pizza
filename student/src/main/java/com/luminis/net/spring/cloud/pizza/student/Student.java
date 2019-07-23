package com.luminis.net.spring.cloud.pizza.student;

import java.util.List;

public class Student {

    private String name;

    private List<String> courses;

    public Student(final String name, final List<String> courses) {
        this.name = name;
        this.courses = courses;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getCourses() {
        return courses;
    }

    public void setCourses(List<String> courses) {
        this.courses = courses;
    }
}
