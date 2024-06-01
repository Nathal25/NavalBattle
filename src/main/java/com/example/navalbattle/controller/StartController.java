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
        setFigureLayout(portaAvion, 450, 85);

        submarino1 = new SubmarinosCreator();
        setFigureLayout(submarino1, 500, 117);

        submarino2 = new SubmarinosCreator();
        setFigureLayout(submarino2, 550, 117);

        destructores1=new DestructoresCreator();
        setFigureLayout(destructores1,450,245);

        destructores2=new DestructoresCreator();
        setFigureLayout(destructores2,550,245);

        destructores3=new DestructoresCreator();
        setFigureLayout(destructores3,550,245);


        fragata1 = new FragatasCreator();
        setFigureLayout(fragata1,600,85);

        fragata2 = new FragatasCreator();
        setFigureLayout(fragata2,600,149);

        fragata3 = new FragatasCreator();
        setFigureLayout(fragata3,600,213);

        fragata4 = new FragatasCreator();
        setFigureLayout(fragata4,600,277);

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


        basicPane.getChildren().addAll(portaAvion.getShape(), fragata1.getShape(), fragata2.getShape(),fragata3.getShape(),fragata4.getShape(), submarino1.getShape(),submarino2.getShape(),destructores1.getShape(),destructores2.getShape(), destructores3.getShape());

        draggableMaker.makeDraggable(portaAvion.getShape(),41);
        draggableMaker.makeDraggable(fragata1.getShape(),11);
        draggableMaker.makeDraggable(fragata2.getShape(),12);
        draggableMaker.makeDraggable(fragata3.getShape(),13);
        draggableMaker.makeDraggable(fragata4.getShape(),14);
        draggableMaker.makeDraggable(submarino1.getShape(),31);
        draggableMaker.makeDraggable(submarino2.getShape(),32);
        draggableMaker.makeDraggable(destructores1.getShape(),21);
        draggableMaker.makeDraggable(destructores2.getShape(),22);
        draggableMaker.makeDraggable(destructores3.getShape(),23);
    }
    private void setFigureLayout(IShapeCreator figure, double layoutX, double layoutY) {
        figure.setLayoutX(layoutX);
        figure.setLayoutY(layoutY);
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

            imprimirPosicionesFinales();// METODO DE POSICIONES FINALES
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

    public void imprimirPosicionesFinales() {
        // Imprime las posiciones finales de los barcos utilizando DraggableMarker
        draggableMaker.imprimirPosicionesFinales();
    }


    public Pane getGameBoard() {
        return gameBoard;
    }

}
