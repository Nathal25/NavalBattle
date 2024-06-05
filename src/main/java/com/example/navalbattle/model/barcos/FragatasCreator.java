package com.example.navalbattle.model.barcos;

import com.example.navalbattle.model.Exceptions.InvalidCoordinatesException;
import javafx.scene.paint.Color;

public class FragatasCreator extends ShapeCreator {
    public FragatasCreator() throws InvalidCoordinatesException {
        super(validatePoints(new double[]{
                0, 32,//A
                16, 0,//B
                32, 32
        }),Color.rgb(0, 128, 128),Color.rgb(0, 79, 79));
    }

    public static double[] validatePoints(double[] points) throws InvalidCoordinatesException {
        if (points.length % 2 != 0) {
            throw new InvalidCoordinatesException("El número de coordenadas debe ser par.");
        }
        return points;
    }
}