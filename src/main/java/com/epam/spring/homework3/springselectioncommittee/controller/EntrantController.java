package com.epam.spring.homework3.springselectioncommittee.controller;

import com.epam.spring.homework3.springselectioncommittee.dto.EntrantDto;
import com.epam.spring.homework3.springselectioncommittee.service.EntrantService;

import java.util.List;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
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

@Slf4j
@RestController
@RequiredArgsConstructor
public class EntrantController {

  private final EntrantService entrantService;
  @ResponseStatus(HttpStatus.OK)
  @GetMapping(value = "/entrant")
  public List<EntrantDto> getAllEntrants() {
    return entrantService.findAll();
  }

  @ResponseStatus(HttpStatus.OK)
  @GetMapping(value = "/entrant/{id}")
  public EntrantDto getEntrant(@PathVariable int id) {
    return entrantService.findById(id);
  }

  @ResponseStatus(HttpStatus.CREATED)
  @PostMapping(value = "/entrant")
  public EntrantDto createEntrant(@RequestBody EntrantDto entrantDto) {
    return entrantService.createEntrant(entrantDto);
  }

  @ResponseStatus(HttpStatus.OK)
  @PutMapping(value = "/entrant/{id}")
  public EntrantDto updateEntrant(@PathVariable int id,@RequestBody EntrantDto entrantDto) {
    return entrantService.updateEntrant(id,entrantDto);
  }

  @DeleteMapping(value = "/entrant/{id}")
  public ResponseEntity<Void> deleteEntrant(@PathVariable int id) {
    entrantService.deleteEntrant(id);
    return ResponseEntity.noContent().build();
  }
}
