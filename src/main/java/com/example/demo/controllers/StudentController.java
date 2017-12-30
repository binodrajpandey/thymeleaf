
package com.example.demo.controllers;

import com.example.demo.dtos.StudentDTO;
import com.example.demo.entities.Department;
import com.example.demo.entities.Student;
import com.example.demo.repositories.DepartmentRepository;
import com.example.demo.repositories.StudentRepository;
import com.example.demo.services.StudentService;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpHeaders;
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
    @Autowired
    private StudentService studentService;

    @PostMapping("/students")
    public ResponseEntity<?> saveStudent(@RequestBody StudentDTO dto) {
        System.out.println("depatrtmen"+dto.getDepartmentName());
        Student student = new Student();
        student.setFirstName(dto.getFirstName());
        student.setLastName(dto.getLastName());
        student.setAddress(dto.getAddress());

        Department department = departmentRepository.findByDepartmentName(dto.getDepartmentName());
        student.setDepartment(department);
        System.out.println("fafda"+student.getDepartment().getDepartmentId());
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
   
   @DeleteMapping("/students")
   public ResponseEntity<?> deleteStudent(@RequestParam Long studentId ){
       studentRepository.delete(studentId);
       return ResponseEntity.ok("Deleted");
   }
   @GetMapping(value = "/students/export")
   public ResponseEntity<?> exportCsv() throws UnsupportedEncodingException{
       String csv=studentService.getCsv();
       String fileName="studentExport.csv";
        byte[] byteArray = csv.getBytes(StandardCharsets.UTF_8.name());
       ByteArrayResource resource=new ByteArrayResource(byteArray);
       return ResponseEntity
               .ok()
               .header(HttpHeaders.CONTENT_DISPOSITION, "attachment;filename="+fileName)
                .header(HttpHeaders.CONTENT_TYPE, "text/csv;charset=utf-8")
                .contentLength(byteArray.length)
               .body(resource);
   }
   
}
