package com.example.navalbattle.model.barcos;

import javafx.scene.shape.Polygon;

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
    void resetTurns();
}
