package com.example.gourmet.Conroller;


import com.example.gourmet.Dto.ClientDTO;
import com.example.gourmet.Service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Client")
public class ClientController {

    @Autowired
    ClientService clientService;


    @PostMapping("/add")
    ClientDTO addClient(@RequestBody  ClientDTO clientDTO){
        return  clientService.registerClient(clientDTO);
    }
}

