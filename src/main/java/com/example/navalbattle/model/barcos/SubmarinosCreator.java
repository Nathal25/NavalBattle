/**
 * The class {@code SubmarinosCreator} extends the superclass {@link com.example.navalbattle.model.barcos.ShapeCreator}
 * Provides a specific implementation to the creation of the "submarinos" shapes
 *
 * @author Nathalia Ortiz
 * @author Sara Yineth
 * @see com.example.navalbattle.model.barcos.ShapeCreator
 */

package com.example.navalbattle.model.barcos;


import com.example.navalbattle.model.Exceptions.InvalidCoordinatesException;
import javafx.scene.paint.Color;

public class SubmarinosCreator extends ShapeCreator {
    /**
     * Creates a new instance of {@code SubmarinosCreator} with defined coordinates and a specific color for this type of ships.
     * <p>
     *     This constructor invokes the one from the {@code ShapeCreator} superclass with defined points and specific colors.
     *     It also establishes the horizontal bound for this figure.
     * </p>
     * @throws InvalidCoordinatesException if the provided coordinates are not valid.
     */
    public SubmarinosCreator()  throws InvalidCoordinatesException {
        super(validatePoints(new double[]{
                0, 32, 16, 0, 32, 32, 16, 32, 32, 64, 16, 64, 32, 96, 0, 96,
                16, 64, 0, 64, 16, 32, 0, 32
        }), Color.rgb(178, 52, 95), Color.rgb(136, 35, 70));
        setHorizontalXBound(389);
    }

    /**
     * Checks an array of points to make sure it contains an even number of coordinates.
     * @param points the array of points to validate.
     * @return the same array if the validation is successful.
     * @throws InvalidCoordinatesException if the number of coordinates is uneven.
     */
    public static double[] validatePoints(double[] points) throws InvalidCoordinatesException {
        if (points.length % 2 != 0) {
            throw new InvalidCoordinatesException("El número de coordenadas debe ser par.");
        }
        return points;
    }
}

