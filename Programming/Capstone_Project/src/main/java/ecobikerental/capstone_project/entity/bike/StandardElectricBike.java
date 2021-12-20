package ecobikerental.capstone_project.entity.bike;

public class StandardElectricBike extends Bike {
    private int pin;

    public StandardElectricBike(String type, String bikeCode, String licensePlate, String dockName, int deposit,
                                int pin) {
        super(type, bikeCode, licensePlate, dockName, deposit);
        this.pin = pin;
    }
}
