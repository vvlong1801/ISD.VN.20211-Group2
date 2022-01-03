package ecobikerental.capstone_project.entity.bike;

/**
 * Entity Bike
 */
public class Bike {
    private int bikeId;
    /**
     * Represent for code of Bike.
     */
    private String bikeCode;
    /**
     * Represent for type of Bike.
     */
    private String type;
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
     * Constructor with 5 arguments.
     *
     * @param bikecode
     * @param type     - the type of bike
     * @param dockName - the name of dock
     * @param deposit  - the deposit fee of bike
     */
    public Bike(String bikecode, String type, String dockName, int deposit) {
        this.bikeCode = bikecode;
        this.type = type;
        this.dockName = dockName;
        this.deposit = deposit;
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
    public String getBarcode() {
        return this.bikeCode.substring(0, 13);
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

    public String getBikeCode() {
        return bikeCode;
    }

    public void setBikeCode(String bikeCode) {
        this.bikeCode = bikeCode;
    }


    @Override
    public String toString() {
        return "Bike{" + "bikeCode='" + bikeCode + '\'' + ", barcode='" + getBarcode() + '\'' + ", type='" + type + '\'' +
            ", dockName='" + dockName + '\'' + ", deposit=" + deposit + '}';
    }

    public int getBikeId() {
        return bikeId;
    }

    public void setBikeId(int bikeId) {
        this.bikeId = bikeId;
    }
}
