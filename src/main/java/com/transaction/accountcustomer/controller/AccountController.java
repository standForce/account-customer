package com.transaction.accountcustomer.controller;

import com.transaction.accountcustomer.entity.Account;
import com.transaction.accountcustomer.model.AccountModel;
import com.transaction.accountcustomer.service.AccountService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/account")
@Slf4j
@RequiredArgsConstructor
public class AccountController {
    private final AccountService accountService;

    @GetMapping
    public Flux<AccountModel> getAccountLs(){
        log.info("getAccountLs...");
        return accountService.getAccountList();
    }

    @GetMapping("/{accountId}")
    public Mono<AccountModel> getAccountById(@PathVariable("accountId") int accountId){
        log.info("getAccountById...");
        return accountService.getAccountById(accountId);
    }

    @PostMapping
    public Mono<AccountModel> saveAccount( @RequestBody Account account){
        log.info("Saving account..");
        return accountService.saveAccount(account);
    }

    @PutMapping("/{accountId}")
    public Mono<AccountModel> updateAccountById(@PathVariable("accountId") int accountId, @RequestBody Account account){
        log.info("update account..");
        return accountService.updateAccount(accountId, account);
    }

    @DeleteMapping("/{accountId}")
    public Mono<Void> deleteAccountById(@PathVariable("accountId") int accountId){
        log.info("deleting account..");
        return accountService.deleteAccount(accountId);
    }
}
