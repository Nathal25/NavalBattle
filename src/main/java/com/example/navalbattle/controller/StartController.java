package com.example.navalbattle.controller;

import com.example.navalbattle.model.DraggableMaker;
import com.example.navalbattle.model.FiguresCreator;
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

    FiguresCreator figuresCreator;

    public void initialize(){
        for (int i = 0; i <=9; i++){
            for (int j = 0; j <= 9; j++){
                String id=Integer.toString(i).concat(Integer.toString(j));
                figuresCreator=new FiguresCreator();
                figuresCreator.setId(Integer.parseInt(id));
                boardPlayer1.add(figuresCreator.getRectangle(),i,j);
            }
        }
        draggableMaker.makeDraggable(shpSQ);//shpSQ es la figura que tengo en el scene
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
