package com.example.navalbattle.model;

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
}