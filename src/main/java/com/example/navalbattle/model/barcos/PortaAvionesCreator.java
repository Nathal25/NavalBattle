package com.example.navalbattle.model.barcos;

import com.example.navalbattle.model.Exceptions.InvalidCoordinatesException;
import javafx.scene.paint.Color;

public class PortaAvionesCreator extends ShapeCreator {
    public PortaAvionesCreator()  throws InvalidCoordinatesException  {
        super(validatePoints(new double[]{
                0, 32,
                16, 0,
                32, 32,
                16, 32,
                32, 64,
                16, 64,
                32, 96,
                16, 96,
                32, 128,
                0, 128,
                16, 96,
                0, 96,
                16, 64,
                0, 64,
                16, 32,
                0, 32
        }), Color.RED, Color.BLACK);
    }

    public static double[] validatePoints(double[] points) throws InvalidCoordinatesException {
        if (points.length % 2 != 0) {
            throw new InvalidCoordinatesException("El número de coordenadas debe ser par.");
        }
        return points;
    }
}

