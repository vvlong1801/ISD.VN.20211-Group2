package ecobikerental.capstone_project.entity.dock;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import ecobikerental.capstone_project.entity.db.EcobikeRentalDB;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Dock {
    private int id;
    private String dockName;
    private String address;
    private int quantity;
    private int area;

    public Dock(int id, String dockName, String address, int quantity, int area) {
        this.id = id;
        this.dockName = dockName;
        this.address = address;
        this.quantity = quantity;
        this.area = area;
    }

    public Dock() {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDockName() {
        return dockName;
    }

    public void setDockName(String dockName) {
        this.dockName = dockName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getArea() {
        return area;
    }

    public void setArea(int area) {
        this.area = area;
    }

    public List getDockList() throws SQLException {
        List dockList = new ArrayList<>();
        Statement stmt = EcobikeRentalDB.getConnection().createStatement();
        String query = "select * from dock";
        ResultSet res =stmt.executeQuery(query);
        Dock dock;
        while(res.next()){
                dock = new Dock(res.getInt("dockId"),res.getString("dock_name"),
                res.getString("address"),res.getInt("quantity"),res.getInt("area"));
            dockList.add(dock);
        }
        return dockList;
    }

    public List searchByName(String name) throws SQLException {
        List dockList = new ArrayList<>();
        Statement stmt = EcobikeRentalDB.getConnection().createStatement();
        String query = "select * from dock where dock_name like \'%"+name+"%\'";
        ResultSet res =stmt.executeQuery(query);
        Dock dock;
        while(res.next()){
            dock = new Dock(res.getInt("dockId"),res.getString("dock_name"),
                res.getString("address"),res.getInt("quantity"),res.getInt("area"));
            dockList.add(dock);
        }
        return dockList;
    }
}
