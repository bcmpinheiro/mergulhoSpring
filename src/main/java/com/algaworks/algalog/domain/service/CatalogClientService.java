package com.algaworks.algalog.domain.service;

import com.algaworks.algalog.domain.exception.BusinessException;
import com.algaworks.algalog.domain.model.Client;
import com.algaworks.algalog.domain.repository.ClientRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@AllArgsConstructor
@Service
public class CatalogClientService {

    private ClientRepository clientRepository;

    public Client search (Long clientId) {
        return clientRepository.findById(clientId)
                .orElseThrow(() -> new BusinessException("Cliente não encontrado"));
    }

    @Transactional
    public Client save(Client client) {
        boolean emailInUse = clientRepository.findByEmail(client.getEmail())
                .stream()
                .anyMatch(clientExist -> !clientExist.equals(client));
        if(emailInUse) {
            throw new BusinessException("Já existe um cliente cadastrado com este e-mail.");
        }
        return clientRepository.save(client);
    }
    @Transactional
    public void delete(Long clienteId){
        clientRepository.deleteById(clienteId);
    }


}
