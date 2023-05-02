package com.transaction.accountcustomer.service;

import com.transaction.accountcustomer.error.ErrorMessage;
import com.transaction.accountcustomer.model.ReportModel;
import com.transaction.accountcustomer.repository.BalanceRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.LocalDate;

@Service
@Slf4j
@RequiredArgsConstructor
public class ReportService {

    private final BalanceRepository balanceRepository;

    public Flux<ReportModel> getBalanceByDate(LocalDate startDate, LocalDate endDate) {
        return balanceRepository.findBalanceDetails(startDate, endDate)
                .doOnError(error -> {
                    log.error("Error getting balance details", error);
                    Mono.error(new ErrorMessage("Error getting balance details", error));
                });
    }


}
