package com.epam.spring.homework3.springselectioncommittee.service;

import com.epam.spring.homework3.springselectioncommittee.dto.EntrantDto;

import java.util.List;

public interface EntrantService {
    EntrantDto createEntrant(EntrantDto entrantDto);

    EntrantDto findById(int id);

    List<EntrantDto> findAll();

    EntrantDto updateEntrant(int id, EntrantDto entrantDto);

    void deleteEntrant(int id);
}
