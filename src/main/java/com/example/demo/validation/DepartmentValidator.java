/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.validation;

import com.example.demo.entities.Department;
import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

/**
 *
 * @author binod
 */
@Service("departmentValidator")
public class DepartmentValidator implements Validator {

    @Override
    public boolean supports(Class<?> type) {
        return Department.class.equals(type);
    }

    @Override
    public void validate(Object o, Errors errors) {
        Department department=(Department) o;
        if(department.getDepartmentName()==null){
             errors.rejectValue("department name", "error.departmentName.empty", "Department is required.");
        }
    }

  
    
}
