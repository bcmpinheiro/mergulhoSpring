package com.algaworks.algalog.controller;

import com.algaworks.algalog.model.Client;
import com.algaworks.algalog.repository.ClientRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@RestController
@RequestMapping ("/clients")
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
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Client add(@RequestBody Client client) {
        return clientRepository.save(client);
    }

    @PutMapping("/{clientId}")
    public ResponseEntity<Client> update(@PathVariable Long clientId, @RequestBody Client client) {
        if (!clientRepository.existsById(clientId)) {
            return ResponseEntity.notFound().build();
        }
        client.setId(clientId);
        client = clientRepository.save(client);
        return ResponseEntity.ok(client);
    }

    @DeleteMapping("/{clientId}")
    public ResponseEntity<Client> delete(@PathVariable Long clientId) {
        if (!clientRepository.existsById(clientId)) {
            return ResponseEntity.notFound().build();
        }
        clientRepository.deleteById(clientId);
        return ResponseEntity.noContent().build();
    }

}
