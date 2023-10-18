package com.devsu.account.services;

import com.devsu.account.models.Movement;
import com.devsu.account.repositories.MovementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/api/movement")
public class MovementService {

    @Autowired
    private MovementRepository movementRepository;

    @GetMapping
    public Iterable<Movement> getAllMovements(){
        return this.movementRepository.findAll();
    }

    @PostMapping
    public Movement createMovement(@RequestBody Movement movement){
        return this.movementRepository.save(movement);
    }
}
