package com.anand.microservices.service;

import com.anand.microservices.exception.EmployeeNotFoundException;
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

    @Override
    public List<Employee> getAllEmployees() {
        return employeeList;
    }

    @Override
    public Employee getEmployeeById(String employeeId) {
        return employeeList
                .stream()
                .filter(employee->employee.getEmployeeId().equals(employeeId))
                .findFirst()
                .orElseThrow(()->new EmployeeNotFoundException("Employee Not Found with Id:"+employeeId));
    }

    @Override
    public String deleteEmployeById(String employeeId) {
        Employee employee = employeeList.stream()
                            .filter(e-> e.getEmployeeId().equals(employeeId))
                            .findFirst().get();
        employeeList.remove(employee);
        return "Employee with Id:"+employeeId+" has been deleted.";
    }
}
