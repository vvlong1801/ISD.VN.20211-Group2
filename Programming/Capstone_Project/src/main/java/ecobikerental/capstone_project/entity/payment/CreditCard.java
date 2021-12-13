package ecobikerental.capstone_project.entity.payment;

/**
 * Entity CreditCard
 */
public class CreditCard {
    /**
     * Represent the code of card
     */
    private String cardCode;
    /**
     * Represent the owner of card
     */
    private String owner;
    /**
     * Represent the cvvCode of card
     */
    private int cvvCode;
    /**
     * Represent the expired date of card
     */
    private String dateExpired;

    /**
     * Constructor with 4 arguments
     * @param cardCode - the code of card
     * @param owner - the owner of card
     * @param cvvCode - the cvvCode of card
     * @param dateExpired - the expired date of card
     */
    public CreditCard(String cardCode, String owner, int cvvCode, String dateExpired) {
        super();
        this.cardCode = cardCode;
        this.owner = owner;
        this.cvvCode = cvvCode;
        this.dateExpired = dateExpired;
    }
}
