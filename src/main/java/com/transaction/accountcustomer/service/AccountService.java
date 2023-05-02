package com.transaction.accountcustomer.service;

import com.transaction.accountcustomer.entity.Account;
import com.transaction.accountcustomer.error.ErrorMessage;
import com.transaction.accountcustomer.mapper.AccountMapper;
import com.transaction.accountcustomer.model.AccountModel;
import com.transaction.accountcustomer.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@Slf4j
@RequiredArgsConstructor
public class AccountService {

    private final AccountRepository accountRepository;
    private final AccountMapper accountMapper;

    public Flux<AccountModel> getAccountList() {

        return accountRepository.findAll()
                .doOnError(error -> {
                    log.error("Error findAll account: ", error);
                    Mono.error(new ErrorMessage("Error findAll account", error));
                })
                .map(accountMapper::getAccountModelFromEntity);

    }

    public Mono<AccountModel> getAccountById(int accountId) {

        return accountRepository.findById(accountId)
                .doOnError(error -> {
                    log.error("Error getAccountById account: ", error);
                    Mono.error(new ErrorMessage("Error find account by id", error));
                })
                .map(accountMapper::getAccountModelFromEntity);
    }

    public Mono<AccountModel> saveAccount(Account account) {

        return accountRepository.save(account)
                .doOnError(error -> {
                    log.error("Error saving account: ", error);
                    Mono.error(new ErrorMessage("Error saving account", error));
                })
                .map(accountMapper::getAccountModelFromEntity);
    }

    public Mono<AccountModel> updateAccount(int accountId, Account account) {
        log.info("accountId: {}, account: {}", accountId, account);
        return accountRepository.save(new Account(accountId, account.getCustomerId(), account.getNumber(), account.getType(),
                        account.getBalance(), account.isStatus()))
                .doOnError(error -> {
                    log.error("Error updating account: ", error);
                    Mono.error(new ErrorMessage("Error updating account", error));
                })
                .map(accountMapper::getAccountModelFromEntity);
    }

    public Mono<Void> deleteAccount(int accountId) {
        return accountRepository.deleteById(accountId)
                .doOnError(error -> {
                    log.error("Error deleting account: ", error);
                    Mono.error(new ErrorMessage("Error deleting account", error));
                });
    }
}
