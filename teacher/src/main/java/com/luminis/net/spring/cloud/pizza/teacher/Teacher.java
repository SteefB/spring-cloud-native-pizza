package com.luminis.net.spring.cloud.pizza.teacher;

import java.util.List;

public class Teacher {

    private final String name;

    private final String course;

    public Teacher(final String name, String course) {
        this.name = name;
        this.course = course;
    }

    public String getName() {
        return name;
    }

    public String getCourse() {
        return course;
    }
}
