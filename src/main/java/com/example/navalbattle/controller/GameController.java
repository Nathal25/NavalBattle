package com.example.navalbattle.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;

public class GameController {

    @FXML
    private GridPane gridPlayer;

    @FXML
    private HBox hbxHead;

    @FXML
    private Label lblTitle;

    @FXML
    private Pane paneBaseA;
    @FXML
    private Pane paneBaseB;
    private StartController startController;

    public void initialize(){
        gridPlayer = new GridPane();
        startController = new StartController();
        //gridPlayer=startController.getBoardPlayer1();
    }
}
