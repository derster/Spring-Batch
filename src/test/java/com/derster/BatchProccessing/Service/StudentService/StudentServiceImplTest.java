package com.derster.BatchProccessing.Service.StudentService;

import com.derster.BatchProccessing.Mapper.StudentMapper;
import com.derster.BatchProccessing.entity.Student;
import com.derster.BatchProccessing.entity.StudentDto;
import com.derster.BatchProccessing.entity.StudentResponseDto;
import com.derster.BatchProccessing.repository.StudentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class StudentServiceImplTest {

    @InjectMocks
    private StudentServiceImpl studentService;
    @Mock
    private StudentRepository studentRepository;
    @Mock
    private StudentMapper studentMapper;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }
    @Test
    public void should_successfully_save_a_student(){
        //Given
        StudentDto dto = new StudentDto(
                1,
                "John",
                "Doe",
                21
        );
        Student student = new Student(
                1,
                "John",
                "Doe",
                21
        );
        Student saveStudent = new Student(
                1,
                "John",
                "Doe",
                21
        );
        // Mock the calls
        when(studentMapper.toStudent(dto)).thenReturn(student);
        when(studentRepository.save(student)).thenReturn(saveStudent);
        when(studentMapper.toStudentResponseDto(saveStudent)).thenReturn(
                new StudentResponseDto(
                        "John",
                "Doe",
                21
                )
        );
        //When
        StudentResponseDto responseDto = studentService.saveStudent(dto);

        // Then
        assertEquals(dto.getFirstName(), responseDto.getFirstName());
        assertEquals(dto.getLastName(), responseDto.getLastName());
        assertEquals(dto.getAge(), responseDto.getAge());

        verify(studentMapper, times(1)).toStudent(dto);
    }
}