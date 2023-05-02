package com.transaction.accountcustomer.service;

import com.transaction.accountcustomer.entity.Customer;
import com.transaction.accountcustomer.entity.Person;
import com.transaction.accountcustomer.error.ErrorMessage;
import com.transaction.accountcustomer.mapper.CustomerMapper;
import com.transaction.accountcustomer.model.CustomerModel;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import com.transaction.accountcustomer.repository.CustomerRepository;

@Service
@Slf4j
@RequiredArgsConstructor
public class CustomerService {

    private final CustomerRepository customerRepository;
    private final CustomerMapper customerMapper;

    public Flux<CustomerModel> getCustomerList() {

        return customerRepository.findAll()
                .doOnError(error -> {
                    log.error("Error findAll customer: ", error);
                    Mono.error(new ErrorMessage("Error find customer", error));
                })
                .map(customerMapper::getCustomerModelFromEntity);

    }

    public Mono<CustomerModel> getCustomerById(int customerId) {
        return customerRepository.findById(customerId)
                .doOnError(error -> {
                    log.error("Error find customer by id: ", error);
                    Mono.error(new ErrorMessage("Error find customer by id", error));
                })
                .map(customerMapper::getCustomerModelFromEntity);
    }

    public Mono<CustomerModel> saveCustomer(Customer customer) {
        return customerRepository.save(customer)
                .doOnError(error -> {
                    log.error("Error saving customer: ", error);
                    Mono.error(new ErrorMessage("Error saving customer", error));
                })
                .map(customerMapper::getCustomerModelFromEntity);
    }

    public Mono<CustomerModel> updateCustomer(int customerId, CustomerModel customer) {

        return customerRepository.save(customerMapper.getCustomerFromCustomerModel(customer, customerId))
                .doOnError(error -> {
                    log.error("Error updating customer: ", error);
                    Mono.error(new ErrorMessage("Error updating customer", error));
                })
                .map(customerMapper::getCustomerModelFromEntity);
    }

    public Mono<Void> deleteCustomer(int customerId) {
        return customerRepository.deleteById(customerId)
                .doOnError(error -> {
                    log.error("Error deleting customer: ", error);
                    Mono.error(new ErrorMessage("Error deleting customer", error));
                });
    }
}
