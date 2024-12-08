package tus.project.bank;

import java.time.LocalDate;

// Use of inheritance. Extending from account
// Use of super()
public non-sealed class CurrentAccount extends Account implements Operations {
        CurrentAccount(String accountNumber, AccountHolder accountHolder, LocalDate accountOpenDate, int minimumBalance){
        super(accountNumber, accountHolder, accountOpenDate, minimumBalance);
        if(minimumBalance >= 50) {
            this.monthlyFee = 5;
            this.minimumBalance = minimumBalance;
            this.transactionFee = 2;
        }
        else{
            System.out.println("WARN: Cannot create object properly because minimum balance required is 50 Euros");
            throw new IllegalArgumentException("Balance cannot be less than 50 Euros");
        }
    }
    int monthlyFee;
    int transactionFee;
    int minimumBalance;
}
