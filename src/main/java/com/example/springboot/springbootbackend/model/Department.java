package com.example.springboot.springbootbackend.model;
import lombok.Data;
import javax.persistence.*;

@Data
@Entity
@Table(name = "department")
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long departmentId;
    @Column(name = "department_name",nullable = false)
    private String departmentName;

}
