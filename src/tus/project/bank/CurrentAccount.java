package tus.project.bank;

import java.time.LocalDate;

public class CurrentAccount extends Account{
    CurrentAccount(String accountNumber, AccountHolder accountHolder, LocalDate accountOpenDate, int minimumBalance){
        super(accountNumber, accountHolder, LocalDate.now(), 0);
        if(minimumBalance >= 50) {
            this.monthlyFee = 5;
            this.minimumBalance = minimumBalance;
        }
        else{
            System.out.println("WARN: Cannot create object properly because minimum balance required is 50 Euros");
        }
    }
    int monthlyFee;
    int minimumBalance;
}
