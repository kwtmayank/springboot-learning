package com.learning.springboot.layers.controller;

import com.learning.springboot.layers.DTO.EmployeeAddRequest;
import com.learning.springboot.layers.DTO.EmployeeByIdRequest;
import com.learning.springboot.layers.DTO.EmployeeByIdResponse;
import com.learning.springboot.layers.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/{id}")
    public EmployeeByIdResponse getEmployeeById(@PathVariable int id){
        EmployeeByIdResponse employeeByIdResponse = employeeService.getEmployeeById(id);

        return employeeByIdResponse;
    }

    @PostMapping("/add")
    public EmployeeByIdResponse addEmployee(@RequestBody EmployeeAddRequest employeeAddRequest){
        int empId = employeeService.saveEmployee(employeeAddRequest);
        if(empId > 0){
            return employeeService.getEmployeeById(empId);
        }
        return null;
    }
}
