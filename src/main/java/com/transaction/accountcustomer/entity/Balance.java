package com.transaction.accountcustomer.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDate;

@Table
@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class Balance {
    @Id
    @Column("ba_id")
    private Integer id;

    @Column("ac_id")
    private Integer accountId;

    @Column("ba_date")
    private LocalDate date;

    @Column("ba_type")
    private String type;

    @Column("ba_value")
    private Double value;

    @Column("ba_balance")
    private Double balance;

}
