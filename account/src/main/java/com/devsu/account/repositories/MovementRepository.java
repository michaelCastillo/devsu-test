package com.devsu.account.repositories;

import com.devsu.account.models.Movement;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovementRepository extends CrudRepository<Movement, Long> {
}
