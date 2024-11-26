import java.time.LocalDate;

// Immutable class
public final class CardTransaction {
    private final String merchantName;
    private final String transactionId;
    private final float amount;
    private final LocalDate dateOfTransaction;

    public CardTransaction(String merchantName, String transactionId, float amount, LocalDate dateOfTransaction) {
        this.merchantName = merchantName;
        this.transactionId = transactionId;
        this.amount = amount;
        this.dateOfTransaction = dateOfTransaction;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "merchantName='" + merchantName + '\'' +
                ", transactionId='" + transactionId + '\'' +
                ", amount=" + amount +
                ", dateOfTransaction=" + dateOfTransaction +
                '}';
    }

    public String getMerchantName() {
        return merchantName;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public float getAmount() {
        return amount;
    }

    public LocalDate getDateOfTransaction() {
        return dateOfTransaction;
    }
}
