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
    public StudentResponseDto post(
       @RequestBody StudentDto studentDto
    ){
        var student=toStudent(studentDto);
        var savedStudent= studentRepository.save(student);
        return toStudentResponseDto(savedStudent);
    }

    private Student toStudent(StudentDto dto){
        var student=new Student();
        var school=new school();
        student.setFirstName(dto.firstName());
        student.setLastName(dto.lastName());
        student.setEmail(dto.email());
        school.setId(dto.schoolId());
        student.setSchool(school);
        return student;
    }

    private StudentResponseDto toStudentResponseDto(Student student){
       return new StudentResponseDto(
         student.getFirstName(),
        student.getLastName(),
        student.getEmail()
       );
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