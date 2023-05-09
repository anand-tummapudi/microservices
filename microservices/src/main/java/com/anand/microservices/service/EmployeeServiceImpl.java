package com.anand.microservices.service;

import com.anand.microservices.model.Employee;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class EmployeeServiceImpl implements EmployeeService{
    List<Employee> employeeList = new ArrayList<>();

    public Employee save(Employee employee){
        if(employee.getEmployeeId()==null || employee.getEmployeeId().isEmpty()){
            employee.setEmployeeId(UUID.randomUUID().toString());
        }
        employeeList.add(employee);
        return employee;
    }
}
