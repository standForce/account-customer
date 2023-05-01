package constants;

import com.transaction.accountcustomer.entity.Account;
import com.transaction.accountcustomer.entity.Balance;
import com.transaction.accountcustomer.entity.Customer;
import com.transaction.accountcustomer.model.AccountModel;
import com.transaction.accountcustomer.model.BalanceModel;
import com.transaction.accountcustomer.model.CustomerModel;
import com.transaction.accountcustomer.model.ReportModel;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class MockData {

    public static Account getAccountList() {
        Account accountItem = new Account();
        accountItem.setId(1);
        accountItem.setCustomerId(1);
        accountItem.setNumber("200012345678");
        accountItem.setType("A");
        accountItem.setBalance(100.00);
        accountItem.setStatus(true);
        return  accountItem;
    }

    public static AccountModel getAccountModelList() {
        AccountModel accountItem = new AccountModel();
        accountItem.setId(1);
        accountItem.setCustomerId(1);
        accountItem.setNumber("200012345678");
        accountItem.setType("A");
        accountItem.setBalance(100.00);
        accountItem.setStatus(true);
        return  accountItem;
    }

    public static Customer getCustomerList() {
        Customer customerItem = new Customer();
        customerItem.setId(1);
        customerItem.setPassword("123456");
        customerItem.setStatus(true);
        customerItem.setName("Juan Perez");
        customerItem.setGender("M");
        customerItem.setAge(35);
        customerItem.setDocument("1717572369");
        customerItem.setAddress("Quito");
        customerItem.setPhone("0912345678");
        return customerItem;
    }

    public static CustomerModel getCustomerModelList() {
        CustomerModel customerItem = new CustomerModel();
        customerItem.setId(1);
        customerItem.setPassword("123456");
        customerItem.setStatus(true);
        customerItem.setName("Juan Perez");
        customerItem.setGender("M");
        customerItem.setAge(35);
        customerItem.setDocument("1717572369");
        customerItem.setAddress("Quito");
        customerItem.setPhone("0912345678");
        return customerItem;
    }

    public static Balance getBalanceList() {
        Balance balanceItem = new Balance();
        balanceItem.setId(1);
        balanceItem.setAccountId(1);
        balanceItem.setDate(LocalDate.now());
        balanceItem.setType("C");
        balanceItem.setValue(10.00);
        balanceItem.setBalance(0.00);
        return balanceItem;
    }

    public static BalanceModel getBalanceModelList() {
        BalanceModel balanceItem = new BalanceModel();
        balanceItem.setId(1);
        balanceItem.setAccountId(1);
        balanceItem.setDate(LocalDate.now());
        balanceItem.setType("C");
        balanceItem.setValue(10.00);
        balanceItem.setBalance(0.00);
        return balanceItem;
    }

    public static ReportModel getReportModelList() {
        ReportModel reportModelItem = new ReportModel();
        reportModelItem.setDate(LocalDateTime.now());
        reportModelItem.setCustomer("Juan Perez");
        reportModelItem.setAccount("200012345678");
        reportModelItem.setType("A");
        reportModelItem.setBalance(100.00);
        reportModelItem.setStatus(true);
        reportModelItem.setValue(10.00);

        return reportModelItem;
    }
}
