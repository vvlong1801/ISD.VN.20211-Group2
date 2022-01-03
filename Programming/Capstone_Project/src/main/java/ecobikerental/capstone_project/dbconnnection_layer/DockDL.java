package ecobikerental.capstone_project.dbconnnection_layer;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import ecobikerental.capstone_project.entity.dock.Dock;

public class DockDL {
    private List<Dock> dockList;

    private static DockDL instance;

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

    public List<Dock> getDockList() {
        return dockList;
    }


    public List<Dock> searchDock(final String name) {
        List<Dock> list = new ArrayList<>();
        for (Dock dock : dockList) {
            if (dock.getDockName().contains(name)) {
                list.add(dock);
            }
        }
        return list;
    }

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

    public static DockDL getInstance() throws SQLException {
        if (instance == null) {
            return new DockDL();
        }
        return instance;
    }

    public int getDockId(String dockName) {
        for (Dock dock : dockList) {
            if (dock.getDockName().equals(dockName)) {
                return dock.getId();
            }
        }
        return 0;
    }
}
