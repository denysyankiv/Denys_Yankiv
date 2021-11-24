package com.epam.spring.homework3.springselectioncommittee.service.imp;

import com.epam.spring.homework3.springselectioncommittee.dto.EntrantDto;
import com.epam.spring.homework3.springselectioncommittee.model.Entrant;
import com.epam.spring.homework3.springselectioncommittee.respository.EntrantRepository;
import com.epam.spring.homework3.springselectioncommittee.service.EntrantService;

import java.util.List;
import java.util.stream.Collectors;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class EntrantServiceImpl implements EntrantService {

    private final EntrantRepository entrantRepository;

    @Override
    public EntrantDto createEntrant(EntrantDto entrantDto) {
        log.info("createEntrant with id {}", entrantDto.getId());
        Entrant entrant = mapDtoToEntrant(entrantDto);
        return mapEntrantToDto(entrantRepository.createEntrant(entrant));
    }

    @Override
    public EntrantDto findById(int id) {
        log.info("find by id {}", id);
        return mapEntrantToDto(entrantRepository.findById(id));
    }

    @Override
    public List<EntrantDto> findAll() {
        log.info("find all");
        return entrantRepository
                .findAll()
                .stream()
                .map(this::mapEntrantToDto)
                .collect(Collectors.toList());
    }

    @Override
    public EntrantDto updateEntrant(int id, EntrantDto entrantDto) {
        log.info("update user with id {}", id);
        Entrant entrant = mapDtoToEntrant(entrantDto);
        entrant = entrantRepository.updateEntrant(id, entrant);
        return mapEntrantToDto(entrant);
    }

    @Override
    public void deleteEntrant(int id) {
        log.info("delete entrant with id {}", id);
        entrantRepository.deleteEntrant(id);
    }

    private EntrantDto mapEntrantToDto(Entrant entrant) {
        return EntrantDto.builder()
                .id(entrant.getId())
                .fullName(entrant.getFullName())
                .email(entrant.getEmail())
                .city(entrant.getCity())
                .region(entrant.getRegion())
                .schoolName(entrant.getSchoolName())
                .state(entrant.getState())
                .build();
    }

    private Entrant mapDtoToEntrant(EntrantDto entrantDto) {
        return Entrant.builder()
                .id(entrantDto.getId())
                .fullName(entrantDto.getFullName())
                .email(entrantDto.getEmail())
                .city(entrantDto.getCity())
                .region(entrantDto.getRegion())
                .schoolName(entrantDto.getSchoolName())
                .state(entrantDto.getState())
                .build();
    }
}
