package com.example.navalbattle.model;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;

public class Touched {

    private static final String TOCADO_IMAGE_URL = "/com/example/navalbattle/images/Tocado.png";

    private static final int MAX_TOCADO = 20;

    private static int counter = 0;


    public static void addTocado(StackPane stackPane) {
        if (counter < MAX_TOCADO) {
            Image tocadoImage = new Image(Touched.class.getResource(TOCADO_IMAGE_URL).toExternalForm());
            ImageView imageView = new ImageView(tocadoImage);

            //Se establece manualmente el tamaño
            double imageWidth = 30;
            double imageHeight = 30;
            imageView.setFitWidth(imageWidth);
            imageView.setFitHeight(imageHeight);

            //ImageView al StackPane
            stackPane.getChildren().add(imageView);
            counter++;
        } else {
            System.out.println("El contador ha alcanzado el limite de 20.");
        }

    }
    public static boolean maximumCounter() {
        return counter >= MAX_TOCADO;
    }
}
