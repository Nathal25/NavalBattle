package com.example.navalbattle.model;

import javafx.scene.Node;
import javafx.scene.transform.Rotate;
import javafx.scene.transform.Transform;

public class DraggableMaker {
    private double posMouseX = 0, posMouseY = 0;
    private int parentWidth = 682;  // Ancho del AnchorPane
    private int parentHeight = 408; // Alto del AnchorPane
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

    public void makeDraggable(Node node) {
        node.setOnMousePressed(mouseEvent -> {
            // Guardar la posición del mouse cuando se presiona el botón
            posMouseX = mouseEvent.getSceneX() - node.getLayoutX();
            posMouseY = mouseEvent.getSceneY() - node.getLayoutY();
        });

        node.setOnMouseDragged(mouseEvent -> {
            // Calcular nuevas posiciones
            double newX = mouseEvent.getSceneX() - posMouseX;
            double newY = mouseEvent.getSceneY() - posMouseY;

            // Asegurarse de que el nodo no se salga del AnchorPane
            if (newX >= 0 && newX <= parentWidth - node.getBoundsInParent().getWidth()) {
                node.setLayoutX(newX);
            }
            if (newY >= 0 && newY <= parentHeight - node.getBoundsInParent().getHeight()) {
                node.setLayoutY(newY);
            }
        });

        node.setOnMouseReleased(mouseEvent -> {
            // Restablecer el desplazamiento cuando se suelta el mouse
            posMouseX = 0;
            posMouseY = 0;
            // Ajustar la posición a la más cercana
            adjustToClosestPosition(node);
        });
    }

    public double getPosMouseX() {
        return posMouseX;
    }

    public double getPosMouseY() {
        return posMouseY;
    }

    public void setPosMouseX(double posMouseX) {
        this.posMouseX = posMouseX;
    }

    public void setPosMouseY(double posMouseY) {
        this.posMouseY = posMouseY;
    }

    public double getClosestX() {
        return closestX;
    }

    public double getClosestY() {
        return closestY;
    }

    public void adjustToClosestPosition(Node node) {
        double currentY = node.getLayoutY();
        double[] positionsY = {POSITION_Y1, POSITION_Y2, POSITION_Y3,POSITION_Y4,POSITION_Y5,POSITION_Y6,POSITION_Y7,POSITION_Y8,POSITION_Y9,POSITION_Y10}; // Agrega aquí todas las posiciones Y fijas

        double closestY = positionsY[0]; // Inicializa closestY con la primera posición
        double minDifferenceY = Math.abs(currentY - positionsY[0]); // Calcula la diferencia absoluta con la primera posición

        for (int i = 1; i < positionsY.length; i++) {
            double difference = Math.abs(currentY - positionsY[i]); // Calcula la diferencia absoluta con la posición actual del bucle
            if (difference < minDifferenceY) { // Si la diferencia es menor que la mínima registrada hasta ahora
                closestY = positionsY[i]; // Actualiza closestY con la posición actual
                minDifferenceY = difference; // Actualiza la mínima diferencia registrada
            }
        }

        double currentX = node.getLayoutX();
        double[] positionsX = {POSITION_X1, POSITION_X2, POSITION_X3, POSITION_X4, POSITION_X5, POSITION_X6, POSITION_X7, POSITION_X8, POSITION_X9, POSITION_X10};
        double closestX = positionsX[0];
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
    }
}