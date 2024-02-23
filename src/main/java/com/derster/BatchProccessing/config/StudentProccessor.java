package com.derster.BatchProccessing.config;

import com.derster.BatchProccessing.entity.Student;
import org.springframework.batch.item.ItemProcessor;

public class StudentProccessor implements ItemProcessor<Student, Student> {
    @Override
    public Student process(Student student) throws Exception {
        student.setId(null);
        return student;
    }
}
