package tus.project.bank;

import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

// Use of Sealed class
public sealed class Account implements Operations permits CurrentAccount, FixedDepositAccount, SavingsAccount {

    // Use of enums
    public enum AccountStatus {
        ACTIVE,
        INACTIVE,
        SUSPENDED,
        CLOSED
    }
    protected AccountStatus status;
    protected List<Statements> accountStatements;

    public AccountStatus getStatus() {
        return status;
    }

    public void setStatus(AccountStatus status) {
        this.status = status;
    }

    protected String accountNumber; // use of strings
    protected AccountHolder accountHolder;
    protected LocalDate acctOpenDate; // Use of LocalDate API

    protected int balance;
    protected float interestRate;
    protected List<Card> cardList;

    public float getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(float interestRate) {
        this.interestRate = interestRate;
    }

    public List<Card> getCardList() {
        return cardList;
    }

    public void setCardList(List<Card> cardList) {
        this.cardList = cardList;
    }

    public Account(String accountNumber, AccountHolder accountHolder) {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
    }

    public Account(String accountNumber, AccountHolder accountHolder, LocalDate acctOpenDate, int balance) {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.acctOpenDate = acctOpenDate;
        this.balance = balance;
        this.status = AccountStatus.ACTIVE;
    }

    public LocalDate getAcctOpenDate() {
        return acctOpenDate;
    }

    public void setAcctOpenDate(LocalDate acctOpenDate) {
        this.acctOpenDate = acctOpenDate;
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

    // Use of this()
    public Account(){
        this("`1234", new AccountHolder(), LocalDate.now(), 0);
    }

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

    @Override
    public boolean deposit(int amount) {
        balance = balance + amount;
        this.setBalance(balance);
        return true;
    }

    // Method Overloading
    @Override
    public boolean withdraw(int amount) {
        int counter = 0;
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

    public boolean withdraw(int amount, int transactionFee) {
        if(amount < (balance + transactionFee)){
            balance = balance - amount - transactionFee;
            this.setBalance(balance);
        }
        else{
            System.out.println("Cannot update: withdrawl greater than available balance plus transaction fee");
            return false;
        }
        return true;
    }

    public List<Statements> getAccountStatements() {
        return accountStatements;
    }

    public void setAccountStatements(List<Statements> accountStatements) {
        this.accountStatements = accountStatements;
    }

    // Overriden in savings and fixed deposit
    public double interestGained() {
        return 0; // default
    }

    public float getTransactionFee(String transactionType){
        // Switch Expresion - Java 23
       return switch(transactionType){
           case "WITHDRAWL", "DEPOSIT" -> 1.50f;
           case "TRANSFER", "PAYMENT" -> 2.00f;
           default -> throw new IllegalArgumentException("Invalid transaction type: " + transactionType);
       };
    }

    // Checked Exception
    public boolean validatePPSN(String filename) throws FileNotFoundException {
         File input = new File(filename);
         String ppsn = "";
         String name = "";
         List<String> words = new ArrayList<>();
        String line = "";
         Scanner scanner = new Scanner(input);
         while(scanner.hasNext()){
              line = scanner.nextLine();
         }
         words = List.of(line.split(" "));
         ppsn = words.get(0);
         name = words.get(1);
         if(name.equalsIgnoreCase(this.getAccountHolder().getName())
                 && ppsn.equalsIgnoreCase(this.getAccountHolder().getPpsn())){
             return true;
         }
         return false;
    }
}
