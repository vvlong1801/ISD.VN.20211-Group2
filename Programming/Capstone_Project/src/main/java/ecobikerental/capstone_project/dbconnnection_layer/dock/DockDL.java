package ecobikerental.capstone_project.dbconnnection_layer.dock;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import ecobikerental.capstone_project.dbconnnection_layer.DBConnector;
import ecobikerental.capstone_project.dbconnnection_layer.bike.BikeDL;
import ecobikerental.capstone_project.entity.dock.Dock;

/**
 * This class controls the database transactions relate to Dock
 */
public class DockDL {
    /**
     * Represent the list of docks
     */
    private List<Dock> dockList;

    /**
     * Represent the instance of dock
     */
    private static DockDL instance;

    /**
     * Constructor for DockDL
     * @throws SQLException - Exceptions relate to SQL
     */
    private DockDL() throws SQLException {
        this.dockList = new ArrayList<>();
        Statement stmt = DBConnector.getConnection().createStatement();
        String query = "select * from dock";
        ResultSet res = stmt.executeQuery(query);
        Dock dock;
        while (res.next()) {
            dock = new Dock(res.getInt("id"), res.getString("name"), res.getString("address"), res.getInt("quantity"),
                res.getInt("area"));
            dockList.add(dock);
        }
    }

    /**
     * This method gets list of docks
     * @return dockList - the list of docks
     */
    public List<Dock> getDockList() {
        return dockList;
    }


    /**
     * This method is creating for searching dock
     * @param name - the name of dock that user want to search
     * @return list - list of dock(s) after searching
     */
    public List<Dock> searchDock(final String name) {
        List<Dock> list = new ArrayList<>();
        for (Dock dock : dockList) {
            if (dock.getDockName().contains(name)) {
                list.add(dock);
            }
        }
        return list;
    }

    /**
     * This method checks the availability of dock
     * @param dockName - the name of dock
     * @return true if the dock is valid, false if not
     * @throws SQLException - Exceptions relate to SQL
     */
    public boolean checkDockAvailable(final String dockName) throws SQLException {
        int quantity = 0;
        for (Dock dock : dockList) {
            if (dock.getDockName().equals(dockName)) {
                quantity = dock.getQuantity();
                break;
            }
        }
        if ( BikeDL.countBikeInDock(dockName) < quantity) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * This method gets instance of DockDL
     * @return instance - the instance of DockDL
     * @throws SQLException - Exceptions relate to SQL
     */
    public static DockDL getInstance() throws SQLException {
        if (instance == null) {
            return new DockDL();
        }
        return instance;
    }

    /**
     * This method gets id of dock
     * @param dockName - the name of dock
     * @return id - the id of dock or 0
     */
    public int getDockId(String dockName) {
        for (Dock dock : dockList) {
            if (dock.getDockName().equals(dockName)) {
                return dock.getId();
            }
        }
        return 0;
    }
}
