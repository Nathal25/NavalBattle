package com.example.navalbattle.model;

import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;

public class SubmarinosCreator {
    private Polygon submarino1;

    public SubmarinosCreator(){
        submarino1 = new Polygon(0,32,//A
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
        submarino1.setFill(Color.rgb(178,52,95));
        submarino1.setStrokeWidth(1);
        submarino1.setStroke(Color.rgb(136,35,70));
        submarino1.setLayoutX(450);
        submarino1.setLayoutY(80);
    }
    public Polygon getSubmarino1(){return submarino1;}

    public void setSubmarino1(Polygon submarino1) {
        this.submarino1 = submarino1;
    }
}