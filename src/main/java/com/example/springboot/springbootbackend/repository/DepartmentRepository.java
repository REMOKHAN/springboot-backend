package com.example.springboot.springbootbackend.repository;

import com.example.springboot.springbootbackend.model.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository <Department,Long>{
}
