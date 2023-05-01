package com.transaction.accountcustomer.mapper;
import com.transaction.accountcustomer.entity.Customer;
import com.transaction.accountcustomer.model.CustomerModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;


@Mapper(componentModel = "spring")
public interface CustomerMapper {

    CustomerModel getCustomerModelFromEntity (Customer customer);

    @Mapping(target = "id" ,source = "customerId")
    Customer getCustomerFromCustomerModel (CustomerModel customer, Integer customerId);


}
