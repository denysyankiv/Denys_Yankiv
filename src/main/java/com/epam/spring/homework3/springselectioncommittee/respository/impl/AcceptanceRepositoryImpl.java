package com.epam.spring.homework3.springselectioncommittee.respository.impl;

import com.epam.spring.homework3.springselectioncommittee.model.Acceptance;
import com.epam.spring.homework3.springselectioncommittee.respository.AcceptanceRepository;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class AcceptanceRepositoryImpl implements AcceptanceRepository {
    private final List<Acceptance> list = new ArrayList<>();

    @Override
    public Acceptance createAcceptance(Acceptance acceptance) {
        list.add(acceptance);
        return acceptance;
    }

    @Override
    public Acceptance findById(int acceptanceId) {
        return list.stream().filter(a -> a.getId() == acceptanceId).findFirst()
                .orElseThrow(() -> new RuntimeException("Acceptance record not found!"));
    }

    @Override
    public List<Acceptance> findAllByEntrantId(int entrantId) {
        return list.stream().filter(a -> a.getEntrantId() == entrantId).collect(Collectors.toList());
    }

    @Override
    public List<Acceptance> findAllByFacultyId(int facultyId) {
        return list.stream().filter(a -> a.getFacultyId() == facultyId).collect(Collectors.toList());
    }

    @Override
    public Acceptance updateAcceptance(int id, Acceptance acceptance) {
        boolean isDeleted = list.removeIf(acceptance1 -> acceptance.getId() == id);
        if (!isDeleted) {
            throw new RuntimeException("Acceptance record not found!");
        }
        acceptance.setId(id);
        list.add(acceptance);
        return acceptance;
    }

    @Override
    public void delete(int id) {
        list.removeIf(a -> a.getId() == id);
    }

    @Override
    public void deleteByEntrantId(int entrantId) {
        list.removeIf(a -> a.getEntrantId() == entrantId);
    }
}
