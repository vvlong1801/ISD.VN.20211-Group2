package ecobikerental.capstone_project.entity.bike;

public class ElectricBike extends Bike {
    private String licensePlate;
    private int pin;

    public ElectricBike() {
    }

    public ElectricBike(String bikecode, String type, String dockName, int deposit, String licensePlate,
                        int pin) {
        super(bikecode, type, dockName, deposit);
        this.licensePlate = licensePlate;
        this.pin = pin;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public int getPin() {
        return pin;
    }

    public void setPin(int pin) {
        this.pin = pin;
    }

    @Override
    public String toString() {
        return "EBike{" + "licensePlate='" + licensePlate + '\'' + ", pin=" + pin + '}';
    }

    public static void main(String[] args) {
        Bike bike = new ElectricBike("0987654321", "type 1", "dock", 20, "abcyxz", 80);
        System.out.println(bike.toString());
        System.out.println(((ElectricBike) bike).getPin());
    }
}
