package com.epam.spring.homework3.springselectioncommittee.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class EntrantDto {
  @JsonProperty(access = Access.READ_ONLY)
  private int id;
  private String fullName;
  private String email;
  private String city;
  private String region;
  private String schoolName;
  private String state;
}
