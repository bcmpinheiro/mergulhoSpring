package controller;

import model.Cliente;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class ClienteController {

    @GetMapping("/clientes")
    public List<Cliente> list() {

        var cliente01 = new Cliente();
        cliente01.setId(1L);
        cliente01.setName("Joao");
        cliente01.setCellphone("11 91234-5678");
        cliente01.setEmail("joao@email.com");

        var cliente02 = new Cliente();
        cliente02.setId(2L);
        cliente02.setName("Maria");
        cliente02.setCellphone("11 91234-5678");
        cliente02.setEmail("maria@email.com");

        return Arrays.asList(cliente01, cliente02);
    }
}
