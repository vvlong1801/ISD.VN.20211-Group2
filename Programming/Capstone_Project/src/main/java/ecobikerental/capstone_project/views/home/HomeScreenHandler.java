package ecobikerental.capstone_project.views.home;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;

import ecobikerental.capstone_project.controller.ViewDockController;
import ecobikerental.capstone_project.entity.dock.Dock;
import ecobikerental.capstone_project.utils.Configs;
import ecobikerental.capstone_project.views.BaseScreenHandler;
import ecobikerental.capstone_project.views.dock.DockInfoScreenHandler;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class HomeScreenHandler extends BaseScreenHandler implements Initializable {

    /**
     * combobox is used to sort data in table.
     */
    @FXML
    public ChoiceBox cbSort;
    /**
     * image logo.
     */
    @FXML
    public ImageView imgLogo;
    /**
     * text field input data to search.
     */
    @FXML
    public TextField tfSearch;
    /**
     * button search.
     */
    @FXML
    public Button btnSearch;
    /**
     * table view list of dock.
     */
    @FXML
    public TableView<Dock> tvDockList;
    /**
     * column Id in table.
     */
    @FXML
    public TableColumn<Dock, Integer> colId;
    /**
     * column Dock Name in table.
     */
    @FXML
    public TableColumn<Dock, String> colDockName;
    /**
     * column Address in table.
     */
    @FXML
    public TableColumn<Dock, String> colAddress;
    /**
     * column Area in table.
     */
    @FXML
    public TableColumn<Dock, Integer> colArea;
    /**
     * column Quantity in table.
     */
    @FXML
    public TableColumn<Dock, Integer> colQuantity;

    /**
     * @param stage      - this stage
     * @param screenPath - path of home screen in config
     *
     * @throws IOException
     */
    public HomeScreenHandler(Stage stage, String screenPath) throws IOException {
        super(stage, screenPath);
    }

    /**
     * @return - HomeController is controller of HomeScreen
     */
    public ViewDockController getController() {
        return (ViewDockController) super.getController();
    }

    /**
     * @param url            -
     * @param resourceBundle -
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        setController(new ViewDockController());
        setImage(imgLogo, Configs.LOGO_IMG_PATH);

        try {
            insertTable(this.getController().getDockList());
        } catch (SQLException e) {
            e.printStackTrace();
        }

        imgLogo.setOnMouseClicked(mouseEvent -> {
            System.out.println("click logo");
            try {
                this.getHomeScreenHandler().show();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        btnSearch.setOnAction(event -> {
            System.out.println("clicked");
            String name = tfSearch.getText();
            try {
                insertTable(getController().searchDock(name));
            } catch (SQLException e) {
                e.printStackTrace();
            }
        });

        // change Dock Info Screen if double click on row of table
        tvDockList.setRowFactory(tv -> {
            TableRow<Dock> row = new TableRow<>();
            row.setOnMouseClicked(event -> {
                if (event.getClickCount() == 2 && (!row.isEmpty())) {
                    Dock rowData = row.getItem();
                    System.out.println("Double click on: " + rowData.getDockName());
                    DockInfoScreenHandler dockInfoScreenHandler;
                    try {
                        dockInfoScreenHandler = new DockInfoScreenHandler(this.stage, Configs.DOCK_INFO_SCREEN_PATH, rowData);
                        dockInfoScreenHandler.setNumberOfBike(this.getController().getNumberOfBike(rowData.getDockName()));
                        dockInfoScreenHandler.setInfo();
                        dockInfoScreenHandler.setPrev(this);
                        dockInfoScreenHandler.setScreenTitle("Dock Information");
                        dockInfoScreenHandler.show();
                    } catch (IOException | SQLException e) {
                        e.printStackTrace();
                    }
                }
            });
            return row;
        });
    }

    /**
     * this method insert data into table.
     *
     * @param listDock - list of dock in database
     */
    private void insertTable(final List listDock) {
        ObservableList<Dock> list = FXCollections.observableArrayList(listDock);
        colId.setCellValueFactory(new PropertyValueFactory<Dock, Integer>("id"));
        colDockName.setCellValueFactory(new PropertyValueFactory<Dock, String>("dockName"));
        colAddress.setCellValueFactory(new PropertyValueFactory<Dock, String>("address"));
        colArea.setCellValueFactory(new PropertyValueFactory<Dock, Integer>("area"));
        colQuantity.setCellValueFactory(new PropertyValueFactory<Dock, Integer>("quantity"));
        tvDockList.setItems(list);
    }

//    public static void main(String[] args) {
//        String barcode = "1234567890098";
//        System.out.println(Utils.md5(barcode));
//    }
}
