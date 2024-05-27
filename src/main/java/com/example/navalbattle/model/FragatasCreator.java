package com.example.navalbattle.model;

import javafx.scene.input.MouseButton;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import javafx.scene.transform.Rotate;

public class FragatasCreator {
    private Polygon fragata;

    private double layoutX;
    private double layoutY;

    public FragatasCreator() {
        fragata = new Polygon(
                0,32,//A
                16,0,//B
                32,32
        );
        fragata.setFill(Color.rgb(0,128,128));
        fragata.setStroke(Color.rgb(0,79,79));
        fragata.setStrokeWidth(1);

        // Agrega un evento de click al fragata para detectar clics del usuario
        fragata.setOnMouseClicked(this::handleFragatasClick);
    }
    public Polygon getFragata() {
        return fragata;
    }
    public void setFragata(Polygon fragata) {this.fragata = fragata;}

    public double getLayoutX() {return layoutX;}
    public void setLayoutX(double layoutX) {
        this.layoutX = layoutX;
        fragata.setLayoutX(layoutX);
    }

    public double getLayoutY() {return layoutY;}
    public void setLayoutY(double layoutY) {
        this.layoutY = layoutY;
        fragata.setLayoutY(layoutY);
    }

    // Método para manejar el evento de click el la fragata
    private void handleFragatasClick(javafx.scene.input.MouseEvent mouseEvent) {
        if (mouseEvent.getButton() == MouseButton.SECONDARY) { // botón derecho
            // Rotar el fragata cuando se hace clic derecho
            rotateClockwise();
            System.out.println("Fragata rotado ");
        }
    }
    // Método para rotar el fragata
    private void rotateClockwise() {
        Rotate rotate = new Rotate(90, fragata.getBoundsInLocal().getWidth() / 2, fragata.getBoundsInLocal().getHeight() / 2);
        fragata.getTransforms().add(rotate);
    }

}