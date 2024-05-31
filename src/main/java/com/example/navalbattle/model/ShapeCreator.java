package com.example.navalbattle.model;

import javafx.scene.input.MouseButton;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import javafx.scene.transform.Rotate;

public class ShapeCreator implements IShapeCreator {
    protected Polygon shape;
    protected double layoutX, layoutY;
    protected int turns = 1;

    public ShapeCreator(double[] points, Color fillColor, Color strokeColor) {
        shape = new Polygon(points);
        shape.setFill(fillColor);
        shape.setStroke(strokeColor);
        shape.setStrokeWidth(1);

        shape.setOnMouseClicked(this::handleRotateClick);
    }

    @Override
    public Polygon getShape() {
        return shape;
    }

    @Override
    public void setShape(Polygon shape) {
        this.shape = shape;
    }

    @Override
    public double getLayoutX() {
        return layoutX;
    }

    @Override
    public void setLayoutX(double layoutX) {
        this.layoutX = layoutX;
        shape.setLayoutX(layoutX);
    }

    @Override
    public double getLayoutY() {
        return layoutY;
    }

    @Override
    public void setLayoutY(double layoutY) {
        this.layoutY = layoutY;
        shape.setLayoutY(layoutY);
    }

    @Override
    public int getTurns() {
        return turns;
    }

    @Override
    public void resetTurns() {
        turns = 1;
    }

    private void handleRotateClick(javafx.scene.input.MouseEvent mouseEvent) {
        if (mouseEvent.getButton() == MouseButton.SECONDARY) { // botón derecho
            shape.getTransforms().add(new Rotate(90, 16, 48));
            System.out.println("Shape rotated");
            turns++;
            if (turns == 4) {
                resetTurns();
            }
        }
    }
}