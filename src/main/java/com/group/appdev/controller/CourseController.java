package com.group.appdev.controller;

import com.group.appdev.model.Course;
import com.group.appdev.model.Users;
import com.group.appdev.repo.CourseRepository;
import com.group.appdev.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CourseController {

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private UserRepo userRepo;

    // Get all courses
    @GetMapping("/courses")
    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    // Create a new course
    @PostMapping("/courses")
    public ResponseEntity<?> createCourse(@RequestBody Course courseData) {
        int userId = courseData.getUploadedBy().getId();
        Users user = userRepo.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        Course course = new Course();
        course.setTitle(courseData.getTitle());
        course.setImage(courseData.getImage());
        course.setUploadedBy(user); // manually set fetched user

        courseRepository.save(course);
        return ResponseEntity.ok("Course saved successfully");
    }
}
