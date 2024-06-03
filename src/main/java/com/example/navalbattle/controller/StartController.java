package com.example.navalbattle.controller;

import com.example.navalbattle.model.*;
import com.example.navalbattle.model.barcos.*;
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
import java.util.ArrayList;
import java.util.List;

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
    private FragatasCreator fragata1,fragata2,fragata3,fragata4;

    public void initialize(){
        draggableMaker = new DraggableMaker();
        portaAvion = new PortaAvionesCreator();
        setFigureLayout(portaAvion, 450, 85);
        setFigureId(portaAvion,41);

        submarino1 = new SubmarinosCreator();
        setFigureLayout(submarino1, 500, 117);
        setFigureId(submarino1,31);

        submarino2 = new SubmarinosCreator();
        setFigureLayout(submarino2, 550, 117);
        setFigureId(submarino2,32);

        destructores1=new DestructoresCreator();
        setFigureLayout(destructores1,450,245);
        setFigureId(destructores1,21);

        destructores2=new DestructoresCreator();
        setFigureLayout(destructores2,500,245);
        setFigureId(destructores2,22);

        destructores3=new DestructoresCreator();
        setFigureLayout(destructores3,550,245);
        setFigureId(destructores3,23);


        fragata1 = new FragatasCreator();
        setFigureLayout(fragata1,600,85);
        setFigureId(fragata1,11);

        fragata2 = new FragatasCreator();
        setFigureLayout(fragata2,600,149);
        setFigureId(fragata2,12);

        fragata3 = new FragatasCreator();
        setFigureLayout(fragata3,600,213);
        setFigureId(fragata3,13);

        fragata4 = new FragatasCreator();
        setFigureLayout(fragata4,600,277);
        setFigureId(fragata4,14);


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


        basicPane.getChildren().addAll(portaAvion.getShape(), fragata1.getShape(), fragata2.getShape(),fragata3.getShape(),fragata4.getShape(), submarino1.getShape(),submarino2.getShape(),destructores1.getShape(),destructores2.getShape(), destructores3.getShape());

        draggableMaker.makeDraggable(portaAvion.getShape(),portaAvion);
        draggableMaker.makeDraggable(fragata1.getShape(), fragata1);
        draggableMaker.makeDraggable(fragata2.getShape(), fragata2);
        draggableMaker.makeDraggable(fragata3.getShape(), fragata3);
        draggableMaker.makeDraggable(fragata4.getShape(), fragata4);
        draggableMaker.makeDraggable(submarino1.getShape(),submarino1);
        draggableMaker.makeDraggable(submarino2.getShape(),submarino2);
        draggableMaker.makeDraggable(destructores1.getShape(),destructores1);
        draggableMaker.makeDraggable(destructores2.getShape(),destructores2);
        draggableMaker.makeDraggable(destructores3.getShape(),destructores3);
    }
    private void setFigureLayout(IShapeCreator figure, double layoutX, double layoutY) {
        figure.setLayoutX(layoutX);
        figure.setLayoutY(layoutY);
    }
    private void setFigureId(IShapeCreator figure, int id) {
        figure.setId(id);
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

            //Bloqueo para que no se mueva las figuras
            draggableMaker.disableMouseEvents(portaAvion.getShape());
            draggableMaker.disableMouseEvents(fragata1.getShape());
            draggableMaker.disableMouseEvents(fragata2.getShape());
            draggableMaker.disableMouseEvents(fragata3.getShape());
            draggableMaker.disableMouseEvents(fragata4.getShape());
            draggableMaker.disableMouseEvents(submarino1.getShape());
            draggableMaker.disableMouseEvents(submarino2.getShape());
            draggableMaker.disableMouseEvents(destructores1.getShape());
            draggableMaker.disableMouseEvents(destructores2.getShape());
            draggableMaker.disableMouseEvents(destructores3.getShape());

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
                                Touched.addTocado(stackPane);
                            } else {
                                System.out.println("Hay agua");
                                Water.addAgua(stackPane);
                                if (Touched.maximumCounter()) {
                                    Water.addAgua(stackPane);
                                    System.out.println("Ganastes(Usuario)");
                                }
                            }
                            obtainPositions(draggableMaker.getUltimasPosicionesX(),draggableMaker.getUltimasPosicionesY());
                        });

                    }
                    boardMachine.add(stackPane, j, i);
                }
            }
            boardMachine.setLayoutX(450);
            boardMachine.setLayoutY(53);
            basicPane.getChildren().add(boardMachine);
            btnStart.setVisible(false);
            obtainPositions(draggableMaker.getUltimasPosicionesX(),draggableMaker.getUltimasPosicionesY());
        }
    }

    public void obtainPositions(List<Double> posX, List<Double> posY) {
        List<Double> validPosX = new ArrayList<>();
        double startX = 69.0;
        double endX = 357.0;
        double increment = 32.0;

        for (double i = startX; i <= endX; i += increment) {
            validPosX.add(i);
        }

        List<Double> validPosY = new ArrayList<>();
        double startY = 85.0;
        double endY = 373.0;

        for (double i = startY; i <= endY; i += increment) {
            validPosY.add(i);
        }

        System.out.println("Pos validas en X " + validPosX);
        System.out.println("Pos validas en Y " + validPosY);
        System.out.println("Pos guardads en X: " + posX);
        System.out.println("Pos guardads en Y: " + posY);

        if (!validPosX.isEmpty() && !validPosY.isEmpty()) {
            int randomX = (int) (Math.random() * validPosX.size());
            int randomY = (int) (Math.random() * validPosY.size());
            double posRandomX = validPosX.get(randomX);
            double posRandomY = validPosY.get(randomY);

            if (posX.contains(posRandomX) && posY.contains(posRandomY)) {
                System.out.println("En la posicion " + posRandomX + "," + posRandomY + " hay un barco");
                Bomb bomb = new Bomb();
                bomb.setPosImgX(randomX);
                bomb.setPosImgY(randomY);
                gameBoard.getChildren().add(bomb.getImageView());
            } else {
                System.out.println("En la posicion " + posRandomX + "," + posRandomY + " no hay un barco");
            }

            validPosX.remove(randomX);
            validPosY.remove(randomY);
        } else {
            System.out.println("No quedan posiciones válidas para verificar.");
        }
    }
}
