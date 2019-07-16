package com.pancras.datasource2.repository.jpa.employee;


import com.pancras.datasource2.domain.employee.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
}
