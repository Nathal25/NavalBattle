package com.example.navalbattle.model;

import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;

public class SubmarinosCreator {
    private Polygon submarino;
    private double layoutX,layoutY;

    public SubmarinosCreator(){
        submarino = new Polygon(0,32,//A
                16,0,//B
                32,32,//C
                16,32,//D
                32,64,//E
                16,64,//F
                32,96,//G
                0,96,//K
                16,64,//F
                0,64,//L
                16,32,//D
                0,32
        );
        submarino.setFill(Color.rgb(178,52,95));
        submarino.setStrokeWidth(1);
        submarino.setStroke(Color.rgb(136,35,70));

    }
    public Polygon getSubmarino(){return submarino;}

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
    public double getLayoutY() {return layoutY;}
    public void setLayoutY(double layoutY) {
        this.layoutY = layoutY;
        submarino.setLayoutY(layoutY);
    }
}