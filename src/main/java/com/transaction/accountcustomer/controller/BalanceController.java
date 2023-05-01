package com.transaction.accountcustomer.controller;

import com.transaction.accountcustomer.entity.Balance;
import com.transaction.accountcustomer.model.BalanceModel;
import com.transaction.accountcustomer.service.BalanceService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/balance")
@Slf4j
@RequiredArgsConstructor
public class BalanceController {

    private final BalanceService balanceService;

    @GetMapping
    public Flux<BalanceModel> getBalanceLs(){
        log.info("getBalanceLs...");
        return balanceService.getBalanceList();
    }

    @GetMapping("/{balanceId}")
    public Mono<BalanceModel> getBalanceById(@PathVariable("balanceId") int balanceId){
        log.info("getBalanceById...");
        return balanceService.getBalanceById(balanceId);
    }

    @PostMapping
    public Mono<BalanceModel> saveBalance( @RequestBody BalanceModel balance){
        log.info("Saving balance..");
        return balanceService.saveBalance(balance);
    }

    @PutMapping("/{balanceId}")
    public Mono<BalanceModel> updateBalanceById(@PathVariable("balanceId") int balanceId, @RequestBody Balance balance){
        log.info("update balance...");
        return balanceService.updateBalance(balanceId, balance);
    }

    @DeleteMapping("/{balanceId}")
    public Mono<Void> deleteBalanceById(@PathVariable("balanceId") int balanceId){
        log.info("deleting balance...");
        return balanceService.deleteBalance(balanceId);
    }
}
