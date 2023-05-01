package com.transaction.accountcustomer.model;

import lombok.Data;
import lombok.ToString;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Data
@ToString
public class BalanceModel {
    private Integer id;
    private Integer accountId;
    private LocalDate date;
    private String type;
    private Double value;
    private Double balance;
}
