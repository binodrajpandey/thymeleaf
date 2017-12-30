/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.services;

import com.example.demo.entities.Student;
import com.example.demo.repositories.StudentRepository;
import java.util.List;
import java.util.StringJoiner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author binod
 */
@Service
public class StudentServiceImpl implements StudentService{
@Autowired
private StudentRepository studentRepository;
    @Override
    public String getCsv() {
        List<Student> studentList=studentRepository.findAll();
        StringBuilder builder=new StringBuilder();
        for(Student student:studentList){
            StringJoiner joiner=new StringJoiner(",");
            joiner.add(student.getFirstName());
            joiner.add(student.getLastName());
            joiner.add(student.getAddress());
            try{
                joiner.add(student.getDepartment().getDepartmentName());
            }catch(NullPointerException ex){
                joiner.add("");
            }
            
            builder.append(joiner.toString());
            builder.append("\n");
        }
        return builder.toString();
    }
    
}
