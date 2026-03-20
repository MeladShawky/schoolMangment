package com.melo.app.student;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;


@Service
public class StudentService {
    private final StudentRepository studentRepository;  
    private final StudentMapper studentMapper;

    public StudentService(StudentRepository studentRepository, StudentMapper studentMapper) {
        this.studentRepository = studentRepository;
        this.studentMapper = studentMapper;
    }

    ////////////////////////////////////////////
    public StudentResponseDto saveStudent(
        StudentDto studentDto
    ){
        var student=studentMapper.toStudent(studentDto);
        var savedStudent= studentRepository.save(student);
        return studentMapper.toStudentResponseDto(savedStudent);
    }

    /////////////////////////////////////////////
    public List<StudentResponseDto> findAllStudents(){
        return studentRepository.findAll()
        .stream()
        .map(studentMapper::toStudentResponseDto)
        .collect(Collectors.toList());
    }

    //////////////////////////////////////////////
     public StudentResponseDto findAllById(Integer id){
       return studentRepository.findById(id).map(studentMapper::toStudentResponseDto).orElse(null);
     }

     //////////////////////////////////////////////
     public List<StudentResponseDto> findByName( String name) {
        return studentRepository.findAllByFirstNameContaining(name)
        .stream()
        .map(studentMapper::toStudentResponseDto)
        .collect(Collectors.toList());
    }

    /////////////////////////////////////////////////////////////
    public void del( Student d){
        studentRepository.delete(d);
    }
}
