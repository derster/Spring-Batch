package com.derster.BatchProccessing.methodReference;

import com.derster.BatchProccessing.Mapper.StudentMapper;
import com.derster.BatchProccessing.entity.Employee;
import com.derster.BatchProccessing.entity.Student;
import com.derster.BatchProccessing.entity.StudentResponseDto;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeMapperTest {


    private EmployeeMapper mapper;
    private StudentMapper studentMapper;

    @BeforeEach
    void setUp() {
       mapper = new EmployeeMapper();
       studentMapper = new StudentMapper();
    }

    @Test
    public void shouldMapEmployeeDoToEmployee(){
        Employee employee = new Employee(
                1,
                "John Doe",
                2000,
                "IT"
        );
        EmployeeDO dto = mapper.convertEmpl(employee);

        assertEquals(dto.getName(), employee.getName());
        assertEquals(dto.getSalary(), employee.getSalary());
        assertNotNull(dto.getId());
        assertEquals(dto.getId(), employee.getId());
    }
    @Test
    void should_map_studentDto_to_student_when_studentDto_is_null(){
        //Student student = studentMapper.toStudent(null);

        var msg = assertThrows(NullPointerException.class, () -> studentMapper.toStudent(null));
        assertEquals("The student Dto should not be null", msg.getMessage());
    }

    @Test
    void shouldMapStudentToStudentResponseDto() {
        // Given
        Student student = new Student(
               1,
                "John",
                "Doe",
                21
        );
        // When
        StudentResponseDto studentResponseDto = studentMapper.toStudentResponseDto(student);

        // Then
        assertEquals(studentResponseDto.getLastName(), student.getLastName());
        assertEquals(studentResponseDto.getAge(), student.getAge());
        assertEquals(studentResponseDto.getFirstName(), student.getFirstName());
    }

    @BeforeAll
    static void beforeAll() {
        System.out.println("Inside the before all method");
    }


    @AfterEach
    void tearDown() {
        System.out.println("Inside the after each method");
    }
    @Test
    public void testMethod1(){
        System.out.println("My first Test method");
    }

    @AfterAll
    static void afterAll() {
        System.out.println("Inside the after all method");
    }

    @Test
    public void testMethod2(){
        System.out.println("My second Test method");
    }






}