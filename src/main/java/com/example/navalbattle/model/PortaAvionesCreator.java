package com.example.navalbattle.model;

import javafx.scene.input.MouseButton;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;

public class PortaAvionesCreator {
    private Polygon portaAviones;
    private double layouty;
    private double layoutx;
    private int id;

    public PortaAvionesCreator() {


        portaAviones = new Polygon(
                0,32,//A
                16,0,//B
                32,32,//C
                16,32,//D
                32,64,//E
                16,64,//F
                32,96,//G
                16,96,//H
                32,128,//I
                0,128,//J
                16,96,//H
                0,96,//K
                16,64,//F
                0,64,//L
                16,32,//D
                0,32//A
        );

        //layoutX="472.0" layoutY="87.0"
        portaAviones.setFill(Color.RED);
        portaAviones.setStroke(Color.BLACK);
        portaAviones.setStrokeWidth(1);

        // Agrega un evento de click al PortaAvion para detectar clics del usuario
        portaAviones.setOnMouseClicked(this::handleRotarClick);

    }

    public Polygon getPortaAviones() {
        return portaAviones;
    }
    public void setPortaAviones(Polygon portaAviones) {this.portaAviones = portaAviones;}

    public double getLayouty() {return layouty;}

    public void setLayouty(double layouty) {
        this.layouty = layouty;
        portaAviones.setLayoutY(layouty);
    }

    public double getLayoutx() {return layoutx;}
    public void setLayoutx(double layoutx) {
        this.layoutx = layoutx;
        portaAviones.setLayoutX(layoutx);
    }

    // Método para manejar el evento de click en los portaaviones
    private void handleRotarClick(javafx.scene.input.MouseEvent mouseEvent) {
        if (mouseEvent.getButton() == MouseButton.SECONDARY) { // botón derecho
            // Rotar el portaAvion cuando se hace clic derecho
            double layoutY = portaAviones.getLayoutY();
            double layoutX = portaAviones.getLayoutX();

            if ((layoutY != 373 && layoutY != 309 && layoutY != 341) &&
                    (layoutX != 357 && layoutX != 325 && layoutX != 293)) {
                reDoCoords();
            }
            System.out.println("PortaAvion rotado ");
        }
    }
    public void reDoCoords() {
        double[] coordenadas = portaAviones.getPoints().stream().mapToDouble(Double::doubleValue).toArray();
        double[] nuevasCoordenadas = new double[coordenadas.length];
        for (int i = 0; i < coordenadas.length; i += 2) {
            nuevasCoordenadas[i] = coordenadas[i + 1]; // y -> x
            nuevasCoordenadas[i + 1] = coordenadas[i]; // x -> y
        }
        portaAviones.getPoints().clear();
        for (double coord : nuevasCoordenadas) {
            portaAviones.getPoints().add(coord);
        }
    }

}

