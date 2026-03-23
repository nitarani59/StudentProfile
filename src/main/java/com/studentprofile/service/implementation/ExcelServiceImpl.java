package com.studentprofile.service.implementation;

import com.studentprofile.entity.StudentProfile;
import com.studentprofile.service.ExcelService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExcelServiceImpl implements ExcelService {
    @Override
    public StudentProfile saveStudentProfile() {
        return null;
    }

    @Override
    public StudentProfile updateStudentProfile(Long studentId) {
        return null;
    }

    @Override
    public List<StudentProfile> fetchAllStudentProfile() {
        return List.of();
    }

    @Override
    public StudentProfile fetchStudentProfile(Long studentId) {
        return null;
    }

    @Override
    public void deleteStudentProfile(Long studentId) {

    }
}
