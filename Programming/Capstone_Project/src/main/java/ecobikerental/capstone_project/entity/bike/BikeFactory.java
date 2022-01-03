package ecobikerental.capstone_project.entity.bike;

public class BikeFactory {
    public Bike getBike(String type) {
        if (type.equals("Standard bike") || type.equals("Twin bike")) {
            return new Bike();
        } else if (type.equals("Standard e-bike")) {
            return new ElectricBike();
        }
        return null;
    }
}
