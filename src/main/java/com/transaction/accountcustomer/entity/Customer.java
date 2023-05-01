package com.transaction.accountcustomer.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Customer extends Person{

    @Id
    @Column("cu_id")
    private Integer id;

    @Column("cu_password")
    private String password;

    @Column("cu_status")
    private boolean status;

}
