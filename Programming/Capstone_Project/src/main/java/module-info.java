module ecobikerental.capstone_project {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires validatorfx;
    requires org.kordamp.bootstrapfx.core;
    requires java.sql;

    opens ecobikerental.capstone_project to javafx.fxml;
    exports ecobikerental.capstone_project;
    exports ecobikerental.capstone_project.views;
    opens ecobikerental.capstone_project.views to javafx.fxml;
    exports ecobikerental.capstone_project.views.home;
    opens ecobikerental.capstone_project.views.home to javafx.fxml;
    opens ecobikerental.capstone_project.entity.dock to javafx.base;
    exports ecobikerental.capstone_project.views.dock;
    exports ecobikerental.capstone_project.views.bike;
    exports ecobikerental.capstone_project.views.paydeposit;
}