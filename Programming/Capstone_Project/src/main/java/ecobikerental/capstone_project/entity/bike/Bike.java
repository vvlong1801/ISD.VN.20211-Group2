package ecobikerental.capstone_project.entity.bike;

public class Bike {
    private int id;
    private int type;
    private String bikeCode;
    private String licensePlate;
    private int depositFee;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getBikeCode() {
        return bikeCode;
    }

    public void setBikeCode(String bikeCode) {
        this.bikeCode = bikeCode;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public int getDepositFee() {
        return depositFee;
    }

    public void setDepositFee(int depositFee) {
        this.depositFee = depositFee;
    }

    public Bike(){};
    public Bike(int type, String bikeCode, String licensePlate, int depositFee) {
        this.type = type;
        this.bikeCode = bikeCode;
        this.licensePlate = licensePlate;
        this.depositFee = depositFee;
    }

    public Bike(int id, int type, String bikeCode, String licensePlate, int depositFee) {
        this.id = id;
        this.type = type;
        this.bikeCode = bikeCode;
        this.licensePlate = licensePlate;
        this.depositFee = depositFee;
    }

    public Bike getBikeByBikeCode(String bikeCode){
        return new Bike();
    }
}
