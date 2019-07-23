package com.luminis.net.spring.cloud.pizza.course;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/course")
public class CourseResource {

    @Autowired
    public CourseResource(final RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    private RestTemplate restTemplate;

    @GetMapping
    public List<String> getAllCourses() {
        return retrieveAllCourses().stream()
                .map(Course::getName)
                .collect(Collectors.toList());
    }

    @GetMapping("/{course}")
    public Course getCourseInformation(@PathVariable final String course) {
        final Course foundCourse = retrieveAllCourses().stream()
                .filter(currentCourse -> currentCourse.getName().equals(course))
                .findFirst()
                .get();
        final ResponseEntity<List<String>> studentResponseEntity = restTemplate.exchange(
                "http://localhost:8081/student/" + course,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<String>>() {
                });

        final ResponseEntity<List<String>> teacherResponseEntity = restTemplate.exchange(
                "http://localhost:8080/teacher/" + course,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<String>>() {
                });


        foundCourse.setStudents(studentResponseEntity.getBody());
        foundCourse.setTeachers(teacherResponseEntity.getBody());

        return foundCourse;
    }


    private List<Course> retrieveAllCourses() {
        return Arrays.asList(
                new Course("Wielrennen"),
                new Course("Presenteren"),
                new Course("Liegen")
        );
    }
}

