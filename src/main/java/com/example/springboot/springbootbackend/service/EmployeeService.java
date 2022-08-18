package com.example.springboot.springbootbackend.service;

import com.example.springboot.springbootbackend.model.Employee;

import javax.persistence.Id;
import java.util.List;

public interface EmployeeService {
    Employee saveEmployee(Employee employee);
    List<Employee> getAllEmployees();
    Employee getEmployeeById(long id);
    Employee updateEmployee(Employee employee, long Id);
    void deleteEmployee(long id);
}
