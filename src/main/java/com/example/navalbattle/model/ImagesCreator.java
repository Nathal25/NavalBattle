package com.example.navalbattle.model;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class ImagesCreator {
    /**
     * 
     */
    private ImageView imageView;


    public ImagesCreator(){
        imageView = new ImageView(new Image(String.valueOf(getClass().getResource("/com/example/navalbattle/images/basicBackground.png"))));
        imageView.setFitHeight(32);
        imageView.setFitWidth(32);

    }
    public ImageView getImageView() {
        return imageView;
    }
    public void setImageView(ImageView imageView) {
        this.imageView = imageView;
    }
}
