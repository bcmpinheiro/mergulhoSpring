package com.algaworks.algalog.domain.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Getter
@Setter
@Embeddable
public class Receiver {

    @Column(name = "receiver_name")
    public String name;

    @Column(name = "receiver_adress")
    public String adress;

    @Column(name = "receiver_number")
    public String number;

    @Column(name = "receiver_complement")
    public String complement;

    @Column(name = "receiver_district")
    public String district;
}
