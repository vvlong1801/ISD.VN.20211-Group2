package ecobikerental.capstone_project.dbconnnection_layer;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import ecobikerental.capstone_project.entity.payment.PaymentTransaction;

/**
 * This class controls the database transactions relate to PaymentTransaction
 */
public class PaymentTransactionDL {
    /**
     * This method saves PaymentTransaction
     * @param paymentTransaction
     */
    public static void save(PaymentTransaction paymentTransaction) {
        String sql = "insert into transaction values(?,?,?,?,?,?,?,?)";
        PreparedStatement pstmt = null;
        try {
            pstmt = DBConnector.getConnection().prepareStatement(sql);
            pstmt.setString(1, paymentTransaction.getTransactionId());
            pstmt.setString(2, paymentTransaction.getCard().getCardCode());
            pstmt.setString(3, paymentTransaction.getCard().getOwner());
            pstmt.setString(4, paymentTransaction.getCard().getDateExpired());
            pstmt.setString(5, paymentTransaction.getCommand());
            pstmt.setString(6, paymentTransaction.getTransactionContent());
            pstmt.setString(7, String.valueOf(paymentTransaction.getAmount()));
            pstmt.setString(8, paymentTransaction.getCreatedAt());
            pstmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (pstmt != null) {
                try {
                    pstmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
