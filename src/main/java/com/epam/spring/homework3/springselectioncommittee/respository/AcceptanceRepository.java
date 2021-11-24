package com.epam.spring.homework3.springselectioncommittee.respository;

import com.epam.spring.homework3.springselectioncommittee.model.Acceptance;

import java.util.List;

public interface AcceptanceRepository {
    Acceptance createAcceptance(Acceptance acceptance);

    Acceptance findById(int acceptanceId);

    List<Acceptance> findAllByEntrantId(int entrantId);

    List<Acceptance> findAllByFacultyId(int facultyId);

    Acceptance updateAcceptance(int id, Acceptance acceptance);


    void delete(int id);

    void deleteByEntrantId(int entrantId);
}
