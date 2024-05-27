package com.example.navalbattle.controller;

import com.example.navalbattle.model.*;
import com.example.navalbattle.view.GameStage;
import com.example.navalbattle.view.StartStage;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
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
    private Pane basicPane;

    @FXML
    private Button btnStart;

    @FXML
    private Pane gameBoard;

    @FXML
    private HBox hbxHead;

    @FXML
    private Label lblTitle;


    private DraggableMaker draggableMaker = new DraggableMaker();
    private SubmarinosCreator submarino1,submarino2;
    private DestructoresCreator destructores1,destructores2;
    private PortaAvionesCreator portaAvion;
    private FiguresCreator base;
    private FragatasCreator fragata1,fragata2,fragata3,fragata4;


    public void initialize(){
        destructores1=new DestructoresCreator();
        destructores1.setLayoutX(570);
        destructores1.setLayoutY(250);

        destructores2=new DestructoresCreator();
        destructores2.setLayoutX(525);
        destructores2.setLayoutY(250);

        portaAvion = new PortaAvionesCreator();
        portaAvion.setLayoutx(450);
        portaAvion.setLayouty(85);

        submarino1 = new SubmarinosCreator();
        submarino1.setLayoutX(487);
        submarino1.setLayoutY(85);

        submarino2 = new SubmarinosCreator();
        submarino2.setLayoutX(487);
        submarino2.setLayoutY(200);

        base = new FiguresCreator();

        fragata1 = new FragatasCreator();
        fragata1.setLayoutX(525);
        fragata1.setLayoutY(85);
        fragata2 = new FragatasCreator();
        fragata2.setLayoutX(560);
        fragata2.setLayoutY(85);
        fragata3 = new FragatasCreator();
        fragata3.setLayoutX(594);
        fragata3.setLayoutY(85);
        fragata4 = new FragatasCreator();
        fragata4.setLayoutX(628);
        fragata4.setLayoutY(85);

        int gridSize = 11; // Tamaño de la cuadrícula
        int paneSize = 352 / gridSize; // Tamaño de cada pane

        for (int i = 0; i < gridSize; i++) {
            for (int j = 0; j < gridSize; j++) {
                // Crear un StackPane
                StackPane stackPane = new StackPane();
                stackPane.setPrefWidth(32);
                stackPane.setPrefHeight(32);
                stackPane.setStyle("-fx-background-color: rgb(177,194,255);" +
                        "-fx-border-color: rgba(0,0,0,0.7);" +
                        "-fx-stroke-type: inside;");

                double xPosition = j * paneSize;
                double yPosition = i * paneSize;

                stackPane.setLayoutX(xPosition);
                stackPane.setLayoutY(yPosition);

                gameBoard.getChildren().add(stackPane);

                if (i == 0 && j == 0) {
                    // Posición (0,0) nula
                    stackPane.setStyle("-fx-background-color: rgb(4,19,114);");
                } else if (i == 0) {
                    // Primera fila (letras de la A a la J)
                    Label label = new Label(String.valueOf((char) ('A' + j - 1)));
                    label.setStyle("-fx-text-fill: #ff762c;" +
                            "-fx-font-weight: bold;"+
                            "-fx-font-size: 15;");
                    stackPane.setStyle("-fx-background-color: rgb(4,19,114);" +
                            "-fx-border-color: rgb(5,19,75);" +
                            "-fx-stroke-type: inside;");
                    stackPane.setAlignment(Pos.CENTER); // Centrar el contenido vertical y horizontalmente
                    stackPane.getChildren().add(label);
                } else if (j == 0) {
                    // Primera columna (números del 1 al 10)
                    Label label = new Label(String.valueOf(i));
                    label.setStyle("-fx-text-fill: #ff762c;" +
                            "-fx-font-weight: bold;"+
                            "-fx-font-size: 15;");
                    stackPane.setStyle("-fx-background-color: rgb(4,19,114);" +
                            "-fx-border-color: rgb(5,19,75);" +
                            "-fx-stroke-type: inside;");
                    stackPane.setAlignment(Pos.CENTER); // Centrar el contenido vertical y horizontalmente
                    stackPane.getChildren().add(label);
                } else {
                    // Resto de la cuadrícula
                    stackPane.setOnMouseEntered(event -> {
                        stackPane.setStyle("-fx-background-color: rgb(173,173,173,0.66);" +
                                "-fx-border-color: rgba(0,0,0,0.7);" +
                                "-fx-stroke-type: inside;");
                    });

                    stackPane.setOnMouseExited(event -> {
                        stackPane.setStyle("-fx-background-color: rgb(177,194,255);" +
                                "-fx-border-color: rgba(0,0,0,0.7);" +
                                "-fx-stroke-type: inside;");
                    });

                    stackPane.setOnMouseClicked(event -> {
                        System.out.println("La posicion en x es: " + stackPane.getLayoutX() +
                                ", y es: " + stackPane.getLayoutY() +
                                ". El id es " + stackPane.getId());
                    });
                }
            }
        }

        basicPane.getChildren().addAll(portaAvion.getPortaAviones(), fragata1.getFragata(), fragata2.getFragata(),fragata3.getFragata(),fragata4.getFragata(), submarino1.getSubmarino(),submarino2.getSubmarino(),destructores1.getDestructor(),destructores2.getDestructor());

        draggableMaker.makeDraggable(portaAvion.getPortaAviones());
        draggableMaker.makeDraggable(fragata1.getFragata());
        draggableMaker.makeDraggable(fragata2.getFragata());
        draggableMaker.makeDraggable(fragata3.getFragata());
        draggableMaker.makeDraggable(fragata4.getFragata());
        draggableMaker.makeDraggable(submarino1.getSubmarino());
        draggableMaker.makeDraggable(submarino2.getSubmarino());
        draggableMaker.makeDraggable(destructores1.getDestructor());
        draggableMaker.makeDraggable(destructores2.getDestructor());
    }

    @FXML
    void onHandleButtonStartGame(ActionEvent event) throws IOException {
        GameStage.getInstance();
        StartStage.deleteInstance();
    }

    public Pane getGameBoard() {
        return gameBoard;
    }
}