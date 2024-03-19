package com.derster.BatchProccessing.Service.StudentService;

import com.derster.BatchProccessing.entity.StudentDto;
import com.derster.BatchProccessing.entity.StudentResponseDto;

public interface StudentService {
    StudentResponseDto saveStudent(StudentDto studentDto);
}
