package com.example.springboot.springbootbackend.controller;

import com.example.springboot.springbootbackend.model.Department;
import com.example.springboot.springbootbackend.service.DepartmentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/department")
public class DepartmentController {

    private DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        super();
        this.departmentService=departmentService;
    }
    @PostMapping()
    public ResponseEntity<Department> saveDepartment(@RequestBody Department department){
        return new ResponseEntity<Department>(departmentService.saveDepartment(department), HttpStatus.CREATED);
    }
    @GetMapping
    public List<Department> getAllDepartment(){
        return departmentService.getAllDepartment();
    }
    @GetMapping("{id}")
    public ResponseEntity<Department> getDepartmentById(@PathVariable("id") long departmentId){
        return new ResponseEntity<Department>(departmentService.getDepartmentById(departmentId),HttpStatus.OK);
    }
    @PutMapping("{id}")
    public ResponseEntity<Department > updateDepartment(@PathVariable("id") long id,@RequestBody Department department){
        return new ResponseEntity<Department>(departmentService.updateDepartment(department,id),HttpStatus.OK);
    }
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteDepartment(@PathVariable("id") long id){
        departmentService.deleteDepartment(id);
        return new ResponseEntity<String>("Department Deleted Successfully!.",HttpStatus.OK);
    }


}
