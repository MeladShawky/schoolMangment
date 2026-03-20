package com.melo.app;

public class SchoolMapper {
        public school toSchool(SchoolDto sDto){
        return new school(sDto.name());
    }

    public SchoolDto toSchoolDto(school school){
        return new SchoolDto(school.getName());
    }
}
