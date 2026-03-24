package com.studentprofile.service;

import com.studentprofile.entity.StudentProfile;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

public interface ExcelService {
    
    StudentProfile saveStudentProfile(StudentProfile studentProfile) throws IOException;
    StudentProfile updateStudentProfile(Long studentId);
    List<StudentProfile> fetchAllStudentProfile();
    StudentProfile fetchStudentProfile(Long studentId);
    void deleteStudentProfile(Long studentId);

}
