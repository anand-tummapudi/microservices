package com.anand.microservices.service;

import com.anand.microservices.model.Employee;

import java.util.List;

public interface EmployeeService {
    public Employee save(Employee employee);

    List<Employee> getAllEmployees();

    Employee getEmployeeById(String employeeId);

    String deleteEmployeById(String employeeId);
}
