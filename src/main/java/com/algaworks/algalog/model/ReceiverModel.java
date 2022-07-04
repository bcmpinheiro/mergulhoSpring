package com.algaworks.algalog.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ReceiverModel {

    private String name;
    private ClientResumeModel client;
    private String adress;
    private String number;
    private String complement;
    private String district;
}
