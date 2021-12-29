package ecobikerental.capstone_project.subsystem.interbank;

import ecobikerental.capstone_project.utils.Utils;

public class Transaction {
    private String cardCode;
    private String owner;
    private String cvvCode;
    private String dateExpired;
    private String command;
    private String transactionContent;
    private int amount;
    private String createdAt;

    public Transaction(String cardCode, String owner, String cvvCode, String dateExpired, String commmand,
                       String transactionContent, int amount) {
        this.cardCode = cardCode;
        this.owner = owner;
        this.cvvCode = cvvCode;
        this.dateExpired = dateExpired;
        this.command = commmand;
        this.transactionContent = transactionContent;
        this.amount = amount;
        this.createdAt = "2021-12-27 23:30:36";
    }
}
