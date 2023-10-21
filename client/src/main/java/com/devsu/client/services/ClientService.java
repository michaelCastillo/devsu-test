package com.devsu.client.services;

import com.devsu.client.dto.AccountDto;
import com.devsu.client.dto.AccountReportDto;
import com.devsu.client.dto.MovementDto;
import com.devsu.client.models.Client;
import com.devsu.client.models.Person;
import com.devsu.client.repositories.ClientRepository;
import com.devsu.client.utils.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.lang.reflect.Array;
import java.util.*;


@RestController
@RequestMapping("/api/client")
public class ClientService {

    static final String ACCOUNT_URL = "http://account:8080/api/movement/report";

    @Autowired
    private ClientRepository clientRepository;

    @GetMapping
    public Iterable<Client> findAllClients(){
        return this.clientRepository.findAll();
    }

    @PostMapping
    public Client createClient(@Validated @RequestBody Client newClient){
        return this.clientRepository.save(newClient);
    }

    @PutMapping
    public void editClient(@RequestBody Client client){
        this.clientRepository.save(client);
    }

    @DeleteMapping("/{id}")
    public void deleteClient(@PathVariable(value="id") Long id){
        this.clientRepository.deleteById(id);
    }

    @GetMapping("/report")
    public Response buildAccountReport(@RequestParam Map<String,String> allParams) {
        //get Client
        Response<Object> response = new Response();
        ArrayList<AccountReportDto> summaryReport = new ArrayList<>();

        Long id = Long.valueOf(allParams.get("id"));
        String start_date = allParams.get("start_date");
        String end_date = allParams.get("end_date");

        try{
            Client client = this.clientRepository.findById(id).orElseThrow();
            String[] accountIds = client.getCountsArray();

            for(String accountId : accountIds){

                AccountReportDto accountReportDto = new AccountReportDto();
                RestTemplate restTemplate = new RestTemplate();


                String url = String.format("%s?id=%s&start_date=%s&end_date=%s", ACCOUNT_URL, accountId, start_date, end_date);
                System.out.println("URL: " + url);
                Response responseAccountsService = restTemplate.getForObject( url , Response.class);

                Object movements = responseAccountsService.getJson();

                accountReportDto.account_id = accountId;
                accountReportDto.movements = movements;
                summaryReport.add(accountReportDto);
            }


            response.setResponse("Report generated successfully");
            response.setCode(HttpStatus.OK);
            response.setJson(summaryReport);

        }catch (Exception e) {
            System.out.println(e.getMessage());
            response.setResponse(e.getMessage());
            response.setCode(HttpStatus.BAD_REQUEST);

        }
            return response;

        //Get accounts
        //Get movements by date.


    }

}
