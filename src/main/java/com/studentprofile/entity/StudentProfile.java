package com.studentprofile.entity;

import lombok.Data;

@Data
public class StudentProfile {
    private Long studentId;
    private String studentName;
    private Integer age;
    private Integer emailId;
    private String course;
}
