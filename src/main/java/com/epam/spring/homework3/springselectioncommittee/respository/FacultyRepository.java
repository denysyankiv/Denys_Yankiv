package com.epam.spring.homework3.springselectioncommittee.respository;

import com.epam.spring.homework3.springselectioncommittee.model.Entrant;
import com.epam.spring.homework3.springselectioncommittee.model.Faculty;
import java.util.List;

public interface FacultyRepository {
  Faculty createFaculty(Faculty faculty);

  Faculty findById(int id);

  List<Faculty> findAll();

  Faculty updateFaculty(int id,Faculty faculty);

  void deleteFaculty(int id);
}
