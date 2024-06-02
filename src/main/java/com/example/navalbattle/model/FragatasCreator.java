package com.example.navalbattle.model;

import javafx.scene.input.MouseButton;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import javafx.scene.transform.Rotate;

public class FragatasCreator extends ShapeCreator{
    public FragatasCreator() {
        super(new double[]{
                0, 32,//A
                16, 0,//B
                32, 32
        },Color.rgb(0, 128, 128),Color.rgb(0, 79, 79));
    }

}