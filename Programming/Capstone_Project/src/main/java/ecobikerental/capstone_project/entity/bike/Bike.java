package ecobikerental.capstone_project.entity.bike;

/**
 * Entity Bike
 */
public class Bike {
    /**
     * Represent for id of Bike
     */
    private int id;
    /**
     * Represent for type of Bike
     */
    private int type;
    /**
     * Represent for code of Bike
     */
    private String bikeCode;
    /**
     * Represent for license plate of Bike
     */
    private String licensePlate;
    /**
     * Represent for deposit fee of bike
     */
    private int depositFee;

    /**
     * Getter for id
     * @return id
     */
    public int getId() {
        return id;
    }

    /**
     * Setter for id
     * @param id - the id of bike
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Getter for type
     * @return type
     */
    public int getType() {
        return type;
    }

    /**
     * Setter for type
     * @param type - the type of bike
     */
    public void setType(int type) {
        this.type = type;
    }

    /**
     * Getter for bikeCode
     * @return bikeCode
     */
    public String getBikeCode() {
        return bikeCode;
    }

    /**
     * Setter for bikeCode
     * @param bikeCode - the code of bike
     */
    public void setBikeCode(String bikeCode) {
        this.bikeCode = bikeCode;
    }

    /**
     * Getter for licensePlate
     * @return licensePlate
     */
    public String getLicensePlate() {
        return licensePlate;
    }

    /**
     * Setter for licensePlate
     * @param licensePlate - the license plate of bike
     */
    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    /**
     * Getter for depositFee
     * @return depositFee
     */
    public int getDepositFee() {
        return depositFee;
    }

    /**
     * Setter for depositFee
     * @param depositFee the deposit fee of bike
     */
    public void setDepositFee(int depositFee) {
        this.depositFee = depositFee;
    }

    /**
     * Default constructor of class Bike
     */
    public Bike(){};

    /**
     * Constructor with 4 arguments
     * @param type - the type of bike
     * @param bikeCode - the code of bike
     * @param licensePlate - the license plate of bike
     * @param depositFee - the deposit fee of bike
     */
    public Bike(int type, String bikeCode, String licensePlate, int depositFee) {
        this.type = type;
        this.bikeCode = bikeCode;
        this.licensePlate = licensePlate;
        this.depositFee = depositFee;
    }

    /**
     * Constructor with 5 arguments
     * @param id - the id of bike
     * @param type - the type of bike
     * @param bikeCode - the code of bike
     * @param licensePlate - the license plate of bike
     * @param depositFee - the deposit plate of bike
     */
    public Bike(int id, int type, String bikeCode, String licensePlate, int depositFee) {
        this.id = id;
        this.type = type;
        this.bikeCode = bikeCode;
        this.licensePlate = licensePlate;
        this.depositFee = depositFee;
    }

    /**
     * This method gets bike from bikeCode
     * @param bikeCode - the code of bike
     * @return Bike
     */
    public Bike getBikeByBikeCode(String bikeCode){
        return new Bike();
    }
}
