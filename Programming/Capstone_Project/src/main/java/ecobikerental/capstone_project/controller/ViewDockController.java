package ecobikerental.capstone_project.controller;

import java.sql.SQLException;
import java.util.List;

import ecobikerental.capstone_project.dbconnnection_layer.BikeDL;
import ecobikerental.capstone_project.dbconnnection_layer.DockDL;
import ecobikerental.capstone_project.entity.dock.Dock;

public class ViewDockController extends BaseController {
    /**
     * this method get the list of docks.
     *
     * @return List of docks
     *
     * @throws SQLException
     */
    public List<Dock> getDockList() throws SQLException {
        return DockDL.getInstance().getDockList();
    }

    /**
     * this method get info dock by id.
     *
     * @param name - letters in name of dock
     *
     * @return dock has letters of dock name like param
     *
     * @throws SQLException
     */
    public List searchDock(final String name) throws SQLException {
        return DockDL.getInstance().searchDock(name);
    }

    public int getNumberOfBike(String dockName) throws SQLException {
        return BikeDL.countBikeInDock(dockName);
    }
}
