package com.algaworks.algalog.controller;

import com.algaworks.algalog.model.Client;
import com.algaworks.algalog.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Arrays;
import java.util.List;

@RestController
public class ClientController {

    @PersistenceContext
    private EntityManager manager;

    @Autowired
    private ClientRepository clientRepository;

    @GetMapping("/clients")
    public List<Client> list() {
        return manager.createQuery("from Client", Client.class)
                .getResultList();
    }
}
