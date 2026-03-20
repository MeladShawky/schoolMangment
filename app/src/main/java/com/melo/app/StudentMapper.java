package com.melo.app;

import org.springframework.stereotype.Service;

@Service
public class StudentMapper {
    public Student toStudent(StudentDto dto){
        var student=new Student();
        var school=new school();
        student.setFirstName(dto.firstName());
        student.setLastName(dto.lastName());
        student.setEmail(dto.email());
        school.setId(dto.schoolId());
        student.setSchool(school);
        return student;
    }

    public StudentResponseDto toStudentResponseDto(Student student){
       return new StudentResponseDto(
         student.getFirstName(),
        student.getLastName(),
        student.getEmail()
       );
    }
}
