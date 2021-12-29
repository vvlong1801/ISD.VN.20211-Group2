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
     * Represent the cvvCode of card.
     */
    private String cvvCode;
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
    public CreditCard(String cardCode, String owner, String cvvCode, String dateExpired) {
        this.cardCode = cardCode;
        this.owner = owner;
        this.cvvCode = cvvCode;
        this.dateExpired = dateExpired;
    }

    public String getCardCode() {
        return cardCode;
    }

    public void setCardCode(String cardCode) {
        this.cardCode = cardCode;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getCvvCode() {
        return cvvCode;
    }

    public void setCvvCode(String cvvCode) {
        this.cvvCode = cvvCode;
    }

    public String getDateExpired() {
        return dateExpired;
    }

    public void setDateExpired(String dateExpired) {
        this.dateExpired = dateExpired;
    }
}
