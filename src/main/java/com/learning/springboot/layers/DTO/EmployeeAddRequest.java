package com.learning.springboot.layers.DTO;

public class EmployeeAddRequest {
    public String employeeName;
    public int employeeSalary;

    public String getEmployeeName() {
        return employeeName;
    }
    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }
    public int getEmployeeSalary() {
        return employeeSalary;
    }
    public void setEmployeeSalary(int employeeSalary) {
        this.employeeSalary = employeeSalary;
    }

}
