package com.derster.BatchProccessing.methodReference;

import com.derster.BatchProccessing.entity.Employee;
import org.springframework.stereotype.Service;

@Service
public class EmployeeMapper {

    public static EmployeeDO convert(Employee employee){
        EmployeeDO employeeDO = new EmployeeDO();
        employeeDO.setId(employee.getId());
        employeeDO.setName(employee.getName());
        employeeDO.setSalary(employee.getSalary());
        return employeeDO;
    }

    public EmployeeDO convertEmpl(Employee employee){
        EmployeeDO employeeDO = new EmployeeDO();
        employeeDO.setId(employee.getId());
        employeeDO.setName(employee.getName());
        employeeDO.setSalary(employee.getSalary());
        return employeeDO;
    }


}
