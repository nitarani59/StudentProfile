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
import java.util.ArrayList;
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
            // Validating StudentId
            // Throw exception if student id already exists
            validateStudentId(sheet, studentProfile.getStudentId());
        } else {
            workbook = new XSSFWorkbook();
            sheet = workbook.createSheet("studentProfile");
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
    public String updateStudentProfile(StudentProfile student, Long studentId) throws IOException {
        File file = new File("studentprofile.xlsx");
        if (file.exists() && file.length() > 0) {
            Workbook workbook = WorkbookFactory.create(file);
            Sheet sheet = workbook.getSheet("studentProfile");
            checkIfStudentNotExist(sheet, studentId);
            int totalRows = sheet.getLastRowNum();
            // Since I already know that at index 0 studentId is present in the sheet.
            // That's why skipping studentId column checking
            for (int i = 1; i <= totalRows; i++) {
                Row row = sheet.getRow(i);
                long cellValue = (long) row.getCell(0).getNumericCellValue();
                if (cellValue == studentId) {
                    if (Objects.nonNull(student.getStudentName())) {
                        row.getCell(1).setCellValue(student.getStudentName());
                    }
                    if (Objects.nonNull(student.getAge())) {
                        row.getCell(2).setCellValue(student.getAge());
                    }
                    if (Objects.nonNull(student.getEmailId())) {
                        row.getCell(3).setCellValue(student.getEmailId());
                    }
                    if (Objects.nonNull(student.getCourse())) {
                        row.getCell(4).setCellValue(student.getCourse());
                    }
                    // creating & storing in temporary file to prevent corruption
                    File tempFile = new File("temp.xlsx");
                    try(FileOutputStream fileOutputStream = new FileOutputStream(tempFile)) {
                        workbook.write(fileOutputStream);
                    }
                    workbook.close();
                    if (file.exists()) {
                        file.delete();
                    }
                    tempFile.renameTo(file);
                    return "Updated Successfully";
                }
            }
            workbook.close();
        }
        return null;
    }

    @Override
    public List<StudentProfile> fetchAllStudentProfile() throws IOException {
        File file = new File("studentprofile.xlsx");
        if (file.exists() && file.length() > 0) {
            Workbook workbook = WorkbookFactory.create(file);
            Sheet sheet = workbook.getSheet("studentProfile");
            int totalRows = sheet.getLastRowNum();
            List<StudentProfile> students = new ArrayList<>();
            for (int i = 1; i <= totalRows; i++) {
                StudentProfile student = new StudentProfile();
                Row row = sheet.getRow(i);
                student.setStudentId((long) row.getCell(0).getNumericCellValue());
                student.setStudentName(row.getCell(1).getStringCellValue());
                student.setAge((int) row.getCell(2).getNumericCellValue());
                student.setEmailId(row.getCell(3).getStringCellValue());
                student.setCourse(row.getCell(4).getStringCellValue());

                students.add(student);
            }
            workbook.close();
            return students;
        }
        return null;
    }

    @Override
    public StudentProfile fetchStudentProfile(Long studentId) throws IOException {
        File file = new File("studentprofile.xlsx");
        if (file.exists() && file.length() > 0) {
            Workbook workbook = WorkbookFactory.create(file);
            Sheet sheet = workbook.getSheet("studentProfile");
            checkIfStudentNotExist(sheet, studentId);
            int totalRows = sheet.getLastRowNum();
            StudentProfile student = new StudentProfile();
            // Since I already know that at index 0 studentId is present in the sheet.
            // That's why skipping studentId column checking
            for (int i = 1; i <= totalRows; i++) {
                Row row = sheet.getRow(i);
                long cellValue = (long) row.getCell(0).getNumericCellValue();
                if (cellValue == studentId) {
                    student.setStudentId((long) row.getCell(0).getNumericCellValue());
                    student.setStudentName(row.getCell(1).getStringCellValue());
                    student.setAge((int) row.getCell(2).getNumericCellValue());
                    student.setEmailId(row.getCell(3).getStringCellValue());
                    student.setCourse(row.getCell(4).getStringCellValue());

                    workbook.close();
                    return student;
                }
            }
            workbook.close();
        }
        return null;
    }

    @Override
    public void deleteStudentProfile(Long studentId) throws IOException {
        File file = new File("studentprofile.xlsx");
        if (file.exists() && file.length() > 0) {
            Workbook workbook = WorkbookFactory.create(file);
            Sheet sheet = workbook.getSheet("studentProfile");
            checkIfStudentNotExist(sheet, studentId);
            Row header = sheet.getRow(0);
            int totalRows = sheet.getLastRowNum();
            // Since I already know that at index 0 studentId is present in the sheet.
            // That's why skipping studentId column checking
            for (int i = 1; i <= totalRows; i++) {
                Row row = sheet.getRow(i);
                long cellValue = (long) row.getCell(0).getNumericCellValue();
                if (cellValue == studentId) {
                    sheet.removeRow(row);
                    // Observed that after removing row a gap is getting created, to avoid it shifting of rows needed
                    if (i < totalRows) {
                        sheet.shiftRows(i + 1, totalRows, -1);
                    }
                    // To prevent file corruption writing to temporary file
                    File tempFile = new File("temp.xlsx");
                    try (FileOutputStream fileOutputStream = new FileOutputStream(tempFile)) {
                        workbook.write(fileOutputStream);
                    }
                    workbook.close();
                    if (file.exists()) {
                        file.delete();
                    }
                    tempFile.renameTo(file);
                    return;
                }
            }
            workbook.close();
        }
    }

    private void validateStudentId(Sheet sheet, Long studentId) {
        int totalRows = sheet.getLastRowNum();
        for (int i = 1; i <= totalRows; i++) {
            Row row = sheet.getRow(i);
            if (studentId == row.getCell(0).getNumericCellValue()) {
                throw new RuntimeException("Student Id " + studentId + "  already exist.");
            }
        }
    }

    private void checkIfStudentNotExist(Sheet sheet, Long studentId) {
        int totalRows = sheet.getLastRowNum();
        for (int i = 1; i <= totalRows; i++) {
            Row row = sheet.getRow(i);
            if (studentId == row.getCell(0).getNumericCellValue()) {
                return;
            }
        }
        throw new RuntimeException("Student id " + studentId + " not exist");
    }
}
