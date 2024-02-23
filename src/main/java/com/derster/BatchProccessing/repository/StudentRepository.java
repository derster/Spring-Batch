package com.derster.BatchProccessing.repository;

import com.derster.BatchProccessing.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Integer> {
}
