package com.example.navalbattle.model;

import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;

public class PortaAvionesCreator {
    private Polygon portaAviones;
    private Polygon fragata1;
    private Polygon fragata2;
    private Polygon fragata3;
    private Polygon fragata4;
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
        portaAviones.setLayoutX(400);
        portaAviones.setLayoutY(80);


    }
    public Polygon getPortaAviones() {
        return portaAviones;
    }
    public void setPortaAviones(Polygon portaAviones) {this.portaAviones = portaAviones;}
}