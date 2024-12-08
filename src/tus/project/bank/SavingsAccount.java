package tus.project.bank;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

// Use of inheritance. Extending from account
public non-sealed class SavingsAccount extends Account implements Operations {
    float interestRate;
    int transactionFee;
    // Use of this
    // Use of Super()
    SavingsAccount(String accountNumber, AccountHolder accountHolder, LocalDate accountOpenDate, int minimumBalance){
        super(accountNumber, accountHolder, accountOpenDate, minimumBalance);
        this.interestRate = 1.5f;
        this.transactionFee = 3;
    }

    // Overriding
    // Use of super keyword
    @Override
    public double interestGained(){
        long daysBetween = ChronoUnit.DAYS.between(super.acctOpenDate, LocalDate.now());
        double yearsBetween = daysBetween / 365.0; // Convert days to years
        return super.balance * 0.015 * yearsBetween;
    }
}
