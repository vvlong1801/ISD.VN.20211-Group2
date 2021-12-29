package ecobikerental.capstone_project.entity.bike;

import java.util.List;

public interface BikeDAO {

    public List<Bike> getAllBikes();
    public Bike getBikeById(int id);
    public void addBike(Bike bike);
    public void updateBike(Bike bike);
    public void deleteBike(Bike bike);

}
