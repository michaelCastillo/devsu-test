package com.devsu.client.repositories;

import com.devsu.client.models.Client;
import com.devsu.client.models.Person;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends CrudRepository<Client, Long> {
}
