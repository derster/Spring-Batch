package com.derster.BatchProccessing.methodReference;

import com.derster.BatchProccessing.entity.Employee;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class EmployeeService {

    public List<Employee> loadEmployeesFromDB(){
        return IntStream.rangeClosed(1, 10)
                .mapToObj(i -> new Employee(i, "Employee __"+i, new Random().nextInt(5000), "IT"))
                .collect(Collectors.toList());
    }
}
