//module EcobikeRental {
//}
module com.capstone_project.ecobikerental {
        requires javafx.controls;
        requires javafx.fxml;

        requires org.controlsfx.controls;
        requires validatorfx;
        requires org.kordamp.bootstrapfx.core;

        opens com.capstone_project.ecobikerental to javafx.fxml;
        exports com.capstone_project.ecobikerental;
}