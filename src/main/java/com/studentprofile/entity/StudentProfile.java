package com.studentprofile.entity;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@NoArgsConstructor
public class StudentProfile {
    @NonNull
    private Long studentId;
    @NotBlank(message = "Student Name is required")
    private String studentName;
    @Min(value = 1, message = "Age must be greater than 1")
    private Integer age;
    @Email(message = "Invalid email format")
    private String emailId;
    private String course;
}
