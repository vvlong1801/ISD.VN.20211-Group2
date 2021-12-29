package ecobikerental.capstone_project.entity.payment;

/**
 * Entity PaymentTransaction
 */
public class PaymentTransaction {
    /**
     * Represent for errorCode.
     */
    private String errorCode;
    /**
     * Represent for card.
     */
    private CreditCard card;
    /**
     * Represent for the id of transaction
     */
    private String transactionId;
    /**
     * Represent for the contents of transaction
     */
    private String transactionContent;
    /**
     * Represent for the amount to pay/refund
     */
    private int amount;
    /**
     * Represent for the time of transaction
     */
    private String createdAt;

    /**
     * Constructor with 6 arguments
     * @param errorCode - the errorCode
     * @param card - the card that user used
     * @param transactionId - the id of transaction
     * @param transactionContent - the content of transaction
     * @param amount - the amount to pay/refund
     * @param createdAt - the time of transaction
     */
    public PaymentTransaction(String errorCode, CreditCard card, String transactionId, String transactionContent,
                              int amount, String createdAt) {
        super();
        this.errorCode = errorCode;
        this.card = card;
        this.transactionId = transactionId;
        this.transactionContent = transactionContent;
        this.amount = amount;
        this.createdAt = createdAt;
    }

    /**
     * This method gets errorCode
     * @return errorCode
     */
    public String getErrorCode() {
        return errorCode;
    }
}
