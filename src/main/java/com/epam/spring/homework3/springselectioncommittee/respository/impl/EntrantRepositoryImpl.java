package com.epam.spring.homework3.springselectioncommittee.respository.impl;

import com.epam.spring.homework3.springselectioncommittee.model.Entrant;
import com.epam.spring.homework3.springselectioncommittee.respository.EntrantRepository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class EntrantRepositoryImpl implements EntrantRepository {

    private final List<Entrant> list = new ArrayList<>();

    @Override
    public Entrant createEntrant(Entrant entrant) {
        list.add(entrant);
        return entrant;
    }

    @Override
    public Entrant findById(int id) {
        return list.stream().filter(entrant -> entrant.getId() == id).findFirst()
                .orElseThrow(() -> new RuntimeException("Entrant not found!"));
    }

    @Override
    public List<Entrant> findAll() {
        return list;
    }

    @Override
    public Entrant updateEntrant(int id, Entrant entrant) {
        boolean isDeleted = list.removeIf(e -> e.getId() == id);
        if (!isDeleted) {
            throw new RuntimeException("Entrant not found!");
        }
        entrant.setId(id);
        list.add(entrant);
        return entrant;
    }

    @Override
    public void deleteEntrant(int id) {
        list.removeIf(entrant -> entrant.getId() == id);
    }
}
