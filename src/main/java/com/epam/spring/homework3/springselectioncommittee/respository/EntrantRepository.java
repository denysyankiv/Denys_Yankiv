package com.epam.spring.homework3.springselectioncommittee.respository;

import com.epam.spring.homework3.springselectioncommittee.model.Entrant;
import java.util.List;

public interface EntrantRepository {
  Entrant createEntrant(Entrant entrant);

  Entrant findById(int id);

  List<Entrant> findAll();

  Entrant updateEntrant(int id,Entrant entrant);

  void deleteEntrant(int id);
}
