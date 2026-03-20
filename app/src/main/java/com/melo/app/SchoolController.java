package com.melo.app;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
public class SchoolController {
    
    private final SchoolRepository schoolRepository;


    public SchoolController(SchoolRepository schoolRepository) {
        this.schoolRepository = schoolRepository;
    }


    @PostMapping("/schools")
    public school create
    (
        @RequestBody school school
    ) 
    {
        return schoolRepository.save(school);
    }

    @GetMapping("/schools")
    public List<school> findAll() 
    {
        return schoolRepository.findAll();
    }
    
}
