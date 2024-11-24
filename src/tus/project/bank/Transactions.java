package tus.project.bank;

public interface Transactions {
    boolean deposit(int amount);
    boolean withdraw(int amount);
}
