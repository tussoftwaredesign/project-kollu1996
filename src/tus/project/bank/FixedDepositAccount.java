package tus.project.bank;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public non-sealed class FixedDepositAccount extends Account implements Operations {
    int term;
    int penalty; // This represents percentage of money given before pre maturity date
    FixedDepositAccount(String accountNumber, AccountHolder accountHolder, LocalDate accountOpenDate, int balance, int term){
     this.term = term;
    }

    public float preMaturedAmount(){
        return super.balance * (penalty/100);
    }

    @Override
    public double interestGained(){
        long daysBetween = ChronoUnit.DAYS.between(acctOpenDate, LocalDate.now());
        double yearsBetween = daysBetween / 365.0; // Convert days to years
        return balance * 0.7 * yearsBetween;
    }

}
