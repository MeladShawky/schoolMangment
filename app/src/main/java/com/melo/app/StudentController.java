package com.melo.app;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class StudentController {
 
    private final StudentRepository studentRepository;  
    

    public StudentController(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }
    ////////////////////////////////////////////////////////////
    @PostMapping("/students")
    public Student post(
       @RequestBody Student student
    ){
        System.out.println("post is caling..................");
        return studentRepository.save(student);
    }
    ////////////////////////////////////////////////////////
    @GetMapping("/students")
    public List<Student> findAllStudents() {
        return studentRepository.findAll();
    }
    ///////////////////////////////////////////////////////////////
    @GetMapping("/student/{s_id}")
    public Student findAllById(
        @PathVariable("s_id") Integer id
    ) {
        return studentRepository.findById(id).orElse(new Student());
    }
    ////////////////////////////////////////////////////////////////
    @GetMapping("/student/search/{A}")
    public List<Student> findByName(
        @PathVariable("A") String name
    ) {
        return studentRepository.findAllByFirstNameContaining(name);
    }
    //////////////////////////////////////////////////////////////   
    @DeleteMapping("/del/{d}")
    public void del(
        @PathVariable("d") Student d
    ){
        studentRepository.delete(d);
    }
}