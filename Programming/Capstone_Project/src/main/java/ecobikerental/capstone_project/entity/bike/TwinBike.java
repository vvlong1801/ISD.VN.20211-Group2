package ecobikerental.capstone_project.entity.bike;

public class TwinBike extends Bike {

    /**
     * Constructor with 5 arguments.
     *
     * @param type         - the type of bike
     * @param bikeCode     - the code of bike
     * @param licensePlate - the license plate of bike
     * @param dockName     - the name of dock
     * @param deposit      - the deposit fee of bike
     */
    public TwinBike(String type, String bikeCode, String licensePlate, String dockName, int deposit) {
        super(type, bikeCode, licensePlate, dockName, deposit);
    }
}
