package com.epam.spring.homework3.springselectioncommittee.controller;

import com.epam.spring.homework3.springselectioncommittee.dto.FacultyDto;
import com.epam.spring.homework3.springselectioncommittee.service.FacultyService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class FacultyController {

  private final FacultyService facultyService;

  @ResponseStatus(HttpStatus.OK)
  @GetMapping(value = "/faculty")
  public List<FacultyDto> getAllFaculties() {
    return facultyService.findAll();
  }

  @ResponseStatus(HttpStatus.OK)
  @GetMapping(value = "/faculty/{id}")
  public FacultyDto getFaculty(@PathVariable String id) {
    return facultyService.findById(Integer.parseInt(id));
  }

  @ResponseStatus(HttpStatus.CREATED)
  @PostMapping(value = "/faculty")
  public FacultyDto createFaculty(@RequestBody FacultyDto facultyDto) {
    return facultyService.createFaculty(facultyDto);
  }

  @ResponseStatus(HttpStatus.OK)
  @PutMapping(value = "/faculty/{id}")
  public FacultyDto updateFaculty(@PathVariable int id, @RequestBody FacultyDto facultyDto) {
    return facultyService.updateFaculty(id,facultyDto);
  }

  @ResponseStatus(HttpStatus.CREATED)
  @DeleteMapping(value = "/faculty/{id}")
  public ResponseEntity<Void> deleteFaculty(@PathVariable int id) {
    facultyService.deleteFaculty(id);
    return ResponseEntity.noContent().build();
  }
}
