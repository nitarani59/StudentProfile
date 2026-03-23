package com.studentprofile.service;

import com.studentprofile.entity.StudentProfile;
import org.springframework.stereotype.Service;

import java.util.List;

public interface ExcelService {
    
    StudentProfile saveStudentProfile();
    StudentProfile updateStudentProfile(Long studentId);
    List<StudentProfile> fetchAllStudentProfile();
    StudentProfile fetchStudentProfile(Long studentId);
    void deleteStudentProfile(Long studentId);

}
