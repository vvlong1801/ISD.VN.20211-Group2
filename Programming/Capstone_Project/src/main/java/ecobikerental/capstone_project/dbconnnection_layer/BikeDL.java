package ecobikerental.capstone_project.dbconnnection_layer;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import ecobikerental.capstone_project.entity.bike.Bike;
import ecobikerental.capstone_project.entity.bike.BikeFactory;
import ecobikerental.capstone_project.entity.bike.ElectricBike;

/**
 * This class controls the database transactions relate to Bike
 */
public class BikeDL {
    /**
     * Represent the list of bike
     */
    private List<Bike> bikeList;

    /**
     * Constructor for BikeDL
     * @throws SQLException - Exceptions relate to SQL
     */
    public BikeDL() throws SQLException {
        this.bikeList = new ArrayList<>();
        String sql =
            "select bike.id as id, code, type.name as type, dock.name as dock_name, deposit_fee from bike, dock, type where bike.dock = dock.id and bike.type = type.id";
        ResultSet res = DBConnector.query(sql);
        Bike bike;
        while (res.next()) {
            bike = new BikeFactory().getBike(res.getString("type"));
            bike.setBikeId(res.getInt("id"));
            bike.setBikeCode(res.getString("code"));
            bike.setType(res.getString("type"));
            bike.setDockName(res.getString("dock_name"));
            bike.setDeposit(res.getInt("deposit_fee"));
            bikeList.add(bike);
//            System.out.println(bike.toString());
        }
    }

    /**
     * This method counts total of bikes in dock
     * @param dockName - name of dock
     * @return num - number of bikes
     * @throws SQLException - Exceptions relate to SQL
     */
    public static int countBikeInDock(String dockName) throws SQLException {
        int num = 0;
        String sql =
            "select count(bike.id) as num from bike,dock where bike.dock = dock.id and dock.name = \'" + dockName +
                "\'";
        ResultSet res = DBConnector.query(sql);
        if (res.next()) {
            num = res.getInt("num");
        }
        return num;
    }

    /**
     * This method gets bike information from bike code
     * @param bikeCode - the bike code
     * @param dockName - the name of dock
     * @return result - Bike
     * @throws SQLException - Exceptions relate to SQL
     */
    public Bike getBikeByBikeCode(String bikeCode, String dockName) throws SQLException {
        Bike result = null;
        for (Bike bike : bikeList) {
            if (bike.getBikeCode().equals(bikeCode) && bike.getDockName().equals(dockName)) {
                result = bike;
                break;
            }
        }
        if (result != null && result.getType().equals("Standard e-bike")) {
            ElectricBike eBike = (ElectricBike) result;
            String sql = "select ebike.* from bike,ebike where bike.id = ebike.id and bike.id = " + result.getBikeId();
            ResultSet res = DBConnector.query(sql);
            if (res.next()) {
                eBike.setPin(res.getInt("pin_status"));
                eBike.setLicensePlate(res.getString("license_Plate"));
            }
            return eBike;
        }
        return result;
    }

    /**
     * This method updates 'dock' in Bike database when user rent/return a bike
     * @param bikeCode - the bike code
     * @param dockName - the name of dock
     * @throws SQLException - Exceptions relate to SQL
     */
    public void updateBike(String bikeCode, String dockName) throws SQLException {
        int dockId = 0;
        if (dockName != null) {
            dockId = DockDL.getInstance().getDockId(dockName);
            if (dockId == 0) {
                throw new SQLException();
            }
        }
        String sql = "UPDATE bike SET dock = ? WHERE code = ?";
        PreparedStatement pstmt = null;
        try {
            pstmt = DBConnector.getConnection().prepareStatement(sql);
            if (dockName != null) {
                pstmt.setString(1, String.valueOf(dockId));
            } else {
                pstmt.setString(1, null);
            }

            pstmt.setString(2, bikeCode);
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

//    private void seeder() throws SQLException {
//        Random random = new Random();
//        String sql = "update bike set code = ?, barcode = ? where id = ?";
//        PreparedStatement stmt = DBConnector.getConnection().prepareStatement(sql);
//        for (int i = 1; i < 51; i++) {
//            int num1 = (int) (random.nextDouble() * 100000);
//            int num2 = (int) (random.nextDouble() * 100000);
//            int num3 = (int) (random.nextDouble() * 1000);
//            while (String.valueOf(num1).length() < 5) {
//                num1 = num1 * 10;
//            }
//            while (String.valueOf(num2).length() < 5) {
//                num2 = num2 * 10;
//            }
//            while (String.valueOf(num3).length() < 3) {
//                num3 = num3 * 10;
//            }
//            String barcode = "" + num1 + num2 + num3;
//            String bikecode = barcode + "123456" + barcode;
//            System.out.println(bikecode);
//            stmt.setString(1, bikecode);
//            stmt.setString(2, barcode);
//            stmt.setString(3, String.valueOf(i));
//            stmt.execute();
//        }
//    }

//    public static void main(String[] args) throws SQLException {
//        //        BikeDL.getInstance().seeder();
////        System.out.println(BikeDL.countBikeInDock("Bach Khoa"));
//        Bike bike = new BikeDL().getBikeByBikeCode("54306206155401234565430620615540", "Bach Khoa");
//        System.out.println(bike.toString());
////        ElectricBike eBike =
////            (ElectricBike) bike;
////        System.out.println(eBike.toString());
//    }
}
