package com.transaction.accountcustomer.model;

import lombok.Data;
import lombok.ToString;

import java.time.LocalDateTime;
@Data
@ToString
public class ReportModel {
    private LocalDateTime date;
    private String customer;
    private String account;
    private String type;
    private Double balance;
    private boolean status;
    private Double value;
}
