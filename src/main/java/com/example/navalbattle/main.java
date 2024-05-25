package com.example.navalbattle;
/*
Paleta de COlores
191d32
fdfdff
957fef
9a031e
ba2d0b
 */
import com.example.navalbattle.model.FileCRUD;
import com.example.navalbattle.view.StartStage;
import javafx.application.Application;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * @author Nathalia Ortiz
 * @author Sara Yineth
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
