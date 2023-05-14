package com.anand.microservices.service;

import com.anand.microservices.entity.EmployeeEntity;
import com.anand.microservices.model.Employee;
import com.anand.microservices.repository.EmployeeRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@Qualifier("EmployeeV2ServiceImpl")
public class EmployeeV2ServiceImpl implements EmployeeService{

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public Employee save(Employee employee) {
        if(employee.getEmployeeId()==null || employee.getEmployeeId().isEmpty()){
            employee.setEmployeeId(UUID.randomUUID().toString());
        }
        EmployeeEntity entity = new EmployeeEntity();
        BeanUtils.copyProperties(employee,entity);
        employeeRepository.save(entity);

        return employee;
    }

    @Override
    public List<Employee> getAllEmployees() {
        List<EmployeeEntity> employeeEntityList = employeeRepository.findAll();

        List<Employee> employeeList = employeeEntityList
                                    .stream()
                                    .map(employeeEntity -> {
                                        Employee employee = new Employee();
                                        BeanUtils.copyProperties(employeeEntity,employee);
                                        return employee;
                                    }).collect(Collectors.toList());
        return employeeList;
    }

    @Override
    public Employee getEmployeeById(String employeeId) {
        EmployeeEntity employeeEntity = employeeRepository.findById(employeeId).get();
        Employee employee = new Employee();
        BeanUtils.copyProperties(employeeEntity,employee);
        return employee;
    }

    @Override
    public String deleteEmployeById(String employeeId) {
        employeeRepository.deleteById(employeeId);
        return "Employee with Id:"+employeeId+" has been deleted.";
    }
}
