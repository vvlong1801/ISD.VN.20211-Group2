package ecobikerental.capstone_project.views;

import java.io.IOException;
import java.util.Hashtable;

import ecobikerental.capstone_project.controller.BaseController;
import ecobikerental.capstone_project.views.home.HomeScreenHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class BaseScreenHandler extends FXMLScreenHandler {
    /**
     * scene of screen.
     */
    private Scene scene;
    /**
     * previous screen.
     */
    private BaseScreenHandler prev;
    /**
     * stage that scene show.
     */
    protected final Stage stage;
    /**
     * call homePage.
     */
    private HomeScreenHandler homeScreenHandler;
    /**
     * controller of screen.
     */
    //    protected Hashtable<String, String> messages;
    private BaseController controller;

    /**
     * This method is constructor with new stage.
     *
     * @param screenPath -
     *
     * @throws IOException
     */
    private BaseScreenHandler(String screenPath) throws IOException {
        super(screenPath);
        this.stage = new Stage();
    }

    /**
     * This method is constructor with current stage.
     *
     * @param stage      -
     * @param screenPath -
     *
     * @throws IOException
     */
    public BaseScreenHandler(Stage stage, String screenPath) throws IOException {
        super(screenPath);
        this.stage = stage;
    }

    /**
     * This method get controller of screen.
     *
     * @return controller of screen
     */
    public BaseController getController() {
        return controller;
    }

    /**
     * @param controller -
     */
    public void setController(BaseController controller) {
        this.controller = controller;
    }

    /**
     * this method set HomeScreenHandler for app.
     *
     * @param homeScreenHandler -
     */
    public void setHomeScreenHandler(HomeScreenHandler homeScreenHandler) {
        this.homeScreenHandler = homeScreenHandler;
    }

    /**
     * this method set title for scene.
     *
     * @param title
     */
    public void setScreenTitle(String title) {
        this.stage.setTitle(title);
    }

    /**
     * this method is used to show screen.
     */
    public void show() {
        if (this.scene == null) {
            this.scene = new Scene(this.content);
        }
        this.stage.setScene(this.scene);
        this.stage.show();
    }

    /**
     * @return previous screen
     */
    public BaseScreenHandler getPrev() {
        return prev;
    }

    /**
     * @param prev - previous screen
     */
    public void setPrev(final BaseScreenHandler prev) {
        this.prev = prev;
    }

    public HomeScreenHandler getHomeScreenHandler() {
        return homeScreenHandler;
    }
}
