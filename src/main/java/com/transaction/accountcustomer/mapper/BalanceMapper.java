package com.transaction.accountcustomer.mapper;

import com.transaction.accountcustomer.entity.Balance;
import com.transaction.accountcustomer.model.BalanceModel;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface BalanceMapper {
    BalanceModel getBalanceModelFromEntity(Balance balance);

    Balance getBalanceEntityFromBalanceModel (BalanceModel balanceModel);

}
