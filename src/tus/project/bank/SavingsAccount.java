package tus.project.bank;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class SavingsAccount extends Account implements Transactions{
    SavingsAccount(String accountNumber, AccountHolder accountHolder, LocalDate accountOpenDate, int balance){
        super(accountNumber, accountHolder, accountOpenDate, balance);
        this.interestRate = 1.5f;
    }
    float interestRate;
    public double interestGained(){
        long daysBetween = ChronoUnit.DAYS.between(acctOpenDate, LocalDate.now());
        double yearsBetween = daysBetween / 365.0; // Convert days to years
        return balance * 0.015 * yearsBetween;
    }


    @Override
    public boolean deposit(int amount) {
        balance = balance + amount;
        this.setBalance(balance);
        return true;
    }

    @Override
    public boolean withdraw(int amount) {
        if(amount < balance){
            balance = balance - amount;
            this.setBalance(balance);
        }
        else{
            System.out.println("Cannot update: withdrawl greater than available balance");
            return false;
        }
        return true;
    }
}
