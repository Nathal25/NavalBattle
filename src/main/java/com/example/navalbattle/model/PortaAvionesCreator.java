package com.example.navalbattle.model;

import javafx.scene.input.MouseButton;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;

public class PortaAvionesCreator extends ShapeCreator{
    public PortaAvionesCreator() {
        super(new double[]{
                0, 32, 16, 0, 32, 32, 16, 32, 32, 64, 16, 64, 32, 96, 16, 96,
                32, 128, 0, 128, 16, 96, 0, 96, 16, 64, 0, 64, 16, 32, 0, 32
        }, Color.RED, Color.BLACK);
    }
}
