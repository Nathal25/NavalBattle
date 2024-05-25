package com.example.navalbattle.model;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;


public class FiguresCreator {
    /**
     *@author Nathalia Ortiz
     */
    private Rectangle rectangle;
    private int id;


    public FiguresCreator(){
        rectangle = new Rectangle(32,32, Color.rgb(150,255,243));
        rectangle.setStyle(
                "-fx-border-width: 1; " +
                        "-fx-border-style: solid;" +
                        "-fx-stroke: rgba(0,0,0,0.91); " +
                        "-fx-stroke-type: inside"
        );
        this.id = id;
    }
    public Rectangle getRectangle() {
        return rectangle;
    }
    public void setRectangle(Rectangle rectangle) {
        this.rectangle = rectangle;
    }

    public int getId() {return id;}
    public void setId(int id) {this.id = id;}
}