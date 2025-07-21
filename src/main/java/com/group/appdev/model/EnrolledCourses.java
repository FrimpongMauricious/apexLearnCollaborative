package com.group.appdev.model; 
import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "enrolled_courses")
public class EnrolledCourses { // Changed class name to match file

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long userId;

    private Long courseId;

    private LocalDateTime enrolledAt = LocalDateTime.now();

    // Constructors
    public EnrolledCourses() {}

    public EnrolledCourses(Long userId, Long courseId) {
        this.userId = userId;
        this.courseId = courseId;
        this.enrolledAt = LocalDateTime.now();
    }

    // Getters and setters
    public Long getId() { return id; }
    public Long getUserId() { return userId; }
    public void setUserId(Long userId) { this.userId = userId; }

    public Long getCourseId() { return courseId; }
    public void setCourseId(Long courseId) { this.courseId = courseId; }

    public LocalDateTime getEnrolledAt() { return enrolledAt; }
    public void setEnrolledAt(LocalDateTime enrolledAt) { this.enrolledAt = enrolledAt; }
}
