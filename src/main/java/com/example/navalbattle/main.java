package com.example.navalbattle;

import com.example.navalbattle.model.FileCRUD;
import com.example.navalbattle.view.StartStage;
import javafx.application.Application;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * @author Nathalia Ortiz
 * @author Sara Yineth
 * @author JuanPablo Arce Bueno
 */
public class main extends Application {

    public static void main(String[] args) {
        FileCRUD fileCRUD = new FileCRUD("data.txt");
        fileCRUD.createFile("");
        launch(args);
    }

    @Override
    public void start(Stage stage) throws IOException {
        StartStage.getInstance();
    }

}
