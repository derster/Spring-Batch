package com.derster.BatchProccessing.Service.StudentService;

import com.derster.BatchProccessing.entity.StudentDto;
import com.derster.BatchProccessing.entity.StudentResponseDto;

import java.util.List;

public interface StudentService {
    StudentResponseDto saveStudent(StudentDto studentDto);
    List<StudentResponseDto> findAllStudents();
    StudentResponseDto findStudentById(Integer id);
}
