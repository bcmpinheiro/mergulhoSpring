package com.algaworks.algalog.model.input;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class ReceiverInput {

    @NotBlank
    public String name;

    @NotBlank
    public String adress;

    @NotBlank
    public String number;

    @NotBlank
    public String complement;

    @NotBlank
    public String district;

}
