package com.algaworks.algalog.controller;

import com.algaworks.algalog.assembler.IncidentAssembler;
import com.algaworks.algalog.domain.model.Delivery;
import com.algaworks.algalog.domain.model.Incident;
import com.algaworks.algalog.domain.service.RegisterIncidentService;
import com.algaworks.algalog.domain.service.SearchDeliveryService;
import com.algaworks.algalog.model.IncidentModel;
import com.algaworks.algalog.model.input.IncidentInput;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/delivers/{deliveryId}/incidents")
public class IncidentController {

    private SearchDeliveryService searchDeliveryService;
    private RegisterIncidentService registerIncidentService;
    private IncidentAssembler incidentAssembler;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public IncidentModel register (@PathVariable Long deliveryId, @Valid @RequestBody IncidentInput incidentInput) {

        Incident incidentRegistred = registerIncidentService
                .register(deliveryId, incidentInput.getDescription());

        return incidentAssembler.toModel(incidentRegistred);
    }

    @GetMapping
    public List<IncidentModel> list(@PathVariable Long deliveryId) {
        Delivery delivery = searchDeliveryService.search(deliveryId);

        return incidentAssembler.toCollectionModel(delivery.getIncidents());
    }
}
