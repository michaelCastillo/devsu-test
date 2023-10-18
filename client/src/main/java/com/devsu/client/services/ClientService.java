package com.devsu.client.services;

import com.devsu.client.models.Client;
import com.devsu.client.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/client")
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    @GetMapping
    public Iterable<Client> findAllClients(){
        return this.clientRepository.findAll();
    }

    @PostMapping
    public Client createClient(@Validated @RequestBody Client newClient){
        System.out.println("Client: ");
        System.out.println(newClient.toString());
        return this.clientRepository.save(newClient);
    }

    @PutMapping
    public void editClient(@RequestBody Client client){
        System.out.println("Client: " + client.toString());
        this.clientRepository.save(client);
    }

    @DeleteMapping("/{id}")
    public void deleteClient(@PathVariable(value="id") Long id){
        this.clientRepository.deleteById(id);
    }

}
