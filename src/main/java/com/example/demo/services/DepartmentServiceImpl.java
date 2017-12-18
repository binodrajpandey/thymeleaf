/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.services;

import com.example.demo.entities.Department;
import com.example.demo.exception.InvalidRequestException;
import com.example.demo.repositories.DepartmentRepository;
import com.example.demo.validation.DepartmentValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;

/**
 *
 * @author binod
 */
public class DepartmentServiceImpl implements DepartmentService{
@Autowired
private DepartmentRepository departmentRepository;
@Autowired
  private DepartmentValidator departmentValidator;
    @Override
    public void saveDepartment(Department department,BindingResult errors) {
        departmentValidator.validate(department, errors);
        if(errors.hasErrors()){
            throw new InvalidRequestException(errors);
        }
        departmentRepository.save(department);
    }
    
}
