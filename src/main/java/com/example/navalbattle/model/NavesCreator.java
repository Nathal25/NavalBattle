package com.example.navalbattle.model;

import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;

public class NavesCreator {
    private Polygon portaAviones;
    private Polygon fragata1;
    private Polygon fragata2;
    private Polygon fragata3;
    private Polygon fragata4;
    private int id;
    public NavesCreator() {
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
        portaAviones.setLayoutY(87);

        fragata1 = new Polygon(
                0,32,//A
                16,0,//B
                32,32
        );
        fragata1.setFill(Color.rgb(0,128,128));
        fragata1.setStroke(Color.rgb(0,79,79));
        fragata1.setStrokeWidth(1);
        fragata1.setLayoutX(600);
        fragata1.setLayoutY(87);
    }
    public Polygon getPortaAviones() {
        return portaAviones;
    }
    public void setPortaAviones(Polygon portaAviones) {this.portaAviones = portaAviones;}
    public Polygon getFragata1() {return fragata1;}
    public void setFragata1(Polygon fragata1) {this.fragata1 = fragata1;}
}
