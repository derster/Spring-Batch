package com.derster.BatchProccessing.methodReference;

import com.derster.BatchProccessing.entity.Employee;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;

public class MethodeReference {







    public void m1(){
        System.out.println("m1() instance/non-static method");
    }
    public static void m2(){
        System.out.println("m1() instance/static method");
    }

    public static void main(String[] args) {

            // reference :: methodName
            // MethodeReference::m2(); // Static method reference

            // MethodeReference reference = new MethodeReference();
            // reference.m1();

            // reference::m1(); // instance method reference

            // Constructor reference

        // Lambda
        EmployeeManager employeeManager = Employee::new;
        employeeManager.getEmployee().getEmployeeInfo();


        EmployeeService employeeService = new EmployeeService();

        employeeService.loadEmployeesFromDB().stream()
                .forEach(new Consumer<Employee>() {
                    @Override
                    public void accept(Employee employee) {
                        System.out.println(employee);
                    }
                });

        employeeService.loadEmployeesFromDB().stream()
                .forEach(System.out::println);

        employeeService.loadEmployeesFromDB().stream()
                .forEach(MethodeReference::print);

        // Anonymous Function
        List<Object> collect = employeeService.loadEmployeesFromDB().stream()
                .map(new Function<Employee, Object>() {
                    @Override
                    public EmployeeDO apply(Employee employee) {
                        EmployeeDO employeeDO = new EmployeeDO();
                        employeeDO.setId(employee.getId());
                        employeeDO.setName(employee.getName());
                        employeeDO.setSalary(employee.getSalary());
                        return employeeDO;
                    }
                }).collect(Collectors.toList());

        // Lambda express
        List<Object> collect2 = employeeService.loadEmployeesFromDB().stream()
                .map((employee) -> {
                    EmployeeDO employeeDO = new EmployeeDO();
                    employeeDO.setId(employee.getId());
                    employeeDO.setName(employee.getName());
                    employeeDO.setSalary(employee.getSalary());
                    return employeeDO;
                }).collect(Collectors.toList());

        // Call methode
        List<Object> collect3 = employeeService.loadEmployeesFromDB().stream()
                .map((employee) -> EmployeeMapper.convert(employee)).collect(Collectors.toList());

        // Call methode reference
        List<Object> collect4 = employeeService.loadEmployeesFromDB().stream()
                .map(EmployeeMapper::convert).collect(Collectors.toList());

        List<Object> collect5 = employeeService.loadEmployeesFromDB().stream()
                .map(Employee::getName).collect(Collectors.toList());

        System.out.println(collect5);

        // Constructor reference


        List<Integer> collect1 = employeeService.loadEmployeesFromDB().stream()
                .map(Employee::getId)
                .collect(Collectors.toList());

        System.out.println(collect1);


    }

    public static void print(Employee employee){
        System.out.println(employee);
    }
}
