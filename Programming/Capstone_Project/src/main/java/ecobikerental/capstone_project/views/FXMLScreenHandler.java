package ecobikerental.capstone_project.views;

import java.io.File;
import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

public class FXMLScreenHandler {
    /**
     * this attribute is used to get scene.
     */
    protected FXMLLoader loader;
    /**
     * this attribute is used save loader.load().
     */
    protected AnchorPane content;

    /**
     * this method is constructor.
     *
     * @param screenPath -
     *
     * @throws IOException
     */
    public FXMLScreenHandler(String screenPath) throws IOException {
        this.loader = new FXMLLoader(getClass().getResource(screenPath));
        // Set this class as the controller
        this.loader.setController(this);
        this.content = loader.load();
    }

    /**
     * @return FXMLLoader
     */
    public FXMLLoader getLoader() {
        return loader;
    }

    /**
     * @param loader - FXMLLoader
     */
    public void setLoader(FXMLLoader loader) {
        this.loader = loader;
    }

    /**
     * @return - screen (default AnchorPane)
     */
    public AnchorPane getContent() {
        return content;
    }

    /**
     * @param content - screen (default AnchorPane)
     */
    public void setContent(AnchorPane content) {
        this.content = content;
    }

    /**
     * @param imv  - image is used to set on Image View
     * @param path - path of image in configs
     */
    public void setImage(ImageView imv, String path) {
        File file = new File(path);
        Image img = new Image(file.toURI().toString());
        imv.setImage(img);
    }
}
