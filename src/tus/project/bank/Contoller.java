package tus.project.bank;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

// This class contains all test data. Will be called from Main by creating an instance of it
public class Contoller {

    AccountHolder accHolder = new AccountHolder("John", 9876543210L, "john123@gmail.com", "1234567A");
    SavingsAccount acct = new SavingsAccount("AIB1234567", accHolder, LocalDate.of(2022, 11, 23), 100);

    public Bank getInvestmentBank(){
       List<Account> ackList = new ArrayList<Account>();
       ackList.add(acct);
       Bank bk = new Bank("AIB", "Investment", ackList);
       return bk;
    }

    public List<Account> showAllActiveAccounts(Bank bank){
     return bank.getAccountList().stream().filter((acc) -> acc.isActive).collect(Collectors.toList());
    }
}
