package com.melo.app.school;

import org.springframework.stereotype.Service;

@Service
public class SchoolMapper {
        public school toSchool(SchoolDto sDto){
        return new school(sDto.name());
    }

    public SchoolDto toSchoolDto(school school){
        return new SchoolDto(school.getName());
    }
}
