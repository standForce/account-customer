package com.transaction.accountcustomer.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.relational.core.mapping.Column;


@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class Person {

    @Column("cu_name")
    private String name;

    @Column("cu_gender")
    private String gender;

    @Column("cu_age")
    private Integer age;

    @Column("cu_document")
    private String document;

    @Column("cu_address")
    private String address;

    @Column("cu_phone")
    private String phone;

}
