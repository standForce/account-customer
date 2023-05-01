package service;

import com.transaction.accountcustomer.mapper.CustomerMapper;
import com.transaction.accountcustomer.repository.CustomerRepository;
import com.transaction.accountcustomer.service.CustomerService;
import constants.MockData;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

@ExtendWith(SpringExtension.class)
class CustomerServiceTest {
    @InjectMocks
    CustomerService customerService;
    @Mock
    CustomerRepository customerRepository;
    @Mock
    CustomerMapper customerMapper;

    @Test
    void  get_customer_list_test(){
        Mockito.when(customerRepository.findAll())
                .thenReturn(Flux.just(MockData.getCustomerList()));

        Mockito.when(customerMapper.getCustomerModelFromEntity(Mockito.any())).thenReturn(MockData.getCustomerModelList());

        StepVerifier.create(customerService.getCustomerList())
                .expectNextCount(1)
                .verifyComplete();
    }

    @Test
    void get_customer_update_Account(){
        Mockito.when(customerRepository.save(Mockito.any()))
                .thenReturn(Mono.just(MockData.getCustomerList()));

        Mockito.when(customerMapper.getCustomerModelFromEntity(Mockito.any())).thenReturn(MockData.getCustomerModelList());

        StepVerifier.create(customerService.saveCustomer(MockData.getCustomerList()))
                .expectNextCount(1)
                .verifyComplete();
    }

    @Test
    void save_customer_test(){
        Mockito.when(customerRepository.save(Mockito.any()))
                .thenReturn(Mono.just(MockData.getCustomerList()));

        Mockito.when(customerMapper.getCustomerModelFromEntity(Mockito.any())).thenReturn(MockData.getCustomerModelList());

        StepVerifier.create(customerService.saveCustomer(MockData.getCustomerList()))
                .expectNextCount(1)
                .verifyComplete();
    }

    @Test
    void  get_customer_by_id_test(){
        Mockito.when(customerRepository.findById(Mockito.anyInt()))
                .thenReturn(Mono.just(MockData.getCustomerList()));

        Mockito.when(customerMapper.getCustomerModelFromEntity(Mockito.any())).thenReturn(MockData.getCustomerModelList());

        StepVerifier.create(customerService.getCustomerById(1))
                .expectNextCount(1)
                .verifyComplete();
    }
}
