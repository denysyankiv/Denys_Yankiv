package com.epam.spring.homework3.springselectioncommittee.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class FacultyDto {
  private int id;
  private int finByGovNumOfStudents;
  private int commercialStudents;
  private String name;
  private String description;
}
