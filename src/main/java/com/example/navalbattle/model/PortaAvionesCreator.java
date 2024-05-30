package com.example.navalbattle.model;

import javafx.scene.input.MouseButton;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;

public class PortaAvionesCreator {
    private Polygon portaAviones;
    private double layouty, layoutx;
    private int turns = 1;
    private double posicionesX, posicionesY;

    public PortaAvionesCreator() {
        portaAviones = new Polygon(
                0, 32, // A
                16, 0, // B
                32, 32, // C
                16, 32, // D
                32, 64, // E
                16, 64, // F
                32, 96, // G
                16, 96, // H
                32, 128, // I
                0, 128, // J
                16, 96, // H
                0, 96, // K
                16, 64, // F
                0, 64, // L
                16, 32, // D
                0, 32 // A
        );

        portaAviones.setFill(Color.RED);
        portaAviones.setStroke(Color.BLACK);
        portaAviones.setStrokeWidth(1);

        // Agrega un evento de click al PortaAvion para detectar clics del usuario
        portaAviones.setOnMouseClicked(this::handleRotarClick);

    }

    public void setPosicionesX(double posicionesX) {
        this.posicionesX = posicionesX;
    }

    public void setPosicionesY(double posicionesY) {
        this.posicionesY = posicionesY;
    }

    public Polygon getPortaAviones() {
        return portaAviones;
    }

    public void setPortaAviones(Polygon portaAviones) {
        this.portaAviones = portaAviones;
    }

    public double getLayouty() {
        return layouty;
    }
    public double getLayoutx() {
        return layoutx;
    }

    public void setLayouty(double layouty) {
        this.layouty = layouty;
        portaAviones.setLayoutY(layouty);
    }



    public void setLayoutx(double layoutx) {
        this.layoutx = layoutx;
        portaAviones.setLayoutX(layoutx);
    }


    private void handleRotarClick(javafx.scene.input.MouseEvent mouseEvent) {
        if (mouseEvent.getButton() == MouseButton.SECONDARY) { // botón derecho

            portaAviones.getTransforms().add(new javafx.scene.transform.Rotate(90, 16, 48));
            System.out.println("PortaAviones rotado");
            turns++;
            System.out.println("La cantidad de giros es: " + turns);
            if (turns == 4) {
                resetTurns();
            }
        }
    }

    private void resetTurns() {
        turns = 1;
    }

    public int getTurns() {
        return turns;
    }
}
