package com.studentprofile.controller;

import com.studentprofile.entity.StudentProfile;
import com.studentprofile.service.ExcelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/v1")
public class StudentProfileController {

    @Autowired
    private ExcelService excelService;
    @PostMapping("/createProfile")
    public StudentProfile createStudentProfile(@RequestBody StudentProfile studentProfile) throws IOException {
        // store in Excel
        return excelService.saveStudentProfile(studentProfile);
    }

    @PutMapping("/updateProfile/{studentId}")
    public StudentProfile updateStudentProfile(@RequestBody StudentProfile studentProfile, Long studentId) {
        // update in excel
        return excelService.updateStudentProfile(studentId);
    }

    @GetMapping("/getAllProfile")
    public List<StudentProfile> getAllStudentProfile() {
        // fetch all student profile
        return excelService.fetchAllStudentProfile();
    }

    @GetMapping("/getProfile")
    public StudentProfile getStudentProfile(@PathVariable Long studentId) {
        // fetch student profile by studentId
        return excelService.fetchStudentProfile(studentId);
    }

    @DeleteMapping("/deleteProfile")
    public void deleteStudentprofile(@PathVariable Long studentId) {
        // delete student profile by studentId
        excelService.deleteStudentProfile(studentId);
    }
}
