package com.derster.BatchProccessing.methodReference;

import java.util.Objects;

public class EmployeeDO {
    private Integer Id;
    private String name;
    private double salary;

    public EmployeeDO(Integer id, String name, double salary) {
        Id = id;
        this.name = name;
        this.salary = salary;
    }

    public EmployeeDO() {
    }

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "EmployeeDO{" +
                "Id=" + Id +
                ", name='" + name + '\'' +
                ", salary=" + salary +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EmployeeDO that = (EmployeeDO) o;
        return Double.compare(salary, that.salary) == 0 && Objects.equals(Id, that.Id) && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Id, name, salary);
    }
}
