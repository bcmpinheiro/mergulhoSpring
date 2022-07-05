package com.algaworks.algalog.controller;

import com.algaworks.algalog.assembler.DeliveryAssembler;
import com.algaworks.algalog.domain.model.Delivery;
import com.algaworks.algalog.domain.repository.DeliveryRepository;
import com.algaworks.algalog.domain.service.DeliveryServiceRequest;
import com.algaworks.algalog.domain.service.FinishDeliveryService;
import com.algaworks.algalog.model.DeliveryModel;
import com.algaworks.algalog.model.input.DeliveryInput;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/delivers")
public class DeliveryController {

    private DeliveryRepository deliveryRepository;
    private DeliveryServiceRequest deliveryServiceRequest;
    private DeliveryAssembler deliveryAssembler;
    private FinishDeliveryService finishDeliveryService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public DeliveryModel request(@Valid @RequestBody DeliveryInput deliveryInput) {
        Delivery newDelivery = deliveryAssembler.toEntity(deliveryInput);
        Delivery deliveryRequest = deliveryServiceRequest.request(newDelivery);

        return deliveryAssembler.toModel(deliveryRequest);
    }
    @GetMapping
    public List<DeliveryModel> list() {
        return deliveryAssembler.toCollectionModel(deliveryRepository.findAll());
    }

    @GetMapping("/{deliveryId}")
    public ResponseEntity<DeliveryModel> search(@PathVariable Long deliveryId) {
        return deliveryRepository.findById(deliveryId)
                .map(delivery -> ResponseEntity.ok(deliveryAssembler.toModel(delivery)))
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{deliveryId}/finish")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void finish(@PathVariable Long deliveryId) {
        finishDeliveryService.finished(deliveryId);
    }
}

