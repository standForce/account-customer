package com.transaction.accountcustomer.model;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class AccountModel {

    private Integer id;
    private Integer customerId;
    private String number;
    private String type;
    private Double balance;
    private boolean status;
}
