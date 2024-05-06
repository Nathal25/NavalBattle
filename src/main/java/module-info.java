module com.example.navalbattle {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.navalbattle to javafx.fxml;
    opens com.example.navalbattle.controller to javafx.fxml;
    exports com.example.navalbattle;

    /*
    opens org.example.navalbattle to javafx.fxml;
    opens org.example.navalbattle.controller to javafx.fxml;
    exports org.example.navalbattle;
     */
}