package service;

import com.transaction.accountcustomer.mapper.AccountMapper;
import com.transaction.accountcustomer.repository.AccountRepository;
import com.transaction.accountcustomer.service.AccountService;
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
class AccountServiceTest {
    @InjectMocks
    AccountService accountService;
    @Mock
    AccountRepository accountRepository;
    @Mock
    AccountMapper accountMapper;

    @Test
    void  get_account_list_test(){
        Mockito.when(accountRepository.findAll())
                .thenReturn(Flux.just(MockData.getAccountList()));

        Mockito.when(accountMapper.getAccountModelFromEntity(Mockito.any())).thenReturn(MockData.getAccountModelList());

        StepVerifier.create(accountService.getAccountList())
                .expectNextCount(1)
                .verifyComplete();
    }

    @Test
    void get_account_update_Account(){
        Mockito.when(accountRepository.save(Mockito.any()))
                .thenReturn(Mono.just(MockData.getAccountList()));

        Mockito.when(accountMapper.getAccountModelFromEntity(Mockito.any())).thenReturn(MockData.getAccountModelList());

        StepVerifier.create(accountService.saveAccount(MockData.getAccountList()))
                .expectNextCount(1)
                .verifyComplete();
    }

    @Test
    void save_account_test(){
        Mockito.when(accountRepository.save(Mockito.any()))
                .thenReturn(Mono.just(MockData.getAccountList()));

        Mockito.when(accountMapper.getAccountModelFromEntity(Mockito.any())).thenReturn(MockData.getAccountModelList());

        StepVerifier.create(accountService.saveAccount(MockData.getAccountList()))
                .expectNextCount(1)
                .verifyComplete();
    }

    @Test
    void  get_account_by_id_test(){
        Mockito.when(accountRepository.findById(Mockito.anyInt()))
                .thenReturn(Mono.just(MockData.getAccountList()));

        Mockito.when(accountMapper.getAccountModelFromEntity(Mockito.any())).thenReturn(MockData.getAccountModelList());

        StepVerifier.create(accountService.getAccountById(1))
                .expectNextCount(1)
                .verifyComplete();
    }
}
