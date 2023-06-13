package com.anand.springbatch.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="EMPLOYEE")
public class Employee {

    @Id
    @Column(name="EMPLOYEE_ID")
    int id;
    @Column(name="FIRST_NAME")
    String firstName;
    @Column(name="LAST_NAME")
    String lastName;

    @Column(name="EMAIL")
    String email;
    @Column(name="PHONE_NUMBER")
    String phoneNumber;
    @Column(name="HIRE_DATE")
    String hireDate;
    @Column(name="SALARY")
    long salary;
    @Column(name="MANAGER_ID")
    int managerid;
    @Column(name="DEPARTMENT_ID")
    int departmentId;
}
