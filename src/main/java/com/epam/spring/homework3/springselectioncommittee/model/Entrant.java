package com.epam.spring.homework3.springselectioncommittee.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Entrant {
  private int id;
  private String fullName;
  private String email;
  private String city;
  private String region;
  private String schoolName;
  private String state;
}