package com.algaworks.algalog.model;

import com.algaworks.algalog.domain.model.StatusDelivery;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

@Getter
@Setter
public class DeliveryModel {

    private Long id;
    private String nameClient;
    private ReceiverModel receiver;
    private BigDecimal tax;
    private StatusDelivery status;
    private OffsetDateTime dateRequest;
    private OffsetDateTime dateFinish;
}
