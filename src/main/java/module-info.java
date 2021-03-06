module itvitae.strategogui {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;

    opens itvitae.strategogui to javafx.fxml;
    exports itvitae.strategogui;
    exports controller;
    opens controller to javafx.fxml;
}