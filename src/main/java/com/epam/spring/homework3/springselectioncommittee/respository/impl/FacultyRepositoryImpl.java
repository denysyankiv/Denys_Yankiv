package com.epam.spring.homework3.springselectioncommittee.respository.impl;

import com.epam.spring.homework3.springselectioncommittee.model.Faculty;
import com.epam.spring.homework3.springselectioncommittee.respository.FacultyRepository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class FacultyRepositoryImpl implements FacultyRepository {

    private final List<Faculty> list = new ArrayList<>();

    @Override
    public Faculty createFaculty(Faculty faculty) {
        list.add(faculty);
        return faculty;
    }

    @Override
    public Faculty findById(int id) {
        return list.stream().filter(faculty -> faculty.getId() == id).findFirst()
                .orElseThrow(() -> new RuntimeException("Faculty not found!"));
    }

    @Override
    public List<Faculty> findAll() {
        return list;
    }

    @Override
    public Faculty updateFaculty(int id, Faculty faculty) {
        boolean isDeleted = list.removeIf(f -> f.getId() == id);
        if (!isDeleted) {
            throw new RuntimeException("Faculty not found!");
        }

        faculty.setId(id);
        list.add(faculty);
        return faculty;
    }

    @Override
    public void deleteFaculty(int id) {
        list.removeIf(f -> f.getId() == id);
    }
}
