package com.example.navalbattle.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class PositionConverter {

    public static void convertirYImprimirPosiciones(DraggableMaker draggableMaker) {
        Map<Integer, String> posiciones = draggableMaker.getUltimasPosiciones();

        // Lista para almacenar las posiciones en formato alfanumérico
        List<String> posicionesAlfanumericas = new ArrayList<>();

       // System.out.println("Posiciones finales en grid 32x32 de todos los barcos:");
        for (Map.Entry<Integer, String> entry : posiciones.entrySet()) {
            int id = entry.getKey();
            String posicion = entry.getValue();

            // Extraer las coordenadas x e y de la cadena de posición
            String[] partes = posicion.split(": \\(")[1].replace(")", "").split(", ");
            double x = Double.parseDouble(partes[0]);
            double y = Double.parseDouble(partes[1]);

            // Convertir a posición de cuadrícula
            String posicionGrid = convertirAGrid(x, y, draggableMaker.getPositionX1(), draggableMaker.getPositionY1());

            // Convertir la posición de cuadrícula al formato alfanumérico
            String posicionAlfanumerica = convertirAFormatoAlfanumerico(posicionGrid);

            // Almacenar la posición en formato alfanumérico en la lista
            posicionesAlfanumericas.add(posicionAlfanumerica);

            // Imprimir la posición en ambos formatos
            //System.out.println("Barco " + id + ": Alfanumérico - " + posicionAlfanumerica + ", Coordenadas - " + posicionGrid);
        }

        // Imprimir la lista de posiciones en formato alfanumérico
        //System.out.println("Posiciones en formato alfanumérico:");
        for (String posicionAlfanumerica : posicionesAlfanumericas) {
            System.out.println(posicionAlfanumerica);
        }
    }

    //Conversiones:

    private static String convertirAGrid(double x, double y, double positionX1, double positionY1) {
        int column = (int) ((x - positionX1) / 32) + 1;
        int row = (int) ((y - positionY1) / 32) + 1;
        return "(" + row + ", " + column + ")";
    }

    //ConvierteAFormatoAlfanumerico
    private static String convertirAFormatoAlfanumerico(String posicionGrid) {
        int row = Integer.parseInt(posicionGrid.substring(1, posicionGrid.indexOf(",")));
        int column = Integer.parseInt(posicionGrid.substring(posicionGrid.indexOf(",") + 2, posicionGrid.length() - 1));
        char columnChar = (char) ('A' + column - 1);
        return columnChar + Integer.toString(row);
    }
    public static List<Integer> getPosicionesValidas(DraggableMaker draggableMaker) {
        return draggableMaker.getValidPos();
    }



}
