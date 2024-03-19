package com.derster.BatchProccessing.Mapper;

import com.derster.BatchProccessing.entity.Student;
import com.derster.BatchProccessing.entity.StudentDto;
import com.derster.BatchProccessing.entity.StudentResponseDto;
import org.springframework.stereotype.Service;

@Service
public class StudentMapper {
     public Student toStudent(StudentDto dto){
         if (dto==null){
             throw new NullPointerException("The student Dto should not be null");
         }
         var student = new Student();
         student.setFirstName(dto.getFirstName());
         student.setLastName(dto.getLastName());
         student.setId(dto.getId());
         student.setAge(dto.getAge());
         return student;
     }

    public StudentResponseDto toStudentResponseDto(Student student){
        var dto = new StudentResponseDto();
        student.setFirstName(dto.getFirstName());
        student.setLastName(dto.getLastName());
        student.setAge(dto.getAge());
        return dto;
    }
}
