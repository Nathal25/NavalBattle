module com.example.navalbattle {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;
    requires jdk.accessibility;


    opens com.example.navalbattle to javafx.fxml;
    opens com.example.navalbattle.controller to javafx.fxml;
    exports com.example.navalbattle;
    exports com.example.navalbattle.model;
    opens com.example.navalbattle.model to javafx.fxml;

}