package com.algaworks.algalog.domain.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Delivery {

    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Client client;

    @Embedded
    private Receiver receiver;

    private BigDecimal tax;

    @OneToMany(mappedBy = "delivery", cascade = CascadeType.ALL)
    private List<Incident> incidents = new ArrayList<>();

    @Enumerated(EnumType.STRING)
    private StatusDelivery status;

    private OffsetDateTime dateRequest;

    private OffsetDateTime dateFinish;

    public Incident addIncident(String description) {
        Incident incident = new Incident();
        incident.setDescription(description);
        incident.setDateRegister(OffsetDateTime.now());
        incident.setDelivery(this);

        this.getIncidents().add(incident);

        return incident;
    }
}
