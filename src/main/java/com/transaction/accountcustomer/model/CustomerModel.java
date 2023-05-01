package com.transaction.accountcustomer.model;

import lombok.Data;
import lombok.ToString;
@Data
@ToString
public class CustomerModel {
    private Integer id;
    private String name;
    private String gender;
    private Integer age;
    private String document;
    private String address;
    private String phone;
    private String password;
    private boolean status;
}
