package com.example.navalbattle.model.barcos;

import com.example.navalbattle.model.Exceptions.InvalidCoordinatesException;


import javafx.scene.paint.Color;

public class DestructoresCreator extends ShapeCreator {
    public DestructoresCreator() throws InvalidCoordinatesException {
        super(validatePoints(new double[]{
                0, 32, // A
                16, 0, // B
                32, 32, // C
                16, 32, // D
                32, 64, // E
                0, 64, // F
                16, 32, // D
                0, 32  // G
        }), Color.rgb(228, 140, 255), Color.BLACK);
    }

    // Método de validación público
    public static double[] validatePoints(double[] points) throws InvalidCoordinatesException {
        if (points.length % 2 != 0) {
            throw new InvalidCoordinatesException("El número de coordenadas debe ser par.");
        }
        return points;
    }
}
