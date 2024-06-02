package com.example.navalbattle.model.barcos;


import javafx.scene.paint.Color;

public class SubmarinosCreator extends ShapeCreator {
    public SubmarinosCreator() {
        super(new double[]{
                0, 32, 16, 0, 32, 32, 16, 32, 32, 64, 16, 64, 32, 96, 0, 96,
                16, 64, 0, 64, 16, 32, 0, 32
        }, Color.rgb(178, 52, 95), Color.rgb(136, 35, 70));
    }
}

