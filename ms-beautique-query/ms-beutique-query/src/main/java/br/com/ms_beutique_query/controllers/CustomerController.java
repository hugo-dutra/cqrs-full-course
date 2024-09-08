package br.com.ms_beutique_query.controllers;


import br.com.ms_beutique_query.dtos.customers.CustomerDTO;
import br.com.ms_beutique_query.services.CustomerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService){
        this.customerService = customerService;
    }

    @GetMapping()
    ResponseEntity<List<CustomerDTO>> listAllCustomers(){
        return ResponseEntity.ok(customerService.listAllCustomers());
    }

    @GetMapping("/name/{name}")
    ResponseEntity<List<CustomerDTO>> listByNameLikeIgnoreCase(@PathVariable String name) {
        return ResponseEntity.ok(customerService.listByNameLikeIgnoreCase(name));
    }

    @GetMapping("/email/{email}")
    ResponseEntity<List<CustomerDTO>> listByEmailLikeIgnoreCase(@PathVariable String email) {
        return ResponseEntity.ok(customerService.listByEmailLikeIgnoreCase(email));
    }
}
