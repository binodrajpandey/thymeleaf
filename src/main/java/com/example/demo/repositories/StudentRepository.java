
package com.example.demo.repositories;

import com.example.demo.entities.Student;
import java.io.Serializable;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author binod
 */
public interface StudentRepository extends JpaRepository<Student, Long>{
    
}
