package com.example.navalbattle.controller;

import com.example.navalbattle.view.GameStage;
import com.example.navalbattle.view.StartStage;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.stage.Stage;

import java.io.IOException;
/**
 * This class generates the first stage designed to put
 * the ships on the board
 * @author Nathalia Ortiz
 */

public class StartController extends Stage {

    @FXML
    void onHandleButtonStartGame(ActionEvent event) throws IOException {
        GameStage.getInstance();
        StartStage.deleteInstance();
    }

}
