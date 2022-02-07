/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clustering;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author Nes Ch
 */
public class ConverterCSV {

    public String Convert(String path) {
        String newpath = "";
        int columnas = contarColumnas(path);
        int filas = contarFilas(path);

        int j = 0;
        String matriz[][] = new String[contarFilas(path)][contarColumnas(path)];
        try {
            BufferedReader reader = new BufferedReader(new FileReader(path));
            String Line = null;
            FileWriter informecsv = new FileWriter("src/clustering/Fixed.csv");
            while ((Line = reader.readLine()) != null) {
                String[] parts = Line.split(",");
                int totalparts = parts.length;
                for (int i = 0; i < columnas; i++) {

                    if (j < filas) {
                        //  System.out.print(parts[i] + " ");
                        matriz[j][i] = parts[i].toString();
                    }

                }
                //   System.out.print("\n");
                j++;
            }

            for (int f = 0; f < filas; f++) {
                for (int c = 0; c < columnas; c++) {

              //      System.out.print(matriz[f][c] + ",");
                }
                //System.out.print("\n");
            }

         //   System.out.print("\n");

            String AuxFila1 = "";

            String AuxColumnas = "";

            for (int f = 0; f < filas; f++) {

                for (int c = 0; c < columnas; c++) {

                    AuxFila1 = matriz[f][0];
                    // String AuxFila1 = matriz[0][k];
                    AuxColumnas = matriz[f][columnas - 1];

                    matriz[f][columnas - 1] = AuxFila1;
                    matriz[f][0] = AuxColumnas;

                    // System.out.print(AuxColumnas);
                    //System.out.print("\n");
                }

            }

            for (int f = 0; f < filas; f++) {

                for (int c = 0; c < columnas; c++) {

                    if (matriz[f][c] != null) {
                        if (c < columnas - 1) {
                            // System.out.print(matriz[f][c] + ",");
                            informecsv.write(matriz[f][c] + ",");
                        } else {
                            //  System.out.print(matriz[f][c] + "");
                            informecsv.write(matriz[f][c] + "");
                        }

                    }
                }

                System.out.print("\n");
                informecsv.write("\n");
            }
            informecsv.close();

            newpath = "src/clustering/Fixed.csv";
        } catch (IOException e) {
            e.printStackTrace();

        }
        return newpath;
    }

    public static int contarFilas(String path) {

        int filas = 0;

        try {
            BufferedReader reader = new BufferedReader(new FileReader(path));
            String Line = null;

            while ((Line = reader.readLine()) != null) {
                String[] parts = Line.split(",");
                int totalparts = parts.length;
                filas = filas + 1;
            }

        } catch (IOException e) {
            e.printStackTrace();

        }

        return filas;
    }

    public static int contarColumnas(String path) {

        int columnas = 0;

        try {
            BufferedReader reader = new BufferedReader(new FileReader(path));
            String Line = null;

            while ((Line = reader.readLine()) != null) {
                String[] parts = Line.split(",");
                columnas = parts.length;

            }

        } catch (IOException e) {
            e.printStackTrace();

        }

        return columnas;
    }
   


}
