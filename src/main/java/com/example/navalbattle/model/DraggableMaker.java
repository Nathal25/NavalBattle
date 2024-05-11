package com.example.navalbattle.model;

import javafx.scene.Node;

public class DraggableMaker {
    private double posMouseX, posMouseY;

    public void makeDraggable(Node node) {
        node.setOnMousePressed(mouseEvent -> {
            // Guardar la posición del mouse cuando se presiona el botón
            posMouseX = mouseEvent.getSceneX() - node.getLayoutX();
            posMouseY = mouseEvent.getSceneY() - node.getLayoutY();
        });

        node.setOnMouseDragged(mouseEvent -> {
            // Actualizar la posición del nodo mientras se arrastra
            node.setLayoutX(mouseEvent.getSceneX() - posMouseX);
            node.setLayoutY(mouseEvent.getSceneY() - posMouseY);
        });

        node.setOnMouseReleased(mouseEvent -> {
            // Restablecer el desplazamiento cuando se suelta el mouse
            posMouseX = 0;
            posMouseY = 0;
        });
    }
}
