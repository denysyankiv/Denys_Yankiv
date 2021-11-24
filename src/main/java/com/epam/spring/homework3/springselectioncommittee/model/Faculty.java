package com.epam.spring.homework3.springselectioncommittee.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Faculty {
  private int id;
  private String name;
  private String description;
  private int finByGovNumOfStudents;
  private int commercialStudents;

}
