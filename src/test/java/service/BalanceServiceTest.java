package service;

import com.transaction.accountcustomer.mapper.BalanceMapper;
import com.transaction.accountcustomer.mapper.CustomerMapper;
import com.transaction.accountcustomer.repository.AccountRepository;
import com.transaction.accountcustomer.repository.BalanceRepository;
import com.transaction.accountcustomer.repository.CustomerRepository;
import com.transaction.accountcustomer.service.AccountService;
import com.transaction.accountcustomer.service.BalanceService;
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
class BalanceServiceTest {

    @InjectMocks
    BalanceService balanceService;
    @Mock
    BalanceRepository balanceRepository;
    @Mock
    BalanceMapper balanceMapper;
    @Mock
    AccountRepository accountRepository;

    @Test
    void  get_balance_list_test(){
        Mockito.when(balanceRepository.findAll())
                .thenReturn(Flux.just(MockData.getBalanceList()));

        Mockito.when(balanceMapper.getBalanceModelFromEntity(Mockito.any())).thenReturn(MockData.getBalanceModelList());

        StepVerifier.create(balanceService.getBalanceList())
                .expectNextCount(1)
                .verifyComplete();
    }

    @Test
    void  get_balance_by_id_test(){
        Mockito.when(balanceRepository.findById(Mockito.anyInt()))
                .thenReturn(Mono.just(MockData.getBalanceList()));

        Mockito.when(balanceMapper.getBalanceModelFromEntity(Mockito.any())).thenReturn(MockData.getBalanceModelList());

        StepVerifier.create(balanceService.getBalanceById(1))
                .expectNextCount(1)
                .verifyComplete();
    }

    @Test
    void  save_balance_test(){
        Mockito.when(accountRepository.findById(Mockito.anyInt())).thenReturn(Mono.just(MockData.getAccountList()));

        Mockito.when(balanceRepository.save(Mockito.any()))
                .thenReturn(Mono.just(MockData.getBalanceList()));

        Mockito.when(accountRepository.save(Mockito.any())).thenReturn(Mono.just(MockData.getAccountList()));

        Mockito.when(balanceMapper.getBalanceModelFromEntity(Mockito.any())).thenReturn(MockData.getBalanceModelList());

        StepVerifier.create(balanceService.saveBalance(MockData.getBalanceModelList()))
                .expectNextCount(1)
                .verifyComplete();
    }
}
