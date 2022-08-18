package com.example.springboot.springbootbackend.service.impl;

import com.example.springboot.springbootbackend.exception.ResourceNotFoundException;
import com.example.springboot.springbootbackend.model.Department;
import com.example.springboot.springbootbackend.repository.DepartmentRepository;
import com.example.springboot.springbootbackend.service.DepartmentService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentServiceImpl implements DepartmentService {
    private DepartmentRepository departmentRepository;

    public DepartmentServiceImpl(DepartmentRepository departmentRepository) {
        super();
        this.departmentRepository = departmentRepository;
    }

    @Override
    public Department saveDepartment(Department department) {
        return departmentRepository.save(department);
    }

    @Override
    public List<Department> getAllDepartment() {
        return departmentRepository.findAll();
    }

    @Override
    public Department getDepartmentById(long id) {
        Department getDepartmentById=departmentRepository.findById(id).orElseThrow(()->
                new ResourceNotFoundException("Department","Id",id));
        return getDepartmentById;
    }

    @Override
    public Department updateDepartment(Department department, long id) {
        Department departmentExist= departmentRepository.findById(id).orElseThrow(()->
                new ResourceNotFoundException("Department","Id",id));
        departmentExist.setDepartmentName(department.getDepartmentName());
        departmentRepository.save(departmentExist);
        return departmentExist;

    }

    @Override
    public void deleteDepartment(long id) {
        departmentRepository.findById(id).orElseThrow(()->
                new ResourceNotFoundException("Department","Id",id));
        departmentRepository.deleteById(id);

    }
}
