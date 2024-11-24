package tus.project.bank;

import java.util.List;

public class Bank {
    private String name;
    private String typeOfBank;

    private List<Account> accountList;

    public Bank(String name, String typeOfBank, List<Account> accountList) {
        this.name = name;
        this.typeOfBank = typeOfBank;
        this.accountList = accountList;
    }

    public Bank(){}

    @Override
    public String toString() {
        return "Bank{" +
                "name='" + name + '\'' +
                ", typeOfBank='" + typeOfBank + '\'' +
                ", accountList=" + accountList +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTypeOfBank() {
        return typeOfBank;
    }

    public void setTypeOfBank(String typeOfBank) {
        this.typeOfBank = typeOfBank;
    }

    public List<Account> getAccountList() {
        return accountList;
    }

    public void setAccountList(List<Account> accountList) {
        this.accountList = accountList;
    }
}
