package com.epam.spring.homework3.springselectioncommittee.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AcceptanceDto {
  public int id;
  public int entrantId;
  public int facultyId;
}
