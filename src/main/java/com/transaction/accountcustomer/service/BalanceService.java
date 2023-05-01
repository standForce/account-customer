package com.transaction.accountcustomer.service;

import com.transaction.accountcustomer.entity.Balance;
import com.transaction.accountcustomer.mapper.BalanceMapper;
import com.transaction.accountcustomer.model.BalanceModel;
import com.transaction.accountcustomer.repository.AccountRepository;
import com.transaction.accountcustomer.repository.BalanceRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@Slf4j
@RequiredArgsConstructor
public class BalanceService {

    private final BalanceRepository balanceRepository;
    private final BalanceMapper balanceMapper;
    private final AccountRepository accountRepository;

    public Flux<BalanceModel> getBalanceList() {
        return balanceRepository.findAll()
                .doOnError(error -> log.error("Error findAll balance: " ,error))
                .map(balanceMapper::getBalanceModelFromEntity);
    }

    public Mono<BalanceModel> getBalanceById(int balanceId) {

        return balanceRepository.findById(balanceId)
                .doOnError(error -> log.error("Error find by id balance: " ,error))
                .map(balanceMapper::getBalanceModelFromEntity);
    }

    public Mono<BalanceModel> saveBalance(BalanceModel balance) {
        return accountRepository.findById(balance.getAccountId())
                .doOnError(error -> log.error("Error retrieving account"))
                .flatMap(account -> {
                    Double newBalance = calculateBalance(balance.getValue(),balance.getType(), account.getBalance());
                    balance.setBalance(newBalance);
                    account.setBalance(newBalance);
                    return balanceRepository.save(balanceMapper.getBalanceEntityFromBalanceModel(balance))
                            .doOnError(error -> log.error("Error updating balance"))
                            .doOnNext(data ->  accountRepository.save(account).subscribe())
                            .map(balanceMapper::getBalanceModelFromEntity);

                });
    }

    private Double calculateBalance(Double value, String type, Double accountBalance){
        if(type.equals("C")){
            accountBalance += value;
        }else{
            if(value.compareTo(accountBalance) > 0 ){
                throw new RuntimeException("Insufficient funds!!");
            }
            accountBalance -= value;
        }
        return accountBalance;
    }

    public Mono<BalanceModel> updateBalance(int balanceId, Balance balance) {
        return balanceRepository.save(new Balance(balanceId, balance.getAccountId(), balance.getDate(), balance.getType(), balance.getValue(), balance.getBalance()) )
                .doOnError(error -> log.error("Error updating balance: " ,error))
                .map(balanceMapper::getBalanceModelFromEntity);
    }

    public Mono<Void> deleteBalance(int balanceId) {
        return balanceRepository.deleteById(balanceId)
                .doOnError(error -> log.error("Error deleting balance: " ,error));
    }
}
