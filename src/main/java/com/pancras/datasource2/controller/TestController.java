package com.pancras.datasource2.controller;

import com.pancras.datasource2.domain.customer.Person;
import com.pancras.datasource2.domain.employee.Student;
import com.pancras.datasource2.repository.jpa.customer.PersonRepository;
import com.pancras.datasource2.repository.jpa.employee.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: captain
 * @Date: 2019/7/17 0:25
 */
@RequestMapping("/test")
@RestController
public class TestController {

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private StudentRepository studentRepository;

    @GetMapping("/ddd")
    public String test(){
        Person person =personRepository.findById("402881956b6e8e9e016b6e96aa060001").get();
        System.out.println(person.getAbbreviation());

        Student student = studentRepository.findById(1L).get();
        System.out.println(student.getContent());
        return "SUCCESS";
    }
}
