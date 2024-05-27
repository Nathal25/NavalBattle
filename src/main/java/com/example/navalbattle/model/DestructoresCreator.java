package com.example.navalbattle.model;

import javafx.scene.input.MouseButton;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import javafx.scene.transform.Rotate;

public class DestructoresCreator {
    private Polygon destructor;
    private double layoutX,layoutY;

    public DestructoresCreator(){
        destructor = new Polygon(
                0,32,//A
                16,0,//B
                32,32,//C
                16,32,//D
                32,64,//E
                0,64,//F
                16,32,//D
                0,32
        );
        destructor.setFill(Color.rgb(228,140,255));
        destructor.setStroke(Color.BLACK);
        destructor.setStrokeWidth(1);

        // Agrega un evento de click al destructor para detectar clics del usuario
        destructor.setOnMouseClicked(this::handleRotarClick);
    }
    public Polygon getDestructor(){return destructor;}

    public void setDestructor(Polygon destructor) {
        this.destructor = destructor;
    }

    public double getLayoutX(){return layoutX;}
    public double getLayoutY(){return layoutY;}

    public void setLayoutX(double x){
        this.layoutX = layoutX;
        destructor.setLayoutX(x);
    }
    public void setLayoutY(double y){
        this.layoutY = layoutY;
        destructor.setLayoutY(y);
    }

    // Método para manejar el evento de click en los submarinos
    private void handleRotarClick(javafx.scene.input.MouseEvent mouseEvent) {
        if (mouseEvent.getButton() == MouseButton.SECONDARY) { // botón derecho
            // Rotar el portaAvion cuando se hace clic derecho
            double layoutY = destructor.getLayoutY();
            double layoutX = destructor.getLayoutX();

            if ((layoutY != 373 && layoutY != 309 && layoutY != 341) &&
                    (layoutX != 357 && layoutX != 325 && layoutX != 293)) {
                reDoCoords();
            }
            System.out.println("Destructor rotado ");
        }
    }
    public void reDoCoords() {
        double[] coordenadas = destructor.getPoints().stream().mapToDouble(Double::doubleValue).toArray();
        double[] nuevasCoordenadas = new double[coordenadas.length];
        for (int i = 0; i < coordenadas.length; i += 2) {
            nuevasCoordenadas[i] = coordenadas[i + 1]; // y -> x
            nuevasCoordenadas[i + 1] = coordenadas[i]; // x -> y
        }
        destructor.getPoints().clear();
        for (double coord : nuevasCoordenadas) {
            destructor.getPoints().add(coord);
        }
    }
}