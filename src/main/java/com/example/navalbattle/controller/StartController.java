package com.example.navalbattle.controller;

import com.example.navalbattle.model.DraggableMaker;
import com.example.navalbattle.model.ImagesCreator;
import com.example.navalbattle.view.GameStage;
import com.example.navalbattle.view.StartStage;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * This class generates the first stage designed to put
 * the ships on the board
 * @author Nathalia Ortiz
 */

public class StartController extends Stage {
    @FXML
    private GridPane boardPlayer1;

    @FXML
    private Button btnStart;

    @FXML
    private HBox hbxHead;

    @FXML
    private Label lblTitle;

    @FXML
    private Rectangle shpSQ;

    DraggableMaker draggableMaker = new DraggableMaker();

    private ImagesCreator imagesCreator;

    public void initialize(){
        for (int i = 0; i <=9; i++){
            for (int j = 0; j <= 9; j++){
                imagesCreator = new ImagesCreator();
                boardPlayer1.add(imagesCreator.getImageView(),i,j);
            }
        }
        draggableMaker.makeDraggable(shpSQ);

        /*
        shpSQ.setOnMouseReleased(event -> {
            // Calcular la celda del GridPane
            int colIndex = (int) (event.getSceneX() / (gridPane.getWidth() / GridPane.getColumnIndex(shpSQ)));
            int rowIndex = (int) (event.getSceneY() / (gridPane.getHeight() / GridPane.getRowIndex(shpSQ)));

            // Colocar el rectángulo en la celda del GridPane
            GridPane.setConstraints(shpSQ, colIndex, rowIndex);
        });
         */
    }
    @FXML
    void onHandleButtonStartGame(ActionEvent event) throws IOException {
        GameStage.getInstance();
        StartStage.deleteInstance();
    }

    public GridPane getBoardPlayer1() {
        return boardPlayer1;
    }
}
