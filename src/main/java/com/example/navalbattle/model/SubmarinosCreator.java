package com.example.navalbattle.model;


import javafx.scene.input.MouseButton;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import javafx.scene.transform.Rotate;

public class SubmarinosCreator {
    private Polygon submarino;
    private double layoutX, layoutY;

    public SubmarinosCreator() {
        submarino = new Polygon(
                0, 32,   // A
                16, 0,   // B
                32, 32,  // C
                16, 32,  // D
                32, 64,  // E
                16, 64,  // F
                32, 96,  // G
                0, 96,   // K
                16, 64,  // F
                0, 64,   // L
                16, 32,  // D
                0, 32    // A
        );
        submarino.setFill(Color.rgb(178, 52, 95));
        submarino.setStrokeWidth(1);
        submarino.setStroke(Color.rgb(136, 35, 70));

        // Agrega un evento de click al submarino para detectar clics del usuario
        submarino.setOnMouseClicked(this::handleRotarClick);
    }

    public Polygon getSubmarino() {
        return submarino;
    }

    public void setSubmarino(Polygon submarino) {
        this.submarino = submarino;
    }

    public double getLayoutX() {
        return layoutX;
    }

    public void setLayoutX(double layoutX) {
        this.layoutX = layoutX;
        submarino.setLayoutX(layoutX);
    }

    public double getLayoutY() {
        return layoutY;
    }

    public void setLayoutY(double layoutY) {
        this.layoutY = layoutY;
        submarino.setLayoutY(layoutY);
    }

    // Método para manejar el evento de click en los submarinos
    private void handleRotarClick(javafx.scene.input.MouseEvent mouseEvent) {
        if (mouseEvent.getButton() == MouseButton.SECONDARY) { // botón derecho
            // Rotar el portaAvion cuando se hace clic derecho
            double layoutY = submarino.getLayoutY();
            double layoutX = submarino.getLayoutX();

            if ((layoutY != 373 && layoutY != 309 && layoutY != 341) &&
                    (layoutX != 357 && layoutX != 325 && layoutX != 293)) {
                reDoCoords();
            }
            System.out.println("Submarino rotado ");
        }
    }
    public void reDoCoords() {
        double[] coordenadas = submarino.getPoints().stream().mapToDouble(Double::doubleValue).toArray();
        double[] nuevasCoordenadas = new double[coordenadas.length];
        for (int i = 0; i < coordenadas.length; i += 2) {
            nuevasCoordenadas[i] = coordenadas[i + 1]; // y -> x
            nuevasCoordenadas[i + 1] = coordenadas[i]; // x -> y
        }
        submarino.getPoints().clear();
        for (double coord : nuevasCoordenadas) {
            submarino.getPoints().add(coord);
        }
    }

}
