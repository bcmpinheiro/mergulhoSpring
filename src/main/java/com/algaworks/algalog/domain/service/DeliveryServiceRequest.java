package com.algaworks.algalog.domain.service;

import com.algaworks.algalog.domain.exception.BusinessException;
import com.algaworks.algalog.domain.model.Client;
import com.algaworks.algalog.domain.model.Delivery;
import com.algaworks.algalog.domain.model.StatusDelivery;
import com.algaworks.algalog.domain.repository.ClientRepository;
import com.algaworks.algalog.domain.repository.DeliveryRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@AllArgsConstructor
@Service
public class DeliveryServiceRequest {

    private ClientRepository clientRepository;
    private DeliveryRepository deliveryRepository;

    @Transactional
    public Delivery request(Delivery delivery) {
        Client client = clientRepository.findById(delivery.getClient().getId())
                        .orElseThrow(() -> new BusinessException("Cliente não encontrado"));
        delivery.setClient(client);
        delivery.setStatus(StatusDelivery.PENDING);
        delivery.setDateRequest(LocalDateTime.now());
        return deliveryRepository.save(delivery);
    }
}