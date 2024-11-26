package tus.project.bank;

import java.time.LocalDate;

// Record Class
public record Statements(String accountNumber, String customerName, LocalDate fromDate, LocalDate toDate) {

    public Statements{
        if(fromDate == null || toDate == null || customerName == null || accountNumber == null){
            throw new IllegalArgumentException("Please give valid arguments");
        }
    }
}
