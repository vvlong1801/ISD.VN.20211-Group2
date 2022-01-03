package ecobikerental.capstone_project.controller;

import java.sql.SQLException;
import java.util.List;

import ecobikerental.capstone_project.dbconnnection_layer.BikeDL;
import ecobikerental.capstone_project.dbconnnection_layer.DockDL;
import ecobikerental.capstone_project.entity.dock.Dock;

<<<<<<< HEAD:Programming/Capstone_Project/src/main/java/ecobikerental/capstone_project/controller/ViewDockController.java
/**
 * This class controls the flow of events when users view the Dock
 */
=======
>>>>>>> 55626055c6ceeed428edac9b3852e838a0e9a337:Programming/Capstone_Project/src/main/java/ecobikerental/capstone_project/controller/HomeController.java
public class ViewDockController extends BaseController {
    /**
     * This method get the list of docks
     * @return List of docks
     * @throws SQLException - Exceptions relate to SQL
     */
    public List<Dock> getDockList() throws SQLException {
        return DockDL.getInstance().getDockList();
    }

    /**
     * This method get info dock by id
     * @param name - letters in name of dock
     * @return dock has letters of dock name like param
     * @throws SQLException - Exceptions relate to SQL
     */
    public List searchDock(final String name) throws SQLException {
        return DockDL.getInstance().searchDock(name);
    }

    /**
     * This method gets number of bikes in a dock
     * @param dockName - name of dock
     * @return number of bikes in dock
     * @throws SQLException - Exceptions relate to SQL
     */
    public int getNumberOfBike(String dockName) throws SQLException {
        return BikeDL.countBikeInDock(dockName);
    }
}
