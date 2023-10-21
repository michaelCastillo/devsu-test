package com.devsu.account.repositories;

import com.devsu.account.models.Account;
import com.devsu.account.models.Movement;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Date;

@Repository
public interface MovementRepository extends CrudRepository<Movement, Long> {

    public ArrayList<Movement> findMovementByAccountAndDateGreaterThanAndDateLessThan(Account account, Date startDate, Date endDate);

    public ArrayList<Movement> findMovementByDateGreaterThanEqualAndDateLessThan(Date startDate, Date endDate);
}
