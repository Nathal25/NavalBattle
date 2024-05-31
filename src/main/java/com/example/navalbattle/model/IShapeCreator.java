package com.example.navalbattle.model;
import javafx.geometry.Point2D;
import java.util.ArrayList;
import java.util.List;
import javafx.scene.shape.Polygon;

public interface IShapeCreator {
    Polygon getShape();
    void setShape(Polygon shape);
    double getLayoutX();
    void setLayoutX(double layoutX);
    double getLayoutY();
    void setLayoutY(double layoutY);
    int getTurns();
    void resetTurns();
    double[] getVertices();
    double getVerticeIn(int index);
}
