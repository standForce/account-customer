package com.transaction.accountcustomer.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table
@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class Account {

    @Id
    @Column("ac_id")
    private Integer id;

    @Column("cu_id")
    private Integer customerId;

    @Column("ac_number")
    private String number;

    @Column("ac_type")
    private String type;

    @Column("ac_balance")
    private Double balance;

    @Column("ac_status")
    private boolean status;

}
