
package com.example.demo.controllers;

import com.example.demo.entities.Student;
import com.example.demo.entities.StudentResource;
import com.example.demo.repositories.DepartmentRepository;
import com.example.demo.repositories.StudentRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author binod
 */
@RestController
public class StudentController {
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private DepartmentRepository departmentRepository;
    @PostMapping("/students")
    public ResponseEntity<?> saveStudent(@RequestBody StudentResource student){
        System.out.println("comeing");
        Student std=new Student();
        std.setFirstName(student.getFirstName());
        std.setLastName(student.getFirstName());
        std.setDepartment(departmentRepository.findByName(student.getDepartmentName()));
        studentRepository.save(std);
        System.out.println("saved");
        return ResponseEntity.ok(std);
        
    }
    @GetMapping("/students")
    public List<Student> getStudentList(){
       return studentRepository.findAll();
    }
    
}
