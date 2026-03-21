package com.melo.app.student;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class StudentMapperTest {
    private StudentMapper studentMapper;

    @BeforeEach
    public void setUp() {
        studentMapper = new StudentMapper();
    } 

    @Test
    public void shouldMapStudentToStudentDTO() {
        StudentDto studentDto = new StudentDto("John", "Doe","john.doe@example.com",1);

        Student student = studentMapper.toStudent(studentDto);         
        assertEquals(studentDto.firstName(), student.getFirstName());
        assertEquals(studentDto.lastName(), student.getLastName());
        assertEquals(studentDto.email(), student.getEmail());
        assertEquals(studentDto.schoolId(), student.getSchool().getId());
        assertNotNull(student.getSchool());

    } 

    @Test
    public void shouldMapStudentDTOToStudent() {
        Student student = new Student();
        student.setFirstName("Jane");
        student.setLastName("Smith");
        student.setEmail("jane.smith@example.com");
        StudentResponseDto studentDto = studentMapper.toStudentResponseDto(student);
        assertEquals(student.getFirstName(), studentDto.firstName());
        assertEquals(student.getLastName(), studentDto.lastName());
        assertEquals(student.getEmail(), studentDto.email());

    }
}
