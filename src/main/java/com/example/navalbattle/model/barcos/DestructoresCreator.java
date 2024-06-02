package com.example.navalbattle.model.barcos;

import javafx.scene.paint.Color;

public class DestructoresCreator extends ShapeCreator {
    public DestructoresCreator() {
        super(new double[]{
                0, 32,//A
                16, 0,//B
                32, 32,//C
                16, 32,//D
                32, 64,//E
                0, 64,//F
                16, 32,//D
                0, 32
        },Color.rgb(228, 140, 255),Color.BLACK);
    }

}