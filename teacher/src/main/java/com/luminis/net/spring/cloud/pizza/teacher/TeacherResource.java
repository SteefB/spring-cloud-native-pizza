package com.luminis.net.spring.cloud.pizza.teacher;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/teacher")
public class TeacherResource {

    @GetMapping
    public List<String> getAllTeachers() {
        return retrieveAllTeachers().stream()
                .map(Teacher::getName)
                .collect(Collectors.toList());
    }

    @GetMapping("/{course}")
    public List<String> getTeachersByCourse(@PathVariable final String course) {
        return retrieveAllTeachers().stream()
                .filter(teacher -> teacher.getCourse().equals(course))
                .map(Teacher::getName)
                .collect(Collectors.toList());
    }

    private List<Teacher> retrieveAllTeachers() {
        return Arrays.asList(
                new Teacher("Mart Smeets", "Zelfspot"),
                new Teacher("Lance Armstrong", "Presenteren"),
                new Teacher("Steven Kruijswijk", "Wielrennen")
        );
    }
}
