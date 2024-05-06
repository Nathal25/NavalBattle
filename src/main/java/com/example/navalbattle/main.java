package com.example.navalbattle;

import com.example.navalbattle.view.StartStage;
import javafx.application.Application;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * @author Nathalia Ortiz
 */
public class main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws IOException {
        StartStage.getInstance();
    }
}
