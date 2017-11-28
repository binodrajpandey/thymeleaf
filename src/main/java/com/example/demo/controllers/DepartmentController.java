package com.example.demo.controllers;

import com.example.demo.entities.Department;
import com.example.demo.repositories.DepartmentRepository;
import java.awt.PageAttributes;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author binod
 */
@RestController
@Transactional
public class DepartmentController {
    @Autowired
    private DepartmentRepository departmentRepository;
   
    @GetMapping("/departments")
    public List<Department> getAllDepartments(){
        System.out.println("list called");
        return departmentRepository.findAll();
    }
    @GetMapping("/departments/names")
    public List<String> getAllDepartmentNames(){
        System.out.println("list called");
        return departmentRepository.findAll()
                .stream()
                .map(d->d.getName())
                .collect(Collectors.toList());
    }
    
     @PostMapping(value = "/department")
    public void saveDepartment(@RequestBody Department department){
        System.out.println("came with id"+department.getDepartmentId());
        if(department.getDepartmentId()==null){
            departmentRepository.save(department);
        }else{
            Department newDepartment=departmentRepository.findOne(department.getDepartmentId());
            newDepartment.setName(department.getName());
            
        }
    }
    @DeleteMapping(value = "/departments")
    public void delete(@RequestParam Long departmentId){
        System.out.println("delete called for id"+departmentId);
        departmentRepository.delete(departmentId);
    }
    
}
