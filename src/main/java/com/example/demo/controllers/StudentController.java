
package com.example.demo.controllers;

import com.example.demo.entities.Student;
import com.example.demo.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
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
    @PostMapping("/student")
    public void saveStudent(@RequestBody Student student){
        studentRepository.save(student);
        
    }
    
}
