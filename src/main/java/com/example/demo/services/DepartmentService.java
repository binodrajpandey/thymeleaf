/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.services;

import com.example.demo.dtos.DepartmentDTO;
import com.example.demo.entities.Department;
import java.util.List;
import org.springframework.validation.BindingResult;

/**
 *
 * @author binod
 */
public interface DepartmentService {
    void saveDepartment(Department department,BindingResult errors);
    List<DepartmentDTO> findAllDepartments();
    
}
