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

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
        verify(studentRepository, times(1)).save(student);
        verify(studentMapper, times(1)).toStudentResponseDto(saveStudent);
    }

    @Test
    public void should_successfully_find_all_student(){
        // Given
        List<Student> students = new ArrayList<>();

        Student student = new Student(
                1,
                "John",
                "Doe",
                21
        );

        students.add(student);

        // Mock the calls
        when(studentRepository.findAll()).thenReturn(students);
        when(studentMapper.toStudentResponseDto(any(Student.class))).thenReturn(new StudentResponseDto(
                "John",
                "Doe",
                21
        ));

        // When
        List<StudentResponseDto> result = studentService.findAllStudents();

        // Then
        assertEquals(students.size(), result.size());
        assertEquals(students.get(0).getLastName(), result.get(0).getLastName());

        verify(studentRepository, times(1)).findAll();
        verify(studentMapper, times(1)).toStudentResponseDto(student);

    }

    @Test
    public void should_successfully_find_student_by_id(){

        // Given
        Student student = new Student(
                1,
                "John",
                "Doe",
                21
        );
        StudentResponseDto responseDto = new StudentResponseDto(
                "John",
                "Doe",
                21
        );
        int id = 1;

        // Mock the Calls
        when(studentRepository.findById(id)).thenReturn(Optional.of(student));
        when(studentMapper.toStudentResponseDto(student)).thenReturn(responseDto);

        // When
        Student result = studentRepository.findById(id).orElse(null);

        // Then
        assertEquals(student.getLastName(), result.getLastName());
        assertEquals(student.getFirstName(), result.getFirstName());
        verify(studentRepository, times(1)).findById(id);
        verify(studentMapper, times(1)).toStudentResponseDto(student);

    }
}