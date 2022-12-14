package com.example.springboot.springbootbackend.service.impl;

import com.example.springboot.springbootbackend.exception.ResourceNotFoundException;
import com.example.springboot.springbootbackend.model.Employee;
import com.example.springboot.springbootbackend.repository.EmployeeRepository;
import com.example.springboot.springbootbackend.service.EmployeeService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        super();
        this.employeeRepository = employeeRepository;
    }
    @Override
    public Employee saveEmployee(Employee employee){
        return employeeRepository.save(employee);
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee getEmployeeById(long id) {
        Optional<Employee> employee = employeeRepository.findById(id);
        if(employee.isPresent()){
            return  employee.get();
        }else {
            throw new ResourceNotFoundException("Employee","Id",id);
        }
    }

    @Override
    public Employee updateEmployee(Employee employee, long id) {
        //check whether the employee with given ID is exist in the DB or not
        Employee existingEmployee = employeeRepository.findById(id).orElseThrow(()->
                new ResourceNotFoundException("Employee","Id",id));

        existingEmployee.setFirstName(employee.getFirstName());
        existingEmployee.setLastName(employee.getLastName());
        existingEmployee.setEmail(employee.getEmail());
        //save existing employee to DB
        employeeRepository.save(existingEmployee);
        return existingEmployee;
    }

    @Override
    public void deleteEmployee(long id) {
        //check whether the employee with given ID is exist in the DB or not
        employeeRepository.findById(id).orElseThrow(()->
                new ResourceNotFoundException("Employee","Id",id));

        employeeRepository.deleteById(id);

    }

}
