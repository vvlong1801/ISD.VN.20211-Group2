package ecobikerental.capstone_project.controller;

import java.sql.SQLException;
import java.util.List;

import ecobikerental.capstone_project.entity.dock.Dock;

public class HomeController extends BaseController {
    /**
     * this method get the list of docks.
     * @return List of docks
     *
     * @throws SQLException
     */
    public List getDockList() throws SQLException {
        return new Dock().getDockList();
    }

    /**
     * this method get info dock by id.
     * @param name - letters in name of dock
     *
     * @return dock has letters of dock name like param
     *
     * @throws SQLException
     */
    public List searchByName(final String name) throws SQLException {
        return new Dock().searchByName(name);
    }
}
