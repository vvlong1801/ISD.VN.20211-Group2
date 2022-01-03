package ecobikerental.capstone_project.dbconnnection_layer;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import ecobikerental.capstone_project.dbconnnection_layer.DBConnector;
import ecobikerental.capstone_project.entity.invoice.Invoice;

/**
 * This class controls the database transactions relate to Invoice
 */
public class InvoiceDL {
    /**
     * This method saves invoice
     */
    public static void save(){
        String sql = "insert into invoice(time_rental,rental_fees,bike,pay_deposit_transaction,refund_transaction)  values(?,?,?,?,?)";
        PreparedStatement pstmt = null;
        try {
            pstmt = DBConnector.getConnection().prepareStatement(sql);
            pstmt.setString(1, Invoice.getInstance().getRentalTime());
            pstmt.setString(2, String.valueOf(Invoice.getInstance().getRentalFee()));
            pstmt.setString(3, String.valueOf(Invoice.getInstance().getBike().getBikeId()));
            pstmt.setString(4, Invoice.getInstance().getPayDepositTransaction().getTransactionId());
            pstmt.setString(5, Invoice.getInstance().getRefundTransaction().getTransactionId());
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
