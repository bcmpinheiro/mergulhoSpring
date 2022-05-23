package com.algaworks.algalog.controller;

import com.algaworks.algalog.model.Client;
import com.algaworks.algalog.repository.ClientRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@RestController
@GetMapping("/clients")
public class ClientController {

    @Autowired
    private ClientRepository clientRepository;

    @GetMapping
    public List<Client> list() {
        return clientRepository.findAll();
    }

    @GetMapping("/{clientId}")
    public ResponseEntity<Client> search(@PathVariable Long clientId) {
        return clientRepository.findById(clientId)
//              .map (client -> ResponseEntity.ok(client))
                .map (ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());

//        if (client.isPresent()) {
//            return ResponseEntity.ok(client.get());
//        } return ResponseEntity.notFound().build();
    }
}
