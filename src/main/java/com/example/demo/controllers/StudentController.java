
package com.example.demo.controllers;

import com.example.demo.dtos.StudentDTO;
import com.example.demo.entities.Department;
import com.example.demo.entities.Student;
import com.example.demo.entities.StudentResource;
import com.example.demo.repositories.DepartmentRepository;
import com.example.demo.repositories.StudentRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author binod
 */
@RestController
@Transactional
public class StudentController {
    
    @Autowired
    private DepartmentRepository departmentRepository;
    @Autowired
    private StudentRepository studentRepository;

    @PostMapping("/students")
    public ResponseEntity<?> saveStudent(@RequestBody StudentDTO dto) {

        Student student = new Student();
        student.setFirstName(dto.getFirstName());
        student.setLastName(dto.getLastName());
        student.setAddress(dto.getAddress());

        Department department = departmentRepository.findByDepartmentName(dto.getDepartmentName());
        student.setDepartment(department);
        studentRepository.save(student);
        return ResponseEntity.ok("new student saved");

    }

   @GetMapping("/students")
   public ResponseEntity<?> getAllStudents(){
       List<Student> studentList= studentRepository.findAll();
       return ResponseEntity.ok(studentList);
   }
   
   @PutMapping("/students")

   public ResponseEntity<?> deleteStudent(@RequestParam Long studentId,@RequestBody StudentDTO dto){
       Student oldStudent=studentRepository.findOne(studentId);
       oldStudent.setAddress(dto.getAddress());
       oldStudent.setFirstName(dto.getFirstName());
       oldStudent.setLastName(dto.getLastName());
      return ResponseEntity.ok("Updated");
   }
   
   @DeleteMapping("/departments")
   public ResponseEntity<?> deleteStudent(@RequestParam Long studentId ){
       studentRepository.delete(studentId);
       return ResponseEntity.ok("Deleted");
   }
   
}
