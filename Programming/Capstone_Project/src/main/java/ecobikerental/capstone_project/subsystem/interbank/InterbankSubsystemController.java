package ecobikerental.capstone_project.subsystem.interbank;

import java.util.Map;

import ecobikerental.capstone_project.entity.payment.CreditCard;
import ecobikerental.capstone_project.entity.payment.PaymentTransaction;
import ecobikerental.capstone_project.exception.InvalidCardException;
import ecobikerental.capstone_project.exception.InvalidTransactionAmountException;
import ecobikerental.capstone_project.exception.InvalidVersionException;
import ecobikerental.capstone_project.exception.NotEnoughBalanceException;
import ecobikerental.capstone_project.exception.NotEnoughTransactionInfoException;
import ecobikerental.capstone_project.exception.SuspiciousTransactionException;
import ecobikerental.capstone_project.exception.UnrecognizedException;
import ecobikerental.capstone_project.exception.InternalServerErrorException;
import ecobikerental.capstone_project.utils.Configs;
import ecobikerental.capstone_project.utils.MyMap;
import ecobikerental.capstone_project.utils.Utils;

public class InterbankSubsystemController {
    private static final String PUBLIC_KEY = "AQzdE8O/fR8=";
    private static final String SECRET_KEY = "BLRqOL6OIrI=";
    private static final String PAY_COMMAND = "pay";
    private static final String VERSION = "1.0.0";

    private static InterbankBoundary interbankBoundary = new InterbankBoundary();

    public PaymentTransaction refund(CreditCard card, int amount, String contents) {
        return null;
    }

    private String generateData(Map<String, Object> data) {
        return ((MyMap) data).toJSON();
    }

    public PaymentTransaction payDeposit(CreditCard card, int amount, String contents) {
        Map<String, Object> transaction = new MyMap();

        try {
            transaction.putAll(MyMap.toMyMap(card));
        } catch (IllegalArgumentException | IllegalAccessException e) {
            // TODO Auto-generated catch block
            throw new InvalidCardException();
        }
        transaction.put("command", PAY_COMMAND);
        transaction.put("transactionContent", contents);
        transaction.put("amount", amount);
        transaction.put("createdAt", Utils.getToday());

        Map<String, Object> requestMap = new MyMap();
        requestMap.put("version", VERSION);
        requestMap.put("transaction", transaction);

        String responseText = interbankBoundary.query(Configs.PROCESS_TRANSACTION_URL, generateData(requestMap));
        MyMap response = null;
        try {
            response = MyMap.toMyMap(responseText, 0);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            throw new UnrecognizedException();
        }

        return makePaymentTransaction(response);
    }

    private PaymentTransaction makePaymentTransaction(MyMap response) {
        if (response == null) {
            return null;
        }
        MyMap transaction = (MyMap) response.get("transaction");

        CreditCard card = new CreditCard((String) transaction.get("cardCode"), (String) transaction.get("owner"),
            Integer.parseInt((String) transaction.get("cvvCode")), (String) transaction.get("dateExpired"));

        PaymentTransaction trans =
            new PaymentTransaction((String) response.get("errorCode"), card, (String) transaction.get("transactionId"),
                (String) transaction.get("transactionContent"), Integer.parseInt((String) transaction.get("amount")),
                (String) transaction.get("createdAt"));

        switch(trans.getErrorCode()) {
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

        return trans;
    }
}
