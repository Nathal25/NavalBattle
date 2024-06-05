package com.example.navalbattle.model;

import com.example.navalbattle.model.Touched;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;

public class Water {
    private static final String AGUA_IMAGE_URL = "/com/example/navalbattle/images/Agua.png";

    public static void addAgua(StackPane stackPane) {
        try {
            if (!Touched.maximumCounter()) {
                Image aguaImage = new Image(Water.class.getResource(AGUA_IMAGE_URL).toExternalForm());
                ImageView imageView = new ImageView(aguaImage);

                //Se establece manualmente el tamaño
                double imageWidth = 30;
                double imageHeight = 30;
                imageView.setFitWidth(imageWidth);
                imageView.setFitHeight(imageHeight);

                //ImageView al StackPane
                stackPane.getChildren().add(imageView);
            } else {
                System.out.println("");
            }
        } catch (Exception e) {
            System.out.println("Error: La URL de la imagen es incorrecta");

        }
    }
}

