package com.transaction.accountcustomer.mapper;

import com.transaction.accountcustomer.entity.Account;
import com.transaction.accountcustomer.model.AccountModel;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AccountMapper {
    AccountModel getAccountModelFromEntity (Account account);
}
