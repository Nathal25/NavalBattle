package com.example.navalbattle.controller;

import com.example.navalbattle.model.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
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
    @FXML
    private GridPane basicGrid;

    private ShipsPositions shipsPositions;
    private DraggableMaker draggableMaker;
    private SubmarinosCreator submarino1,submarino2;
    private DestructoresCreator destructores1,destructores2,destructores3;
    private PortaAvionesCreator portaAvion;
    private FiguresCreator base;
    private FragatasCreator fragata1,fragata2,fragata3,fragata4;

    public void initialize(){
        draggableMaker = new DraggableMaker();
        portaAvion = new PortaAvionesCreator();
        portaAvion.setLayoutx(450);
        portaAvion.setLayouty(85);

        submarino1 = new SubmarinosCreator();
        submarino1.setLayoutX(500);
        submarino1.setLayoutY(117);

        submarino2 = new SubmarinosCreator();
        submarino2.setLayoutX(550);
        submarino2.setLayoutY(117);

        destructores1=new DestructoresCreator();
        destructores1.setLayoutX(450);
        destructores1.setLayoutY(245);

        destructores2=new DestructoresCreator();
        destructores2.setLayoutX(500);
        destructores2.setLayoutY(245);

        destructores3=new DestructoresCreator();
        destructores3.setLayoutX(550);
        destructores3.setLayoutY(245);

        fragata1 = new FragatasCreator();
        fragata1.setLayoutX(600);
        fragata1.setLayoutY(85);

        fragata2 = new FragatasCreator();
        fragata2.setLayoutX(600);
        fragata2.setLayoutY(149);

        fragata3 = new FragatasCreator();
        fragata3.setLayoutX(600);
        fragata3.setLayoutY(213);

        fragata4 = new FragatasCreator();
        fragata4.setLayoutX(600);
        fragata4.setLayoutY(277);

        base = new FiguresCreator();

        int gridSize = 11; // Tamaño de la cuadrícula
        int paneSize = 352 / gridSize; // Tamaño de cada pane

        for (int i = 0; i < gridSize; i++) {
            for (int j = 0; j < gridSize; j++) {
                String id=(String.valueOf((char) ('A' + j - 1))).concat(String.valueOf(i));
                // Crear un StackPane
                StackPane stackPane = new StackPane();
                stackPane.setId(id);
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
                    stackPane.setStyle("-fx-background-color: rgb(36,59,204);" +
                            "-fx-border-color: rgb(25,43,119);" +
                            "-fx-stroke-type: inside;");
                } else if (i == 0) {
                    // Primera fila (letras de la A a la J)
                    Label label = new Label(String.valueOf((char) ('A' + j - 1)));
                    label.setStyle("-fx-text-fill: #f6925c;" +
                            "-fx-font-weight: bold;"+
                            "-fx-font-size: 15;");
                    stackPane.setStyle("-fx-background-color: rgb(36,59,204);" +
                            "-fx-border-color: rgb(25,43,119);" +
                            "-fx-stroke-type: inside;");
                    stackPane.setAlignment(Pos.CENTER); // Centrar el contenido vertical y horizontalmente
                    stackPane.getChildren().add(label);
                } else if (j == 0) {
                    // Primera columna (números del 1 al 10)
                    Label label = new Label(String.valueOf(i));
                    label.setStyle("-fx-text-fill: #ff762c;" +
                            "-fx-font-weight: bold;"+
                            "-fx-font-size: 15;");
                    stackPane.setStyle("-fx-background-color: rgb(36,59,204);" +
                            "-fx-border-color: rgb(25,43,119);" +
                            "-fx-stroke-type: inside;");
                    stackPane.setAlignment(Pos.CENTER); // Centrar el contenido vertical y horizontalmente
                    stackPane.getChildren().add(label);
                } else {
                    // Resto de la cuadrícula
                    stackPane.setOnMouseEntered(event -> {
                        stackPane.setStyle("-fx-background-color: rgb(210,210,210);" +
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


        basicPane.getChildren().addAll(portaAvion.getPortaAviones(), fragata1.getFragata(), fragata2.getFragata(),fragata3.getFragata(),fragata4.getFragata(), submarino1.getSubmarino(),submarino2.getSubmarino(),destructores1.getDestructor(),destructores2.getDestructor(), destructores3.getDestructor());

        draggableMaker.makeDraggable(portaAvion.getPortaAviones(),41);
        draggableMaker.makeDraggable(fragata1.getFragata(),11);
        draggableMaker.makeDraggable(fragata2.getFragata(),12);
        draggableMaker.makeDraggable(fragata3.getFragata(),13);
        draggableMaker.makeDraggable(fragata4.getFragata(),14);
        draggableMaker.makeDraggable(submarino1.getSubmarino(),31);
        draggableMaker.makeDraggable(submarino2.getSubmarino(),32);
        draggableMaker.makeDraggable(destructores1.getDestructor(),21);
        draggableMaker.makeDraggable(destructores2.getDestructor(),22);
        draggableMaker.makeDraggable(destructores3.getDestructor(),23);
    }

    @FXML
    void onHandleButtonStartGame(ActionEvent event) throws IOException {
        int listSize=draggableMaker.getValidPos().size();
        System.out.println("El tamaño de la lista es: "+draggableMaker.getValidPos().size());

        if(listSize!=10){
            System.out.println("Aun faltan barcos por colocar");
            System.out.println("..."+draggableMaker.getValidPos());
        }
        else {

            shipsPositions=new ShipsPositions();
            basicGrid.setPrefWidth(855);
            Scene scene = basicGrid.getScene();
            if (scene != null) {
                scene.getWindow().setWidth(855);

            }
            GridPane boardMachine=new GridPane();
            for (int i = 0; i < 11; i++) {
                for (int j = 0; j < 11; j++) {
                    String id=(String.valueOf((char) ('A' + j - 1))).concat(String.valueOf(i));
                    // Crear un StackPane
                    StackPane stackPane = new StackPane();
                    stackPane.setId(id);
                    stackPane.setPrefWidth(32);
                    stackPane.setPrefHeight(32);
                    stackPane.setStyle("-fx-background-color: rgb(177,194,255);" +
                            "-fx-border-color: rgba(0,0,0,0.7);" +
                            "-fx-stroke-type: inside;");
                    if (i == 0 && j == 0) {
                        // Posición (0,0) nula
                        stackPane.setStyle("-fx-background-color: rgb(36,59,204);" +
                                "-fx-border-color: rgb(25,43,119);" +
                                "-fx-stroke-type: inside;");
                    } else if (j == 0) {
                        // Primera columna (letras de la A a la J)
                        Label label = new Label(String.valueOf(i));
                        label.setStyle("-fx-text-fill: #f6925c;" +
                                "-fx-font-weight: bold;"+
                                "-fx-font-size: 15;");
                        stackPane.setStyle("-fx-background-color: rgb(36,59,204);" +
                                "-fx-border-color: rgb(25,43,119);" +
                                "-fx-stroke-type: inside;");
                        stackPane.setAlignment(Pos.CENTER); // Centrar el contenido vertical y horizontalmente
                        stackPane.getChildren().add(label);
                    } else if (i == 0) {
                        // Primera fila (números del 1 al 10)

                        Label label = new Label(String.valueOf((char) ('A' + j - 1)));
                        label.setStyle("-fx-text-fill: #ff762c;" +
                                "-fx-font-weight: bold;"+
                                "-fx-font-size: 15;");
                        stackPane.setStyle("-fx-background-color: rgb(36,59,204);" +
                                "-fx-border-color: rgb(25,43,119);" +
                                "-fx-stroke-type: inside;");
                        stackPane.setAlignment(Pos.CENTER); // Centrar el contenido vertical y horizontalmente
                        stackPane.getChildren().add(label);
                    } else {
                        // Resto de la cuadrícula
                        stackPane.setOnMouseEntered(event2 -> {
                            stackPane.setStyle("-fx-background-color: rgb(210,210,210);" +
                                    "-fx-border-color: rgba(0,0,0,0.7);" +
                                    "-fx-stroke-type: inside;");
                        });

                        stackPane.setOnMouseExited(event2 -> {
                            stackPane.setStyle("-fx-background-color: rgb(177,194,255);" +
                                    "-fx-border-color: rgba(0,0,0,0.7);" +
                                    "-fx-stroke-type: inside;");
                        });

                        stackPane.setOnMouseClicked(event2 -> {
                            System.out.println("La posicion en x es: " + stackPane.getLayoutX() +
                                    ", y es: " + stackPane.getLayoutY() +
                                    ". El id es " + stackPane.getId());
                            if (shipsPositions.getShipsPositions().contains(stackPane.getId())) {
                                System.out.println("Acá hay un barco");
                            }
                        });
                    }
                    boardMachine.add(stackPane, j, i);
                }
            }
            boardMachine.setLayoutX(450);
            boardMachine.setLayoutY(53);
            basicPane.getChildren().add(boardMachine);
            btnStart.setVisible(false);
        }
    }

    public Pane getGameBoard() {
        return gameBoard;
    }

}