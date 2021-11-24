package com.epam.spring.homework3.springselectioncommittee.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Acceptance {
    private int id;
    private int entrantId;
    private int facultyId;
}
