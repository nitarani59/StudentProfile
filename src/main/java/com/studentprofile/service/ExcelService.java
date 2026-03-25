package com.studentprofile.service;

import com.studentprofile.entity.StudentProfile;

import java.io.IOException;
import java.util.List;

public interface ExcelService {
    
    StudentProfile saveStudentProfile(StudentProfile studentProfile) throws IOException;
    String updateStudentProfile(StudentProfile studentProfile, Long studentId) throws IOException;
    List<StudentProfile> fetchAllStudentProfile() throws IOException;
    StudentProfile fetchStudentProfile(Long studentId) throws IOException;
    void deleteStudentProfile(Long studentId) throws IOException;

}
