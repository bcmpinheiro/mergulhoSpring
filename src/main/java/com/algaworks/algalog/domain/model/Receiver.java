package com.algaworks.algalog.domain.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotBlank;

@Getter
@Setter
@Embeddable
public class Receiver {

    @NotBlank
    @Column(name = "receiver_name")
    public String name;

    @NotBlank
    @Column(name = "receiver_adress")
    public String adress;

    @NotBlank
    @Column(name = "receiver_number")
    public String number;

    @NotBlank
    @Column(name = "receiver_complement")
    public String complement;

    @NotBlank
    @Column(name = "receiver_district")
    public String district;
}
