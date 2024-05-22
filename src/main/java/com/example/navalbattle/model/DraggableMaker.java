package com.example.navalbattle.model;

import javafx.scene.Node;

public class DraggableMaker {
    private double posMouseX = 0, posMouseY = 0;
    private double parentWidth = 682;  // Ancho del AnchorPane
    private double parentHeight = 455; // Alto del AnchorPane

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
        });
    }

    public double getPosMouseX() {
        return posMouseX;
    }

    public double getPosMouseY() {
        return posMouseY;
    }
}
