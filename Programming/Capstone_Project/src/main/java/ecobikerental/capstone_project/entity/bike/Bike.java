package ecobikerental.capstone_project.entity.bike;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import ecobikerental.capstone_project.entity.db.EcobikeRentalDB;

/**
 * Entity Bike
 */
public class Bike {
    /**
     * Represent for type of Bike.
     */
    private String type;
    /**
     * Represent for code of Bike
     */
    private String bikeCode;
    /**
     * Represent for license plate of Bike
     */
    private String licensePlate;
    /**
     * Represent for deposit fee of bike.
     */
    private String dockName;

    /**
     * deposit fee of bike.
     */
    private int deposit;

    public Bike() {

    }

    /**
     * Getter for type
     *
     * @return type
     */
    public String getType() {
        return type;
    }

    /**
     * Setter for type
     *
     * @param type - the type of bike
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * Getter for bikeCode
     *
     * @return bikeCode
     */
    public String getBikeCode() {
        return bikeCode;
    }

    /**
     * Setter for bikeCode
     *
     * @param bikeCode - the code of bike
     */
    public void setBikeCode(String bikeCode) {
        this.bikeCode = bikeCode;
    }

    /**
     * Getter for licensePlate
     *
     * @return licensePlate
     */
    public String getLicensePlate() {
        return licensePlate;
    }

    /**
     * Setter for licensePlate
     *
     * @param licensePlate - the license plate of bike
     */
    public void setLicensePlate(final String licensePlate) {
        this.licensePlate = licensePlate;
    }

    /**
     * Getter for dock name.
     *
     * @return dock name
     */
    public String getDockName() {
        return dockName;
    }

    /**
     * Setter for dock name.
     *
     * @param dockName - dock name.
     */
    public void setDockName(String dockName) {
        this.dockName = dockName;
    }

    /**
     * Getter for depositFee.
     *
     * @return - deposit
     */
    public int getDeposit() {
        return deposit;
    }

    /**
     * Setter for deposit fee.
     *
     * @param deposit - deposit fee
     */
    public void setDeposit(int deposit) {
        this.deposit = deposit;
    }

    //    /**
    //     * Default constructor of class Bike
    //     */
    //    public Bike() {
    //    }

    /**
     * Constructor with 5 arguments.
     *
     * @param type         - the type of bike
     * @param bikeCode     - the code of bike
     * @param licensePlate - the license plate of bike
     * @param dockName     - the name of dock
     * @param deposit      - the deposit fee of bike
     */
    public Bike(String type, String bikeCode, String licensePlate, String dockName, int deposit) {
        this.type = type;
        this.bikeCode = bikeCode;
        this.licensePlate = licensePlate;
        this.dockName = dockName;
        this.deposit = deposit;
    }

    /**
     * This method gets bike from bikeCode.
     *
     * @param bikeCode - the code of bike
     *
     * @return Bike
     */
    public Bike getBikeByBikeCode(final String bikeCode) throws SQLException {
        Statement stmt = EcobikeRentalDB.getConnection().createStatement();
        String query =
            "select bike.code,dock.name as dock_name,bike.license_plate,type.name as type_name,type.deposit_fee from bike,type,dock where bike.code = \'" +
                bikeCode + "\' and bike.type = type.id and bike.dock = dock.id";
        ResultSet res = stmt.executeQuery(query);
        Bike bike = null;
        while(res.next()) {
            bike = new Bike(res.getString("type_name"), res.getString("code"), res.getString("license_plate"),
                res.getString("dock_name"), res.getInt("deposit_fee"));
            break;
        }
        return bike;
    }
}
