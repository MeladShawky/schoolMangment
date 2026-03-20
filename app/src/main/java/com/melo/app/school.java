package com.melo.app;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class school {
    
    @Id
    @GeneratedValue
    private Integer id;
    private String name;

    @OneToMany(
        mappedBy = "school"
    )
    private List<Student> students;



    public List<Student> getStudents() {
        return this.students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }
    

    public school() {
    }


    public school( String name) {
        this.name = name;
    }


    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
