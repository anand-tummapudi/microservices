package com.anand.microservices.controller;

import com.anand.microservices.model.Employee;
import com.anand.microservices.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v2/employees")
public class EmployeeV2Controller {

    @Autowired(required = true)
    @Qualifier("EmployeeV2ServiceImpl")
    private EmployeeService employeeService;

    @PostMapping("/save")
    public Employee save(@RequestBody Employee employee){
        return employeeService.save(employee);
    }

    @GetMapping
    public List<Employee> getAllEmployees(){
        return employeeService.getAllEmployees();
    }

    @GetMapping("{id}")
    public Employee getEmployeeById(@PathVariable("id") String employeeId){
        return employeeService.getEmployeeById(employeeId);
    }

    @DeleteMapping("{id}")
    public String deleteEmployeeById(@PathVariable("id") String employeeId){
        return employeeService.deleteEmployeById(employeeId);
    }
}
