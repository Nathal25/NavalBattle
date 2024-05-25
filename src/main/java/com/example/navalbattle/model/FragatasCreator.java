package com.example.navalbattle.model;

import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;

public class FragatasCreator {
    private Polygon fragata;

    private double layoutX;
    private double layoutY;

    public FragatasCreator() {
        fragata = new Polygon(
                0,32,//A
                16,0,//B
                32,32
        );
        fragata.setFill(Color.rgb(0,128,128));
        fragata.setStroke(Color.rgb(0,79,79));
        fragata.setStrokeWidth(1);
    }
    public Polygon getFragata() {
        return fragata;
    }
    public void setFragata(Polygon fragata) {this.fragata = fragata;}

    public double getLayoutX() {return layoutX;}
    public void setLayoutX(double layoutX) {
        this.layoutX = layoutX;
        fragata.setLayoutX(layoutX);
    }

    public double getLayoutY() {return layoutY;}
    public void setLayoutY(double layoutY) {
        this.layoutY = layoutY;
        fragata.setLayoutY(layoutY);
    }

}