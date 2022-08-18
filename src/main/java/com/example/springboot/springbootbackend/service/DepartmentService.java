package com.example.springboot.springbootbackend.service;

import com.example.springboot.springbootbackend.model.Department;

import java.util.List;

public interface DepartmentService {
    Department saveDepartment(Department department);
    List<Department> getAllDepartment();
    Department getDepartmentById(long id);
    Department updateDepartment(Department department,long id);
    void deleteDepartment(long id);
}
