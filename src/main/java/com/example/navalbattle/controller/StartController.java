package com.example.navalbattle.controller;

import com.example.navalbattle.model.ImagesCreator;
import com.example.navalbattle.view.GameStage;
import com.example.navalbattle.view.StartStage;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.awt.event.MouseAdapter;
import java.io.IOException;

import static com.sun.java.accessibility.util.AWTEventMonitor.addMouseListener;
import static com.sun.java.accessibility.util.AWTEventMonitor.addMouseMotionListener;

/**
 * This class generates the first stage designed to put
 * the ships on the board
 * @author Nathalia Ortiz
 */

public class StartController extends Stage {
    @FXML
    private GridPane boardPlayer1;

    private ImagesCreator imagesCreator;

    public void initialize(){
        for (int i = 0; i <=9; i++){
            for (int j = 0; j <= 9; j++){
                imagesCreator = new ImagesCreator();
                boardPlayer1.add(imagesCreator.getImageView(),i,j);
            }
        }

    }

    void mouseDragged(){
        MouseAdapter mouseAdapter = new MouseAdapter() {
            int distanceX, distanceY;
            boolean moved = false;

            public void mousePressed(MouseEvent mouseEvent) {

            }

            public void mouseReleased(MouseEvent mouseEvent) {

            }

            public void mouseDragged(MouseEvent mouseEvent) {

            }
        };
        addMouseListener(mouseAdapter);
        addMouseMotionListener(mouseAdapter);
    }
    @FXML
    void onHandleButtonStartGame(ActionEvent event) throws IOException {
        GameStage.getInstance();
        StartStage.deleteInstance();
    }

}
