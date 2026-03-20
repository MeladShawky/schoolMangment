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

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    ////////////////////////////////////////////////////////////
    @PostMapping("/students")
    public StudentResponseDto saveStudent(
       @RequestBody StudentDto studentDto
    ){
        return this.studentService.saveStudent(studentDto);
    }


    ////////////////////////////////////////////////////////
    @GetMapping("/students")
    public List<StudentResponseDto> findAllStudents() {
        return this.studentService.findAllStudents();
    }
    ///////////////////////////////////////////////////////////////
    @GetMapping("/student/{s_id}")
    public StudentResponseDto findAllById(
        @PathVariable("s_id") Integer id
    ) {
        return studentService.findAllById(id);
    }
    ////////////////////////////////////////////////////////////////
    @GetMapping("/student/search/{A}")
    public List<StudentResponseDto> findByName(
        @PathVariable("A") String name
    ) {
        return studentService.findByName(name);
    }
    //////////////////////////////////////////////////////////////   
    @DeleteMapping("/del/{d}")
    public void del(
        @PathVariable("d") Student d
    ){
        studentService.del(d);
    }
}