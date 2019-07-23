package com.luminis.net.spring.cloud.pizza.student;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/student")
public class StudentResource {

    @GetMapping
    public List<String> getAllStudent() {
        return retrieveAllStudents().stream()
                .map(Student::getName)
                .collect(Collectors.toList());
    }

    @GetMapping("/{course}")
    public List<String> getStudentsByCourse(@PathVariable("course") final String course) {
        return retrieveAllStudents().stream()
                .filter(student -> student.getCourses().stream().anyMatch(currentCourse -> currentCourse.equals(course)))
                .map(Student::getName)
                .collect(Collectors.toList());
    }

    private List<Student> retrieveAllStudents() {
        return Arrays.asList(
                new Student("Herman van der Zandt", Collections.singletonList("Presenteren")),
                new Student("Cees Bol", Arrays.asList("Zelfspot", "Wielrennen"))
        );

    }
}
