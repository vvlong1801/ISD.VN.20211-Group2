package ecobikerental.capstone_project.subsystem.interbank;

import com.google.gson.Gson;
import ecobikerental.capstone_project.entity.payment.CreditCard;
import ecobikerental.capstone_project.entity.payment.PaymentTransaction;
import ecobikerental.capstone_project.exception.InternalServerErrorException;
import ecobikerental.capstone_project.exception.InvalidCardException;
import ecobikerental.capstone_project.exception.InvalidTransactionAmountException;
import ecobikerental.capstone_project.exception.InvalidVersionException;
import ecobikerental.capstone_project.exception.NotEnoughBalanceException;
import ecobikerental.capstone_project.exception.NotEnoughTransactionInfoException;
import ecobikerental.capstone_project.exception.SuspiciousTransactionException;
import ecobikerental.capstone_project.exception.UnrecognizedException;
import ecobikerental.capstone_project.utils.Configs;

public class InterbankSubsystemController {

    /**
     * attribute interbankBoundary is used to send request.
     */
    public InterbankBoundary interbankBoundary;

    public PaymentTransaction refund(CreditCard card, int amount, String contents) {
        Transaction transaction =
            new Transaction(card.getCardCode(), card.getOwner(), card.getCvvCode(), card.getDateExpired(), "refund",
                contents, amount);
        //        Transaction transaction = new Transaction("vn_group2_2021", "Group 2",
        //            "774", "1125", "pay", "test pay", 100);
        Request request = new Request(transaction);
        System.out.println(request.makeRequestJson());
        String responseText = interbankBoundary.query(Configs.PROCESS_TRANSACTION_URL, request.makeRequestJson());
        System.out.println(responseText);
        return makePaymentTransaction(responseText);
    }

    public PaymentTransaction payDeposit(CreditCard card, int amount, String contents) {
        Transaction transaction =
            new Transaction(card.getCardCode(), card.getOwner(), card.getCvvCode(), card.getDateExpired(), "pay",
                contents, amount);
        //        Transaction transaction = new Transaction("vn_group2_2021", "Group 2",
        //            "774", "1125", "pay", "test pay", 100);
        Request request = new Request(transaction);
        System.out.println(request.makeRequestJson());
        String responseText = interbankBoundary.query(Configs.PROCESS_TRANSACTION_URL, request.makeRequestJson());
        System.out.println(responseText);
        return makePaymentTransaction(responseText);
    }

    private PaymentTransaction makePaymentTransaction(final String response) {
        if (response == null) {
            return null;
        }
        Gson gson = new Gson();
        Response responseTransaction = gson.fromJson(response, Response.class);

        PaymentTransaction paymentTransaction = responseTransaction.toPaymentTransaction();
        System.out.println(gson.toJson(paymentTransaction));
        switch (paymentTransaction.getErrorCode()) {
            case "00":
                break;
            case "01":
                throw new InvalidCardException();
            case "02":
                throw new NotEnoughBalanceException();
            case "03":
                throw new InternalServerErrorException();
            case "04":
                throw new SuspiciousTransactionException();
            case "05":
                throw new NotEnoughTransactionInfoException();
            case "06":
                throw new InvalidVersionException();
            case "07":
                throw new InvalidTransactionAmountException();
            default:
                throw new UnrecognizedException();
        }

        return paymentTransaction;
    }

    public static void main(String[] args) {
        CreditCard card = new CreditCard("vn_group2_2021", "Group 2", "774", "1125");
        InterbankSubsystemController ctrl = new InterbankSubsystemController();
        System.out.println(ctrl.payDeposit(card, 100, "test pay"));
    }
}
