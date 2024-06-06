package com.example.navalbattle.model.barcos;

import javafx.scene.shape.Polygon;
/**
 * The {@code IShapeCreator} interface serves as a template for the creation of the different types of boats.
 * It declares a handful of standard methods such as setters and getters along with the {@code isWithinBounds()} method
 * that will be defined later in the {@link ShapeCreator} class.
 *
 * @author Nathalia Ortiz
 * @version 1.0
**/
public interface IShapeCreator {

    Polygon getShape();
    void setShape(Polygon shape);
    int getId();
    void setId(int id);
    double getLayoutX();
    void setLayoutX(double layoutX);
    double getLayoutY();
    void setLayoutY(double layoutY);
    int getTurns();
    void setTurns();
    void setHorizontalXBound(double horizontalXBound);
    boolean isWithinBounds(double newX, double newY);
}
