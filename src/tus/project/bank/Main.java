package tus.project.bank;

import java.time.LocalDate;

public class Main {

    public static void main(String[] args) {

        System.out.println(args[1]);
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
        try {
            Statements st = new Statements("AIB12345", "John Marek", LocalDate.of(2024, 10, 5), LocalDate.of(2024, 11, 26));
            System.out.println(st.toString());
            boolean status = contoller.validatePPSNFile("C:\\Users\\sreen\\Downloads\\ppsnfile.txt");
            if(status){
                System.out.println("Valid PPSN File");
            }
            else{
                System.out.println("Not a valid PPSN File");
            }
        }
        catch (Exception ex){
            System.out.println("Exception occured in creating a statement: "+ ex.getMessage());
        }
    }
}