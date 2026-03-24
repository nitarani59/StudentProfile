package com.studentprofile.service.implementation;

import com.studentprofile.entity.StudentProfile;
import com.studentprofile.service.ExcelService;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Objects;

@Service
public class ExcelServiceImpl implements ExcelService {
    String filePath = "studentprofile.xlsx";
    @Override
    public StudentProfile saveStudentProfile(StudentProfile studentProfile) throws IOException {
        Workbook workbook;
        Sheet sheet;
        File file = new File(filePath);
        if (file.exists() && file.length() > 0) {
            workbook = WorkbookFactory.create(file);
            sheet = workbook.getSheet("studentProfile");
            if (Objects.isNull(sheet)) {
                System.out.println("sheet is null");
                sheet = workbook.createSheet("studentProfile");
                Row row = sheet.createRow(0);
                row.createCell(0).setCellValue("studentId");
                row.createCell(1).setCellValue("studentName");
                row.createCell(2).setCellValue("age");
                row.createCell(3).setCellValue("email");
                row.createCell(4).setCellValue("course");
            }
        }
        else {
            System.out.println("inside else");
            workbook = new XSSFWorkbook();
            sheet = workbook.createSheet("studentProfile");
            System.out.println(file.getAbsolutePath());
            Row row = sheet.createRow(0);
            row.createCell(0).setCellValue("studentId");
            row.createCell(1).setCellValue("studentName");
            row.createCell(2).setCellValue("age");
            row.createCell(3).setCellValue("email");
            row.createCell(4).setCellValue("course");
        }
        int lastRowNumber = sheet.getLastRowNum();
        Row row = sheet.createRow(lastRowNumber + 1);
        row.createCell(0).setCellValue(studentProfile.getStudentId());
        row.createCell(1).setCellValue(studentProfile.getStudentName());
        row.createCell(2).setCellValue(studentProfile.getAge());
        row.createCell(3).setCellValue(studentProfile.getEmailId());
        row.createCell(4).setCellValue(studentProfile.getCourse());
        // Writing data to temporary file to prevent corruption
        File tempFile = new File("studentprofile_temp.xlsx");

        try (FileOutputStream fos = new FileOutputStream(tempFile)) {
            workbook.write(fos);
        }
        workbook.close();

        if (file.exists()) {
            file.delete();
        }

        tempFile.renameTo(file);

        return studentProfile;
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
