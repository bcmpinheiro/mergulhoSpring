package com.algaworks.algalog.controller;

import com.algaworks.algalog.domain.model.Delivery;
import com.algaworks.algalog.domain.repository.DeliveryRepository;
import com.algaworks.algalog.domain.service.DeliveryServiceRequest;
import com.algaworks.algalog.model.DeliveryModel;
import com.algaworks.algalog.model.ReceiverModel;
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

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Delivery request(@Valid @RequestBody Delivery delivery) {
        return deliveryServiceRequest.request(delivery);
    }

    @GetMapping
    public List<Delivery> list() {
        return deliveryRepository.findAll();
    }

    @GetMapping("/{deliveryId}")
    public ResponseEntity<DeliveryModel> search(@PathVariable Long deliveryId) {
        return deliveryRepository.findById(deliveryId)
                .map(delivery -> {
                    DeliveryModel deliveryModel = new DeliveryModel();
                    deliveryModel.setId(delivery.getId());
                    deliveryModel.setNameClient(delivery.getClient().getName());
                    deliveryModel.setReceiver(new ReceiverModel());
                    deliveryModel.getReceiver().setName(delivery.getReceiver().getName());
                    deliveryModel.getReceiver().setAdress(delivery.getReceiver().getAdress());
                    deliveryModel.getReceiver().setNumber(delivery.getReceiver().getNumber());
                    deliveryModel.getReceiver().setComplement(delivery.getReceiver().getComplement());
                    deliveryModel.getReceiver().setDistrict(delivery.getReceiver().getDistrict());
                    deliveryModel.setTax(delivery.getTax());
                    deliveryModel.setStatus(delivery.getStatus());
                    deliveryModel.setDateRequest(delivery.getDateRequest());
                    deliveryModel.setDateFinish(delivery.getDateFinish());

                    return ResponseEntity.ok(deliveryModel);
                })
                .orElse(ResponseEntity.notFound().build());
    }
}

