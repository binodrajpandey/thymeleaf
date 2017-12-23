/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.repositories;

import com.example.demo.entities.Department;
import java.io.Serializable;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author binod
 */
public interface DepartmentRepository extends JpaRepository<Department, Long>{
    Department findByDepartmentName(String departmentName);
    
}
