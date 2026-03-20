package com.melo.app;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.RequestBody;

public class SchoolService {
    private final AppApplication appApplication;
    private final SchoolRepository schoolRepository;
    private final SchoolMapper schoolMapper;



    public SchoolService(AppApplication appApplication, SchoolRepository schoolRepository, SchoolMapper schoolMapper) {
        this.appApplication = appApplication;
        this.schoolRepository = schoolRepository;
        this.schoolMapper = schoolMapper;
    }
    
    /*/////////////////////////////////////////////////////// */

    public SchoolDto save( SchoolDto dto) 
    {
        var school=schoolMapper.toSchool(dto);
        var savedSchool=schoolRepository.save(school);
        return dto;
    }

    public List<SchoolDto> findAll() 
    {
        return schoolRepository.findAll()
        .stream()
        .map(schoolMapper::toSchoolDto)
        .collect(Collectors.toList())
        ;
    }


}
