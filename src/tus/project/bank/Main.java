package tus.project.bank;

public class Main {
    public static void main(String[] args) {
        System.out.println("Implementing a bank project");
        Contoller contoller = new Contoller();
        Bank bk = contoller.getInvestmentBank();
        for(Account ac: bk.getAccountList()){
            if(ac instanceof SavingsAccount) {
                SavingsAccount savAcc = (SavingsAccount) ac;
                System.out.println("Interest gained for account "+ savAcc.getAccountNumber() + " is: " + savAcc.interestGained());
            }
            else{
                System.out.println("Account number is: "+ ac.getAccountNumber());
            }
        }
    }
}