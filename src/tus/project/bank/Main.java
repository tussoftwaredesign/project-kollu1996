package tus.project.bank;

import java.time.LocalDate;

public class Main {

    public static void main(String[] args) {

        System.out.println("Implementing a bank project");
        System.out.println("--------------------------------------------------- ");
        Contoller contoller = new Contoller();

        // Creating bank
        contoller.createBank();
        System.out.println("Created a Retail Bank: " + Contoller.bank.getName());
        System.out.println("Account list in bank: ");

        // Printing all account numbers in bank
        // check if it is of type savings account
        for(Account ac: Contoller.bank.getAccountList()){
            if(ac instanceof SavingsAccount) {
                System.out.println("Savings Account: "+ ac.toString());
            }
            else if(ac instanceof FixedDepositAccount){
                System.out.println("Fixed Deposit Account: "+ ac.toString());
            }
            else{
                System.out.println("Current Account: "+ ac.getAccountNumber());
            }
        }
        try {
            // Code to print a sample bank statement
            Statements st = new Statements("AIB12345", "John Marek", LocalDate.of(2024, 10, 5), LocalDate.of(2024, 11, 26));
            System.out.println(st.toString());

            System.out.println("--------------------------------------------------- ");


            // Code to validate PPSN file
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