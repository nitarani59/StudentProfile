package com.studentprofile.controller;

import com.studentprofile.entity.StudentProfile;
import com.studentprofile.service.ExcelService;
import jakarta.validation.Valid;
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
    public StudentProfile createStudentProfile(@RequestBody @Valid StudentProfile studentProfile) throws IOException {
        // store in Excel
        return excelService.saveStudentProfile(studentProfile).orElseThrow(() -> new RuntimeException("Encounter exception while creating student Profile."));
    }

    @PutMapping("/updateProfile/{studentId}")
    public String updateStudentProfile(@RequestBody @Valid StudentProfile studentProfile, @PathVariable Long studentId) throws IOException {
        // update in excel
        return excelService.updateStudentProfile(studentProfile, studentId).orElseThrow(() -> new RuntimeException("Encounter exception while updating student Profile."));
    }

    @GetMapping("/getAllProfile")
    public List<StudentProfile> getAllStudentProfile() throws IOException {
        // fetch all student profile
        return excelService.fetchAllStudentProfile().orElseThrow(() -> new RuntimeException("Encounter exception while fetching student Profiles."));
    }

    @GetMapping("/getProfile/{studentId}")
    public StudentProfile getStudentProfile(@PathVariable Long studentId) throws IOException {
        // fetch student profile by studentId
        return excelService.fetchStudentProfile(studentId).orElseThrow(() -> new RuntimeException("Encounter exception while fetching student Profile."));
    }

    @DeleteMapping("/deleteProfile/{studentId}")
    public void deleteStudentprofile(@PathVariable Long studentId) throws IOException {
        // delete student profile by studentId
        excelService.deleteStudentProfile(studentId);
    }
}
