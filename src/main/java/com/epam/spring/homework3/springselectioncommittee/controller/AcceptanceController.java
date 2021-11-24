package com.epam.spring.homework3.springselectioncommittee.controller;

import com.epam.spring.homework3.springselectioncommittee.dto.AcceptanceDto;
import com.epam.spring.homework3.springselectioncommittee.model.Acceptance;
import com.epam.spring.homework3.springselectioncommittee.service.AcceptanceService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
public class AcceptanceController {
    private final AcceptanceService acceptanceService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/acceptance")
    public AcceptanceDto createAcceptance(@RequestBody AcceptanceDto acceptanceDto) {
        return acceptanceService.createAcceptance(acceptanceDto);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/acceptance/{acceptanceId}")
    public AcceptanceDto findById(@PathVariable int acceptanceId) {
        return acceptanceService.findById(acceptanceId);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/acceptance/{entrantId}")
    public List<AcceptanceDto> findAllByEntrantId(@PathVariable int entrantId) {
        return acceptanceService.findAllByEntrantId(entrantId);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/acceptance/{facultyId}")
    public List<AcceptanceDto> findAllByFacultyId(@PathVariable int facultyId) {
        return acceptanceService.findAllByFacultyId(facultyId);
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/acceptance/{acceptanceId}")
    public AcceptanceDto updateAcceptance(@PathVariable int acceptanceId, @RequestBody AcceptanceDto acceptanceDto){
        return acceptanceService.updateAcceptance(acceptanceId,acceptanceDto);
    }

    @DeleteMapping("/acceptance/{acceptanceId}")
    public ResponseEntity<Void> deleteById(@PathVariable int acceptanceId){
        acceptanceService.delete(acceptanceId);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/acceptance/{entrantId}")
    public ResponseEntity<Void> deleteByEntrantId(@PathVariable int entrantId){
        acceptanceService.deleteByEntrantId(entrantId);
        return ResponseEntity.noContent().build();
    }

}
