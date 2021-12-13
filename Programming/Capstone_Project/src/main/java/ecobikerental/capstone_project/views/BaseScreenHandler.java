package ecobikerental.capstone_project.views;

import java.io.IOException;
import java.util.Hashtable;

import ecobikerental.capstone_project.controller.BaseController;
import ecobikerental.capstone_project.views.home.HomeScreenHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class BaseScreenHandler extends FXMLScreenHandler {
    private Scene scene;
    private BaseScreenHandler prev;
    protected final Stage stage;
    protected HomeScreenHandler homeScreenHandler;
    //    protected Hashtable<String, String> messages;
    private BaseController controller;

    private BaseScreenHandler(String screenPath) throws IOException {
        super(screenPath);
        this.stage = new Stage();
    }

    public BaseScreenHandler(Stage stage, String screenPath) throws IOException {
        super(screenPath);
        this.stage = stage;
    }

    public BaseController getController() {
        return controller;
    }

    public void setController(BaseController controller) {
        this.controller = controller;
    }

    public void setHomeScreenHandler(HomeScreenHandler homeScreenHandler) {
        this.homeScreenHandler = homeScreenHandler;
    }
    /**
     * this method set title for scene.
     * @param title
     */
    public void setScreenTitle(String title) {
        this.stage.setTitle(title);
    }

    public void show() {
        if (this.scene == null) {
            this.scene = new Scene(this.content);
        }
        this.stage.setScene(this.scene);
        this.stage.show();
    }

    public BaseScreenHandler getPrev() {
        return prev;
    }

    public void setPrev(BaseScreenHandler prev) {
        this.prev = prev;
    }
}
