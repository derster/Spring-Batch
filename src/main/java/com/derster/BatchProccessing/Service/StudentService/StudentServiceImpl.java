package com.derster.BatchProccessing.Service.StudentService;

import com.derster.BatchProccessing.Mapper.StudentMapper;
import com.derster.BatchProccessing.entity.Student;
import com.derster.BatchProccessing.entity.StudentDto;
import com.derster.BatchProccessing.entity.StudentResponseDto;
import com.derster.BatchProccessing.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService{
    private final StudentRepository studentRepository;
    private final StudentMapper studentMapper;

    public StudentServiceImpl(StudentRepository studentRepository, StudentMapper studentMapper) {
        this.studentRepository = studentRepository;
        this.studentMapper = studentMapper;
    }

    @Override
    public StudentResponseDto saveStudent(StudentDto studentDto) {
        Student student = studentMapper.toStudent(studentDto);

        return studentMapper.toStudentResponseDto(studentRepository.save(student));
    }

    @Override
    public List<StudentResponseDto> findAllStudents() {
        return studentRepository.findAll()
                .stream()
                .map(studentMapper::toStudentResponseDto)
                .toList();
    }

    @Override
    public StudentResponseDto findStudentById(Integer id) {
        return studentRepository.findById(id)
                .map(studentMapper::toStudentResponseDto)
                .orElse(null);
    }
}
