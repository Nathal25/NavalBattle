package com.example.navalbattle.model.barcos;

import javafx.scene.paint.Color;

public class FragatasCreator extends ShapeCreator {
    public FragatasCreator() {
        super(new double[]{
                0, 32,//A
                16, 0,//B
                32, 32
        },Color.rgb(0, 128, 128),Color.rgb(0, 79, 79));
    }
}