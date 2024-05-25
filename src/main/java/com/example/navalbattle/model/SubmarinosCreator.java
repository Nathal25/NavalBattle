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
        submarino.setOnMouseClicked(this::handleSubmarinoClick);
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

    // Método para manejar el evento de click en el submarino
    private void handleSubmarinoClick(javafx.scene.input.MouseEvent mouseEvent) {
        if (mouseEvent.getButton() == MouseButton.SECONDARY) { // botón derecho
            // Rotar el submarino cuando se hace clic derecho
            rotateClockwise();
            System.out.println("Submarino rotado ");
        }
    }
    // Método para rotar el submarino
    private void rotateClockwise() {
        Rotate rotate = new Rotate(90, submarino.getBoundsInLocal().getWidth() / 2, submarino.getBoundsInLocal().getHeight() / 2);
        submarino.getTransforms().add(rotate);
    }

}
