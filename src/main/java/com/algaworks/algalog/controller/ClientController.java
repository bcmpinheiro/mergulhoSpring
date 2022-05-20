package com.algaworks.algalog.controller;

import com.algaworks.algalog.model.Client;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class ClientController {

    @GetMapping("/clients")
    public List<Client> list() {

        var client01 = new Client();
        client01.setId(1L);
        client01.setName("Joao");
        client01.setCellphone("11 91234-5678");
        client01.setEmail("joao@email.com");

        var client02 = new Client();
        client02.setId(2L);
        client02.setName("Maria");
        client02.setCellphone("11 91234-5678");
        client02.setEmail("maria@email.com");

        return Arrays.asList(client01, client02);
    }
}
