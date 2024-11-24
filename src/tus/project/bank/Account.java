package tus.project.bank;

import java.time.LocalDate;

public class Account {
    protected String accountNumber;
    protected AccountHolder accountHolder;
    protected LocalDate acctOpenDate;

    protected  boolean isActive;

    protected int balance;

    public Account(String accountNumber, AccountHolder accountHolder) {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.isActive = true;
    }

    public Account(String accountNumber, AccountHolder accountHolder, LocalDate acctOpenDate, int balance) {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.acctOpenDate = acctOpenDate;
        this.balance = balance;
        this.isActive = true;
    }

    public LocalDate getAcctOpenDate() {
        return acctOpenDate;
    }

    public void setAcctOpenDate(LocalDate acctOpenDate) {
        this.acctOpenDate = acctOpenDate;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "Account{" +
                "accountNumber=" + accountNumber +
                ", accountHolder=" + accountHolder +
                '}';
    }

    public Account(){}

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public AccountHolder getAccountHolder() {
        return accountHolder;
    }

    public void setAccountHolder(AccountHolder accountHolder) {
        this.accountHolder = accountHolder;
    }
}
