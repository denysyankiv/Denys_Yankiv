package com.epam.spring.homework3.springselectioncommittee.service;

import com.epam.spring.homework3.springselectioncommittee.dto.FacultyDto;

import java.util.List;

import org.springframework.stereotype.Service;


@Service
public interface FacultyService {

    FacultyDto createFaculty(FacultyDto facultyDto);

    FacultyDto findById(int id);

    List<FacultyDto> findAll();

    FacultyDto updateFaculty(int id, FacultyDto facultyDto);

    void deleteFaculty(int id);

}
