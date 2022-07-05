package com.algaworks.algalog.model;

import lombok.Getter;
import lombok.Setter;

import java.time.OffsetDateTime;

@Getter
@Setter
public class IncidentModel {

    private Long id;
    private String description;
    private OffsetDateTime dateRegister;
}
