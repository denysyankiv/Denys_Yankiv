package com.epam.spring.homework3.springselectioncommittee.service.imp;

import com.epam.spring.homework3.springselectioncommittee.dto.FacultyDto;
import com.epam.spring.homework3.springselectioncommittee.model.Faculty;
import com.epam.spring.homework3.springselectioncommittee.respository.FacultyRepository;
import com.epam.spring.homework3.springselectioncommittee.service.FacultyService;

import java.util.List;
import java.util.stream.Collectors;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class FacultyServiceImpl implements FacultyService {

    private final FacultyRepository facultyRepository;

    @Override
    public FacultyDto createFaculty(FacultyDto facultyDto) {
        log.info("createFaculty with id {}", facultyDto.getId());
        Faculty faculty = mapDtoToFaculty(facultyDto);
        return mapFacultyToDto(facultyRepository.createFaculty(faculty));
    }

    @Override
    public FacultyDto findById(int id) {
        log.info("find by id {}", id);
        return mapFacultyToDto(facultyRepository.findById(id));
    }

    @Override
    public List<FacultyDto> findAll() {
        log.info("find all");
        return facultyRepository
                .findAll()
                .stream()
                .map(this::mapFacultyToDto)
                .collect(Collectors.toList());
    }

    @Override
    public FacultyDto updateFaculty(int id,FacultyDto facultyDto) {
        log.info("update faculty with id {}", id);
        Faculty faculty = mapDtoToFaculty(facultyDto);
        return mapFacultyToDto(facultyRepository.updateFaculty(id,faculty));
    }

    @Override
    public void deleteFaculty(int id) {
        log.info("delete faculty with id {}", id);
        facultyRepository.deleteFaculty(id);
    }

    private FacultyDto mapFacultyToDto(Faculty faculty) {
        return FacultyDto.builder()
                .id(faculty.getId())
                .finByGovNumOfStudents(faculty.getFinByGovNumOfStudents())
                .commercialStudents(faculty.getCommercialStudents())
                .name(faculty.getName())
                .description(faculty.getDescription())
                .build();
    }

    private Faculty mapDtoToFaculty(FacultyDto facultyDto) {
        return Faculty.builder()
                .id(facultyDto.getId())
                .finByGovNumOfStudents(facultyDto.getFinByGovNumOfStudents())
                .commercialStudents(facultyDto.getCommercialStudents())
                .name(facultyDto.getName())
                .description(facultyDto.getDescription())
                .build();
    }
}
