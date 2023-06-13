package com.anand.springbatch.config;

import com.anand.springbatch.entity.Employee;
import org.springframework.batch.item.ItemProcessor;

public class EmployeeDataProcessor implements ItemProcessor<Employee,Employee> {

    @Override
    public Employee process(Employee employee) throws Exception {
        return employee;
    }
}
