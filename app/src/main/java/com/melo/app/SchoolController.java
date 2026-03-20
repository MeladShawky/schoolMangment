package com.melo.app;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
public class SchoolController {
    
    private final AppApplication appApplication;
    private final SchoolRepository schoolRepository;


    public SchoolController(SchoolRepository schoolRepository, AppApplication appApplication) {
        this.schoolRepository = schoolRepository;
        this.appApplication = appApplication;
    }


    @PostMapping("/schools")
    public SchoolDto create
    (
        @RequestBody SchoolDto dto
    ) 
    {
        var school=toSchool(dto);
        var savedSchool=schoolRepository.save(school);
        return dto;
    }

    private school toSchool(SchoolDto sDto){
        return new school(sDto.name());
    }

    private SchoolDto toSchoolDto(school school){
        return new SchoolDto(school.getName());
    }

    @GetMapping("/schools")
    public List<SchoolDto> findAll() 
    {
        return schoolRepository.findAll()
        .stream()
        .map(this::toSchoolDto)
        .collect(Collectors.toList())
        ;
    }
    
}
