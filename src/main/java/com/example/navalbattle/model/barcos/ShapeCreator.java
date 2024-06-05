package com.example.navalbattle.model.barcos;

import com.example.navalbattle.model.DraggableMaker;
import javafx.scene.input.MouseButton;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;

public class ShapeCreator implements IShapeCreator {
    protected int id;
    protected Polygon shape;
    protected double layoutX, layoutY;
    protected int turns = 1;
    protected double horizontalXBound;


    public ShapeCreator(double[] points, Color fillColor, Color strokeColor) {
        shape = new Polygon(points);
        shape.setFill(fillColor);
        shape.setStroke(strokeColor);
        shape.setStrokeWidth(1);
        shape.setOnMouseClicked(this::handleRotateClick);
    }
    @Override
    public void setId(int id) {
        this.id = id;
    }

    @Override
    public int getId() {
        return id;
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
    public void setTurns() {
        turns=1;
    }
    @Override
    public void setHorizontalXBound(double horizontalXBound){
        this.horizontalXBound = horizontalXBound;
    }
    @Override
    public boolean isWithinBounds(double newX, double newY) {
        for (int i = 0; i < shape.getPoints().size(); i += 2){
            double x = shape.getPoints().get(i);
            double y = shape.getPoints().get(i + 1);

            double transformedX = newX + x;
            double transformedY = newY + y;

            if (turns == 1) {
                if (transformedX < 0 || transformedX > 737 || transformedY < 0 || transformedY > 410) {
                    return false;
                }
            }
            else if (turns == 2){
                if (transformedX < 0 || transformedX > horizontalXBound || transformedY < 0 || transformedY > 410) {
                    return false;
                }
            }
        }
        return true;
    }

    private void handleRotateClick(javafx.scene.input.MouseEvent mouseEvent) {
        if (mouseEvent.getButton() == MouseButton.SECONDARY) { // botón derecho
            String idStr = String.valueOf(getId());

                if (idStr.charAt(0) == '4') {
                    if (layoutX <= 261 && layoutY <= 277) {
                        if (turns == 1) {
                            shape.getPoints().setAll(0.0, 16.0, 32.0, 0.0, 32.0, 16.0, 64.0, 0.0, 64.0, 16.0, 96.0, 0.0, 96.0, 16.0, 128.0, 0.0, 128.0, 32.0, 96.0, 16.0, 96.0, 32.0, 64.0, 16.0, 64.0, 32.0, 32.0, 16.0, 32.0, 32.0);
                        } else if (turns == 2) {
                            shape.getPoints().setAll(0.0, 32.0, 16.0, 0.0, 32.0, 32.0, 16.0, 32.0, 32.0, 64.0, 16.0, 64.0, 32.0, 96.0, 16.0, 96.0, 32.0, 128.0, 0.0, 128.0, 16.0, 96.0, 0.0, 96.0, 16.0, 64.0, 0.0, 64.0, 16.0, 32.0, 0.0, 32.0);
                        }
                    }
                }
                else if(idStr.charAt(0) == '3') {
                    if (layoutX <= 293 && layoutY <= 309) {
                        if (turns == 1) {
                            shape.getPoints().setAll(0.0, 16.0, 32.0, 0.0, 32.0, 16.0, 64.0, 0.0, 64.0, 16.0, 96.0, 0.0, 96.0, 32.0, 64.0, 16.0, 64.0, 32.0, 32.0, 16.0, 32.0, 32.0);
                        } else if (turns == 2) {
                            shape.getPoints().setAll(0.0, 32.0, 16.0, 0.0, 32.0, 32.0, 16.0, 32.0, 32.0, 64.0, 16.0, 64.0, 32.0, 96.0, 0.0, 96.0,
                                    16.0, 64.0, 0.0, 64.0, 16.0, 32.0, 0.0, 32.0);
                        }
                    }
                }
                else if(idStr.charAt(0) == '2') {
                    if (layoutX != 357 && layoutY != 373) {
                        if (turns == 1) {
                            shape.getPoints().setAll(0.0, 16.0, 32.0, 0.0, 32.0, 16.0, 64.0, 0.0, 64.0, 32.0, 32.0, 16.0, 32.0, 32.0);
                        } else if (turns == 2) {
                            shape.getPoints().setAll(0.0, 32.0, 16.0, 0.0, 32.0, 32.0, 16.0, 32.0, 32.0, 64.0, 0.0, 64.0, 16.0, 32.0, 0.0, 32.0);
                        }
                    }
                }
                else if(idStr.charAt(0) == '1') {
                    if (layoutX != 357 && layoutY != 373) {
                        if (turns == 1) {
                            shape.getPoints().setAll(0.0, 16.0, 32.0, 0.0, 32.0, 32.0);
                        } else if (turns == 2) {
                            shape.getPoints().setAll(0.0, 32.0, 16.0, 0.0, 32.0, 32.0);
                        }
                    }
                }
                turns++;
                if (turns>2){
                    setTurns();
                }
                System.out.println("La cantidad de giros son "+turns);
                setLayoutX(shape.getLayoutX()); // Actualizar layoutXsetLayoutY(shape.getLayoutY()); // Actualizar layoutY

            System.out.println("Shape rotated");
        }
    }
}

