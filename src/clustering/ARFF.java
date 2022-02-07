/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clustering;

import java.awt.Desktop;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import weka.clusterers.ClusterEvaluation;
import weka.clusterers.EM;
import weka.core.Instances;
import weka.core.converters.ConverterUtils;
import weka.filters.Filter;
import weka.filters.unsupervised.attribute.NumericToNominal;
import weka.filters.unsupervised.attribute.Remove;

/**
 *
 * @author Nes Ch
 */
public class ARFF {
    
    public void Clustering(String path, int seed) throws Exception{
        Instances data = new Instances(new BufferedReader(new FileReader(path)));

//Filtro de clases        
        data.setClassIndex(data.numAttributes() - 1);
        Remove filter = new Remove();
        filter.setAttributeIndices("" + (data.classIndex() + 1));
        filter.setInputFormat(data);
        Instances dataClusterer = Filter.useFilter(data, filter);
//Construir Cluster
        EM clusterer = new EM();
        
  
        String Options = "-I 100 -N -1 -X 10 -max -1 -ll-cv 1.0E-6 -ll-iter 1.0E-6 -M 1.0E-6 -K 10 -num-slots 1 -S " + seed;
        clusterer.setOptions(weka.core.Utils.splitOptions(Options));
        clusterer.buildClusterer(dataClusterer);
//Evaluar Cluster
        ClusterEvaluation eval = new ClusterEvaluation();
        
        eval.setClusterer(clusterer);
        eval.evaluateClusterer(data);

        //Imprimir Resultados 

       //10 50 100 250 500 750 1000

        FileWriter informe = new FileWriter("src/clustering/informeCluster.txt");
        String SeedInf = "Seed : "+ clusterer.getSeed();
        informe.write(eval.clusterResultsToString());
 
        informe.close();
      ///  Clasificador clasificar = new Clasificador();
      ///  clasificar.ClasificadorCluster(informe, SeedInf);
    }
    
}
