/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.controllers;

import com.example.demo.entities.Department;
import com.example.demo.repositories.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
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
    @PostMapping("/department")
    public void saveDepartment(@RequestBody Department department){
        departmentRepository.save(department);
        
        
    }
    
}
