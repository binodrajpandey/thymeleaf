/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.controllers;

import com.example.demo.entities.Department;
import com.example.demo.repositories.DepartmentRepository;
import java.awt.PageAttributes;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author binod
 */
@RestController
public class DepartmentController {
    @Autowired
    private DepartmentRepository departmentRepository;
    @PostMapping(value = "/department")
    public void saveDepartment(@RequestBody Department department){
        System.out.println("came");
        departmentRepository.save(department);
    }
    @GetMapping("/departments")
    public List<Department> getAllDepartments(){
        System.out.println("list called");
        return departmentRepository.findAll();
    }
    
}
