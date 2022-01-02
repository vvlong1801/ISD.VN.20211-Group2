package ecobikerental.capstone_project.entity.dock;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import ecobikerental.capstone_project.dbconnnection_layer.DBConnector;

/**
 * Entity Dock
 */
public class Dock {
    /**
     * Represent for id of Dock
     */
    private int id;
    /**
     * Represent for name of Dock
     */
    private String dockName;
    /**
     * Represent for address of Dock
     */
    private String address;
    /**
     * Represent for quantity of bike
     */
    private int quantity;
    /**
     * Represent for area of Dock
     */
    private int area;

    /**
     * Constructor with 5 arguments
     *
     * @param id       the id of dock
     * @param dockName - the name of dock
     * @param address  - the address of dock
     * @param quantity - the quantity of bike
     * @param area     - the area of dock
     */
    public Dock(int id, String dockName, String address, int quantity, int area) {
        this.id = id;
        this.dockName = dockName;
        this.address = address;
        this.quantity = quantity;
        this.area = area;
    }

    /**
     * Default constructor for class Dock
     */
    public Dock() {
    }

    /**
     * Getter for id
     *
     * @return id
     */
    public int getId() {
        return id;
    }

    /**
     * Setter for id
     *
     * @param id - the id of dock
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Getter for dockName
     *
     * @return dockName
     */
    public String getDockName() {
        return dockName;
    }

    /**
     * Setter for dockName
     *
     * @param dockName - the name of dock
     */
    public void setDockName(String dockName) {
        this.dockName = dockName;
    }

    /**
     * Getter for address
     *
     * @return address
     */
    public String getAddress() {
        return address;
    }

    /**
     * Setter for address
     *
     * @param address - the address of dock
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * Getter for quantity
     *
     * @return quantity
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * Setter for quantity
     *
     * @param quantity - the quantity
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    /**
     * Getter for area
     *
     * @return area
     */
    public int getArea() {
        return area;
    }

    /**
     * Setter for area
     *
     * @param area - the area of dock
     */
    public void setArea(int area) {
        this.area = area;
    }

    /**
     * This methods gets list of docks
     *
     * @return dockList - the list of docks
     *
     * @throws SQLException - Exception relates to SQL
     */
    public List<Dock> getDockList() throws SQLException {
        List<Dock> dockList = new ArrayList<>();
        Statement stmt = DBConnector.getConnection().createStatement();
        String query = "select * from dock";
        ResultSet res = stmt.executeQuery(query);
        Dock dock;
        while(res.next()) {
            dock = new Dock(res.getInt("id"), res.getString("name"), res.getString("address"), res.getInt("quantity"),
                res.getInt("area"));
            dockList.add(dock);
        }
        return dockList;
    }

    /**
     * This method searchs dock by name
     *
     * @param name - the name of dock
     *
     * @return dockList
     *
     * @throws SQLException - Exception relates to SQL
     */
    public List getDockByName(final String name) throws SQLException {
        List dockList = new ArrayList<>();
        Statement stmt = DBConnector.getConnection().createStatement();
        String query = "select * from dock where dock_name like \'%" + name + "%\'";
        ResultSet res = stmt.executeQuery(query);
        Dock dock;
        while(res.next()) {
            dock = new Dock(res.getInt("id"), res.getString("name"), res.getString("address"), res.getInt("quantity"),
                res.getInt("area"));
            dockList.add(dock);
        }
        return dockList;
    }
}
