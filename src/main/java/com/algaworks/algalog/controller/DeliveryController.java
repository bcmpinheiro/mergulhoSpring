package com.algaworks.algalog.controller;

import com.algaworks.algalog.domain.model.Delivery;
import com.algaworks.algalog.domain.service.DeliveryServiceRequest;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("/delivers")
public class DeliveryController {

    private DeliveryServiceRequest deliveryServiceRequest;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Delivery request(@RequestBody Delivery delivery) {
        return deliveryServiceRequest.request(delivery);
    }
}
