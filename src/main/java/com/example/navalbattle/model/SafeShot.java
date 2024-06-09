package com.example.navalbattle.model;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * The class {@code SafeShot} represents a missed shot on the game.
 * It is visualized as an image of water on the board.
 */
public class SafeShot {

    private ImageView imgWater;
    private double posImgX, posImgY;

    /**
     * Constructor that initializes the "water" image and sets its size.
     */
    public SafeShot(){
        imgWater = new ImageView(new Image(String.valueOf(getClass().getResource("/com/example/navalbattle/images/Agua.png"))));
        imgWater.setFitHeight(32);
        imgWater.setFitWidth(32);

    }

    /**
     * Returns the imageView that contains the "water" .
     * @return the imageView containing the "water" image.
     */
    public ImageView getImageView(){
        return imgWater;
    }

    /**
     * Returns the X position of the image on the board.
     * @return The X position of the "water" image on the board.
     */
    public double getPosImgX(){
        return posImgX;
    }

    /**
     * Returns the Y position of the image on the board.
     * @return the Y position of the "water" image on the board.
     */
    public double getPosImgY(){
        return posImgY;
    }

    /**
     * Sets the X-coordinate of the "water" image on the board and updates the X-coordinate of the ImageView.
     * @param posImgX The new X-coordinate of the water image.
     */
    public void setPosImgX(double posImgX){
        this.posImgX = posImgX;
        imgWater.setLayoutX(posImgX);
    }

    /**
     * Sets the Y-coordinate of the "water" image on the board and updates the Y-coordinate of the ImageView.
     * @param posImgY The new Y-coordinate of the water image
     */
    public void setPosImgY(double posImgY){
        this.posImgY = posImgY;
        imgWater.setLayoutY(posImgY);
    }
}