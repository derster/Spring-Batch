package com.derster.BatchProccessing.methodReference;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeMapperTest {

    @BeforeEach
    void setUp() {
        System.out.println("Inside the before each method");
    }
    @AfterEach
    void tearDown() {
        System.out.println("Inside the after each method");
    }
    @Test
    public void testMethod1(){
        System.out.println("My first Test method");
    }

    @Test
    public void testMethod2(){
        System.out.println("My second Test method");
    }
}