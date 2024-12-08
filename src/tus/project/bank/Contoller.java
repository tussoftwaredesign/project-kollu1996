package tus.project.bank;

import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

// This class contains all test data. Will be called from Main by creating an instance of it
public class Contoller {

    static Bank bank = new Bank("AIB", "Retail", new ArrayList<>());
    AccountHolder accHolder = new AccountHolder("John", 9876543210L, "john123@gmail.com", "1234567A");
    SavingsAccount acct = new SavingsAccount("AIB1234567", accHolder, LocalDate.of(2022, 11, 23), 100);
    CurrentAccount acct1 = new CurrentAccount("AIB3592049", accHolder,  LocalDate.of(2022, 11, 24), 200);
    FixedDepositAccount acct2 = new FixedDepositAccount("AIB3959194", accHolder, LocalDate.of(2022, 11, 25), 300, 4);

    public void createBank(){
        addAccountToBank(acct, acct1, acct2);
    }

    public Bank getInvestmentBank(){
       List<Account> ackList = new ArrayList<Account>();
       ackList.add(acct);
       Bank bk = new Bank("AIB", "Investment", ackList);
       return bk;
    }
    // acc variable is effectively final
    // Used method references with print statement
    // use of lambda expression
    public void printAllActiveAccounts(Bank bank) {
        bank.getAccountList().stream().filter((acc) ->
                    acc.getStatus().equals(Account.AccountStatus.ACTIVE))
                .toList().forEach(System.out::println);
    }

    // use of effectively final
    public void printAllAccounts(Bank bank) {
        String default_msg = "";
        bank.getAccountList().stream().forEach(acct ->{
            // default_msg = "abc" - Gives error if you try to re initialize
            System.out.println(default_msg + acct.toString());
        });
    }

    public boolean validatePPSNFile(String filename){
        try {
            // call by value
            return acct.validatePPSN(filename);
        }
        catch (FileNotFoundException ex){
            System.out.println("Unable to verify PPSN File: "+ ex.getMessage());
        }
        return false;
    }

    // varargs
    static void addAccountToBank(Account... accts){
         for(Account acc: accts){
            bank.getAccountList().add(acc);
         }
    }

    // Types of banks in the industry
    // use of string builder and arrays.
    // use of un checked exception/run time exception
    public static void typesOfBanks() throws Exception {
        try {
            StringBuilder sb = new StringBuilder();
            sb.append("Central ");
            sb.append("Commercial ");
            sb.append("Retail ");
            sb.append("Investment");
            sb.append("Cooperative ");
            String[] BankTypes = sb.toString().split(" ");
            System.out.println("Different bank types are: ");
            for (int k = 0; k < 5; k++) {
                System.out.println(BankTypes[k]);
            }
        }
        catch (ArrayIndexOutOfBoundsException ex){
            System.out.println("Issue with printing banks: "+ ex.getMessage());
        }
    }

}
