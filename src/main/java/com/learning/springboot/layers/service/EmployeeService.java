package com.learning.springboot.layers.service;


import com.learning.springboot.layers.DTO.EmployeeAddRequest;
import com.learning.springboot.layers.DTO.EmployeeByIdResponse;
import com.learning.springboot.layers.entity.Employee;
import com.learning.springboot.layers.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public EmployeeByIdResponse getEmployeeById(int id){
        EmployeeByIdResponse employeeByIdResponse = new EmployeeByIdResponse();

        Employee employee = employeeRepository.findById(id).orElse(null);

        if(employee == null){
            return null;
        }

        employeeByIdResponse.setEmployeeId(employee.getId());
        employeeByIdResponse.setEmployeeName(employee.getName());
        employeeByIdResponse.setEmployeeSalary(employee.getSalary());

        return employeeByIdResponse;
    }

    public int saveEmployee(EmployeeAddRequest employeeAddRequest){
        Employee employee = new Employee();
        employee.setName(employeeAddRequest.getEmployeeName());
        employee.setSalary(employeeAddRequest.getEmployeeSalary());

        return employeeRepository.save(employee).getId();
    }
}
