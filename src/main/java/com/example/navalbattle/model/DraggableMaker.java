package com.example.navalbattle.model;

import javafx.scene.Node;

import java.util.ArrayList;
import java.util.List;

public class DraggableMaker {
    private double posMouseX = 0, posMouseY = 0;
    private int parentWidth = 737;  // Ancho del AnchorPane
    private int parentHeight = 410; // Alto del AnchorPane
    private final double POSITION_X1 = 69;
    private final double POSITION_X2 = 101;
    private final double POSITION_X3 = 133;
    private final double POSITION_X4 = 165;
    private final double POSITION_X5 = 197;
    private final double POSITION_X6 = 229;
    private final double POSITION_X7 = 261;
    private final double POSITION_X8 = 293;
    private final double POSITION_X9 = 325;
    private final double POSITION_X10 = 357;
    private final double POSITION_Y1 = 85;
    private final double POSITION_Y2 = 117;
    private final double POSITION_Y3 = 149;
    private final double POSITION_Y4 = 181;
    private final double POSITION_Y5 = 213;
    private final double POSITION_Y6 = 245;
    private final double POSITION_Y7 = 277;
    private final double POSITION_Y8 = 309;
    private final double POSITION_Y9 = 341;
    private final double POSITION_Y10 = 373;
    private double closestX;
    private double closestY;
    private boolean gameOn = true;  // Asegúrate de que gameOn esté configurado en true
    private int id;
    private List<Integer> validPos=new ArrayList<>();

    public void makeDraggable(Node node, int id) {
        this.id = id;
        if (gameOn) {
            node.setOnMousePressed(mouseEvent -> {
                posMouseX = mouseEvent.getSceneX() - node.getLayoutX();
                posMouseY = mouseEvent.getSceneY() - node.getLayoutY();
            });

            node.setOnMouseDragged(mouseEvent -> {
                double newX = mouseEvent.getSceneX() - posMouseX;
                double newY = mouseEvent.getSceneY() - posMouseY;

                if (newX >= 0 && newX <= parentWidth - node.getBoundsInParent().getWidth()) {
                    node.setLayoutX(newX);
                }
                if (newY >= 0 && newY <= parentHeight - node.getBoundsInParent().getHeight()) {
                    node.setLayoutY(newY);
                }
            });

            node.setOnMouseReleased(mouseEvent -> {
                posMouseX = 0;
                posMouseY = 0;

                adjustToClosestPosition(node, id);
            });
        } else {
            System.out.println("Game is not on.");
        }
    }

    public void adjustToClosestPosition(Node node, int id) {
        this.id = id;
        double currentY = node.getLayoutY();
        double[] positionsY = {
                POSITION_Y1, POSITION_Y2, POSITION_Y3, POSITION_Y4, POSITION_Y5,
                POSITION_Y6, POSITION_Y7, POSITION_Y8, POSITION_Y9, POSITION_Y10
        };

        closestY = positionsY[0];
        double minDifferenceY = Math.abs(currentY - positionsY[0]);

        for (int i = 1; i < positionsY.length; i++) {
            double difference = Math.abs(currentY - positionsY[i]);
            if (difference < minDifferenceY) {
                closestY = positionsY[i];
                minDifferenceY = difference;
            }
        }

        if (id == 41) {
            System.out.println("Esto es un portaAvion");
            addValidPos(id);
        } else if (id == 31 || id == 32) {
            System.out.println("Esto es el submarino " + id);
            addValidPos(id);
        } else if (id == 21 || id == 22 || id == 23) {
            System.out.println("Esto es el destructor " + id);
            addValidPos(id);
        } else if (id == 11 || id == 12 || id == 13 || id == 14) {
            System.out.println("Esta es la fragata " + id);
            addValidPos(id);
        }
        // Agregar el id a la lista de posiciones válidas

        double currentX = node.getLayoutX();
        double[] positionsX = {
                POSITION_X1, POSITION_X2, POSITION_X3, POSITION_X4, POSITION_X5,
                POSITION_X6, POSITION_X7, POSITION_X8, POSITION_X9, POSITION_X10
        };
        closestX = positionsX[0];
        double minDifferenceX = Math.abs(currentX - positionsX[0]);

        for (int i = 1; i < positionsX.length; i++) {
            double differenceX = Math.abs(currentX - positionsX[i]);
            if (differenceX < minDifferenceX) {
                closestX = positionsX[i];
                minDifferenceX = differenceX;
            }
        }

        node.setLayoutY(closestY);
        node.setLayoutX(closestX);

        System.out.println("-- closestX: " + closestX);
        System.out.println("-- closestY: " + closestY);

// Imprimir la lista de posiciones válidas después de agregar
        System.out.println("Lista de posiciones válidas: " + validPos);
    }

    public List<Integer> getValidPos() {
        return validPos;
    }
    public void addValidPos(int id) {
        if(!validPos.contains(id)) {
            validPos.add(id);
        }
    }

    public double getClosestX() {
        return closestX;
    }

    public double getClosestY() {
        return closestY;
    }

    public boolean isGameOn() {
        return gameOn;
    }

    public void setGameOn(boolean gameOn) {
        this.gameOn = gameOn;
    }
}