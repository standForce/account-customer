package com.transaction.accountcustomer.repository;

import com.transaction.accountcustomer.entity.Balance;
import com.transaction.accountcustomer.model.ReportModel;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

import java.time.LocalDate;

@Repository
public interface BalanceRepository extends ReactiveCrudRepository<Balance, Integer> {
    @Query("select ba_date as date, cu_name as customer, ac_number as account," +
            " ac_type as type, ac_balance as balance, ac_status as status, ba_value as value " +
            "from balance a " +
            "join account b on (b.ac_id = a.ac_id)  " +
            "join customer c on (c.cu_id = b.cu_id) " +
            "where a.ba_date between :?1 and :?2 "
            )
    Flux<ReportModel> findBalanceDetails(LocalDate startDate, LocalDate endDate);
}
