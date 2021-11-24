package com.epam.spring.homework3.springselectioncommittee.service;

import com.epam.spring.homework3.springselectioncommittee.dto.AcceptanceDto;
import com.epam.spring.homework3.springselectioncommittee.model.Acceptance;

import java.util.List;

public interface AcceptanceService {
    AcceptanceDto createAcceptance(AcceptanceDto acceptanceDto);

    AcceptanceDto findById(int acceptanceId);

    List<AcceptanceDto> findAllByEntrantId(int entrantId);

    List<AcceptanceDto> findAllByFacultyId(int facultyId);

    AcceptanceDto updateAcceptance(int id, AcceptanceDto acceptanceDto);


    void delete(int id);

    void deleteByEntrantId(int entrantId);
}
