package com.devsu.account.services;

import com.devsu.account.dto.AccountDto;
import com.devsu.account.dto.MovementDto;
import com.devsu.account.models.Account;
import com.devsu.account.models.Movement;
import com.devsu.account.repositories.AccountRepository;
import com.devsu.account.repositories.MovementRepository;
import com.devsu.account.utils.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.*;

@RestController
@RequestMapping("/api/movement")
public class MovementService {

    @Autowired
    private MovementRepository movementRepository;

    @Autowired
    private AccountRepository accountRepository;

    @GetMapping
    public Iterable<MovementDto> getAllMovements(){

        Iterable<Movement> movements = this.movementRepository.findAll();
        Set<MovementDto> response = MovementDto.parseMovementArrayToDto(movements);
        return response;
    }

    @PostMapping
    public Response<MovementDto> createMovement( @Validated @RequestBody MovementDto movement) {
        Response<MovementDto> response = new Response<>();
        try {

            Account account = null;

            Optional<Account> accountRef = this.accountRepository.findById(movement.account.account_number);
            account = accountRef.orElseThrow();

            if (account.getInitial_balance() == null) {
                response.setCode(HttpStatus.BAD_REQUEST);
                response.setResponse("Account without balance.");

            }

            int newBalance = account.getInitial_balance() + movement.ammount;
            if(newBalance < 0){
                response.setResponse("No enough money in the account to perform the movement.");
                response.setCode(HttpStatus.BAD_REQUEST);
            }

            Movement newMovement = new Movement();
            newMovement.setBalance(newBalance);
            newMovement.setAmmount(movement.ammount);
            newMovement.setDate(movement.date);
            newMovement.setAccount(account);
            newMovement.setDate(new Date());
            this.movementRepository.save(newMovement);

            account.setInitial_balance(newBalance);
            Set<Movement> newMovements = account.getMovements();
            newMovements.add(newMovement);
            account.setMovements(newMovements);
            accountRepository.save(account);

            response.setCode(HttpStatus.OK);
            response.setResponse("Movement saved successfully");

            MovementDto movementDto = MovementDto.parseMovementToDto(newMovement);

            AccountDto accountDto = new AccountDto();
            accountDto.initial_balance = account.getInitial_balance();
            accountDto.account_number = account.getAccount_number();
            movementDto.account = accountDto;

            response.setJson(movementDto);
            return response;


        } catch (Exception e) {
            response.setCode(HttpStatus.BAD_REQUEST);
            response.setResponse(e.getMessage());
            return response;
        }

    }

    @PutMapping
    public Movement updateMovement( @Validated @RequestBody Movement movement) {

        return this.movementRepository.save(movement);

    }

    @DeleteMapping
    public void deleteMovement(@PathVariable Long id){
        this.movementRepository.deleteById(id);
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/report")
    public Response<Set<MovementDto>> getMovementsByAccount(@RequestParam Map<String,String> allParams){
        Response<Set<MovementDto>> response = new Response<>();
        try{
            System.out.println("Parameters are: " + allParams.entrySet());

            UUID accountId = UUID.fromString(allParams.get("id"));
            Account account = this.accountRepository.findById(accountId).orElseThrow();
            SimpleDateFormat formatter = new SimpleDateFormat("dd-mm-yyyy", Locale.ENGLISH);
            Date start_date = formatter.parse(allParams.get("start_date"));
            Date end_date = formatter.parse(allParams.get("end_date"));

            ArrayList<Movement> movements = this.movementRepository.findMovementByAccountAndDateGreaterThanAndDateLessThan(account,start_date, end_date);

            response.setCode(HttpStatus.OK);
            response.setJson(MovementDto.parseMovementArrayToDto(movements));
            response.setResponse("Account fetched successfully");
        }catch (Exception e){
            response.setResponse(e.getMessage());
            response.setCode(HttpStatus.BAD_REQUEST);
        }
        return response;
    }
}
