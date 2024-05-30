package com.example.navalbattle.model;

import javafx.scene.input.MouseButton;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import javafx.scene.transform.Rotate;

public class DestructoresCreator {
    private Polygon destructor;
    private double layoutX, layoutY;
    private int turns=1;
    private int id=32;
    private DraggableMaker draggableMaker=new DraggableMaker();

    public DestructoresCreator() {
        destructor = new Polygon(
                0, 32,//A
                16, 0,//B
                32, 32,//C
                16, 32,//D
                32, 64,//E
                0, 64,//F
                16, 32,//D
                0, 32
        );
        destructor.setFill(Color.rgb(228, 140, 255));
        destructor.setStroke(Color.BLACK);
        destructor.setStrokeWidth(1);

        // Agrega un evento de click al destructor para detectar clics del usuario
        destructor.setOnMouseClicked(this::handleRotarClick);
    }

    public Polygon getDestructor() {
        return destructor;
    }

    public void setDestructor(Polygon destructor) {
        this.destructor = destructor;
    }

    public double getLayoutX() {
        return layoutX;
    }

    public double getLayoutY() {
        return layoutY;
    }

    public void setLayoutX(double x) {
        this.layoutX = layoutX;
        destructor.setLayoutX(x);
    }

    public void setLayoutY(double y) {
        this.layoutY = layoutY;
        destructor.setLayoutY(y);
    }

    // Método para manejar el evento de click en los submarinos
    private void handleRotarClick(javafx.scene.input.MouseEvent mouseEvent) {
        if (mouseEvent.getButton() == MouseButton.SECONDARY) { // botón derecho
            // Rotar el submarino cuando se hace clic derecho
            destructor.getTransforms().add(new javafx.scene.transform.Rotate(90, 16, 48));
            System.out.println("Destructor rotado");
            turns++;
            //System.out.println("La cantidad de giros es: "+turns);
            if (turns == 4) {
                resetTurns();
            }
        }
    }

    private void resetTurns(){
        turns=1;
    }

    public int getTurns() {
        return turns;
    }

    public int getId() {
        return id;
    }
}