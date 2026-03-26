package com.studentprofile.service;

import com.studentprofile.entity.StudentProfile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

public interface ExcelService {
    
    Optional<StudentProfile> saveStudentProfile(StudentProfile studentProfile) throws IOException;
    Optional<String> updateStudentProfile(StudentProfile studentProfile, Long studentId) throws IOException;
    Optional<List<StudentProfile>> fetchAllStudentProfile() throws IOException;
    Optional<StudentProfile> fetchStudentProfile(Long studentId) throws IOException;
    void deleteStudentProfile(Long studentId) throws IOException;

}
