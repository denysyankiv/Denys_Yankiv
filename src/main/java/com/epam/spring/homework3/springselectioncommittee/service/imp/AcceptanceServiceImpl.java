package com.epam.spring.homework3.springselectioncommittee.service.imp;

import com.epam.spring.homework3.springselectioncommittee.dto.AcceptanceDto;
import com.epam.spring.homework3.springselectioncommittee.model.Acceptance;
import com.epam.spring.homework3.springselectioncommittee.respository.AcceptanceRepository;
import com.epam.spring.homework3.springselectioncommittee.service.AcceptanceService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class AcceptanceServiceImpl implements AcceptanceService {

    private final AcceptanceRepository acceptanceRepository;

    @Override
    public AcceptanceDto createAcceptance(AcceptanceDto acceptanceDto) {
        log.info("create acceptance record with id {}", acceptanceDto.getId());
        Acceptance acceptance = mapDtoToAcceptance(acceptanceDto);
        acceptance = acceptanceRepository.createAcceptance(acceptance);
        return mapAcceptanceToDto(acceptance);
    }

    @Override
    public AcceptanceDto findById(int acceptanceId) {
        log.info("find by acceptance id {}", acceptanceId);
        return mapAcceptanceToDto(acceptanceRepository.findById(acceptanceId));
    }

    @Override
    public List<AcceptanceDto> findAllByEntrantId(int entrantId) {
        log.info("find all by entrant id {}", entrantId);
        return acceptanceRepository
                .findAllByEntrantId(entrantId)
                .stream().map(this::mapAcceptanceToDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<AcceptanceDto> findAllByFacultyId(int facultyId) {
        log.info("find all by faculty id {}", facultyId);
        return acceptanceRepository
                .findAllByFacultyId(facultyId)
                .stream().map(this::mapAcceptanceToDto)
                .collect(Collectors.toList());
    }

    @Override
    public AcceptanceDto updateAcceptance(int id, AcceptanceDto acceptanceDto) {
        log.info("update acceptance record with id {}", id);
        Acceptance acceptance = mapDtoToAcceptance(acceptanceDto);
        return mapAcceptanceToDto(acceptanceRepository.updateAcceptance(id, acceptance));
    }

    @Override
    public void delete(int id) {
        log.info("delete acceptance record with id {}", id);
        acceptanceRepository.delete(id);
    }

    @Override
    public void deleteByEntrantId(int entrantId) {
        log.info("delete all acceptance records with entrant id {}", entrantId);
        acceptanceRepository.deleteByEntrantId(entrantId);
    }

    private Acceptance mapDtoToAcceptance(AcceptanceDto acceptanceDto) {
        return Acceptance.builder()
                .id(acceptanceDto.getId())
                .entrantId(acceptanceDto.getEntrantId())
                .facultyId(acceptanceDto.facultyId)
                .build();
    }

    private AcceptanceDto mapAcceptanceToDto(Acceptance acceptance) {
        return AcceptanceDto.builder()
                .id(acceptance.getId())
                .entrantId(acceptance.getEntrantId())
                .facultyId(acceptance.getFacultyId())
                .build();
    }

}
