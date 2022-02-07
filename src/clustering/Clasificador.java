/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clustering;

import java.awt.Desktop;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Nes Ch
 */
public class Clasificador {

    public void ClasificadorCluster() throws FileNotFoundException, IOException {
        File file = new File("src/clustering/informe.txt");
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            int clusters_assigned = 0;
            int cp_index = 1;
            List<String> clusters = new ArrayList<String>();
            List<String> cluster_asignados = new ArrayList<String>();
            List<String> casos_de_prueba = new ArrayList<String>();

            FileWriter informe = new FileWriter("src/clustering/informeFinal.txt");
            File file2 = new File("src/clustering/informe.txt");
            try (BufferedReader br1 = new BufferedReader(new FileReader(file2))) {

                String Line2;
                while ((Line2 = br1.readLine()) != null) {

                    informe.write(Line2);

                    informe.write("\n");

                }

            } catch (IOException e) {
                e.printStackTrace();

            }

            informe.write("\n");
            informe.write("ASIGNACIÓN DE CASOS DE PRUEBA A LOS CLUSTER");
            informe.write("\n");
            informe.write("\n");
            while ((line = br.readLine()) != null) {
                int index = 0;
                if (line.contains("Number of clusters:")) {
                    System.out.println("Numero de clusters:" + line.substring(line.indexOf(":") + 1));
                    informe.write("Numero de clusters:" + line.substring(line.indexOf(":") + 1) + "\n");
                }

                if (line.contains("<-- assigned to cluster")) {
                    String[] words = line.split(" ");
                    for (String word : words) {
                        if (word.matches("[0-9]+")) {
                            System.out.println("Cluster asignados: " + word);
                            informe.write("Cluster asignados: " + word + "\n");
                            cluster_asignados.add(word);
                            clusters_assigned++;
                        }
                    }
                }

                if (line.contains("|")) {
                    String[] words = line.split(" ");
                    String cluster_asign = "";
                    for (String word : words) {

                        if (word.matches("[0-9]+")) {
                            cluster_asign += word;
                            index++;
                        }
                        if (index == clusters_assigned) {
                            index = 0;
                            clusters.add(cluster_asign);
                            cp_index++;
                        }
                    }

                    String[] words2 = line.split("\\|");
                    for (String word : words2) {
                        if (word.endsWith("r")) {
                            casos_de_prueba.add(word);
                        }
                    }
                }
            }

            for (int j = 0; j < clusters_assigned; j++) {
                System.out.print("Cluster " + cluster_asignados.get(j) + ": ");
                informe.write("Cluster " + cluster_asignados.get(j) + ": ");
                for (int i = 0; i < clusters.size(); i++) {
                    if (getClusterAssigned(clusters.get(i)) == j) {
                        System.out.print(casos_de_prueba.get((i)) + ",");
                        informe.write(casos_de_prueba.get((i)) + ",");

                    }
                }
                System.out.println("");
                informe.write("\n");
            }

            informe.close();

            File objetofile = new File("src/clustering/informeFinal.txt");
            Desktop.getDesktop().open(objetofile);

        }
    }

    private static int getClusterAssigned(String line) {
        int index = 0;
        String[] words = line.split("");
        for (String word : words) {
            if (!word.matches("0")) {

                return index;
            }
            index++;
        }
        return index;
    }

}
