package tus.project.bank;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public non-sealed class SavingsAccount extends Account implements Operations {
    float interestRate;
    int transactionFee;
    SavingsAccount(String accountNumber, AccountHolder accountHolder, LocalDate accountOpenDate, int minimumBalance){
        super(accountNumber, accountHolder, accountOpenDate, minimumBalance);
        this.interestRate = 1.5f;
        this.transactionFee = 3;
    }

    @Override
    public double interestGained(){
        long daysBetween = ChronoUnit.DAYS.between(super.acctOpenDate, LocalDate.now());
        double yearsBetween = daysBetween / 365.0; // Convert days to years
        return super.balance * 0.015 * yearsBetween;
    }
}
