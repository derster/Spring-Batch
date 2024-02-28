package com.derster.BatchProccessing.entity;

public class Employee {
    private Integer Id;
    private String name;
    private double salary;
    private String domain;

    public Employee(Integer id, String name, double salary, String domain) {
        Id = id;
        this.name = name;
        this.salary = salary;
        this.domain = domain;
    }

    public Employee() {
    }

    public Integer getId() {
        return Id;
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }

    public String getDomain() {
        return domain;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "Id=" + Id +
                ", name='" + name + '\'' +
                ", salary=" + salary +
                ", domain='" + domain + '\'' +
                '}';
    }

    public void getEmployeeInfo(){
        System.out.println("I'm methode in Employee class !");
    }
}
