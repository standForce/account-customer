package com.transaction.accountcustomer.controller;

import com.transaction.accountcustomer.entity.Customer;
import com.transaction.accountcustomer.model.CustomerModel;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import com.transaction.accountcustomer.service.CustomerService;

@RestController
@RequestMapping("/customer")
@Slf4j
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService customerService;

    @GetMapping
    public Flux<CustomerModel> getCustomerLs(){
        log.info("getCustomerLs...");
        return customerService.getCustomerList();
    }

    @GetMapping("/{customerId}")
    public Mono<CustomerModel> getCustomerById( @PathVariable("customerId") int customerId){
        log.info("getCustomerById...");
        return customerService.getCustomerById(customerId);
    }

    @PostMapping
    public Mono<CustomerModel> saveCustomer( @RequestBody Customer customer){
        log.info("Saving customer..");
        return customerService.saveCustomer(customer);
    }

    @PutMapping("/{customerId}")
    public Mono<CustomerModel> updateCustomer(@PathVariable("customerId") int customerId, @RequestBody CustomerModel customer){
        log.info("updateCustomer...");
        return customerService.updateCustomer(customerId, customer);
    }

    @DeleteMapping("/{customerId}")
    public Mono<Void> deleteCustomerById(@PathVariable("customerId") int customerId){
        log.info("deleteCustomerById...");
        return customerService.deleteCustomer(customerId);
    }

}
