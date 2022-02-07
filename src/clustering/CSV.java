/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clustering;

import java.awt.Desktop;
import java.io.File;
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
public class CSV {

    //Carga de la data
    public void Clustering(String path, int seed) throws Exception {
        ConverterUtils.DataSource source;
        source = new ConverterUtils.DataSource(path);
        Instances data = source.getDataSet();

        /*
        //Trasnforma  numeric to nominal  
        NumericToNominal convert = new NumericToNominal();
        String[] options = new String[2];
        options[0] = "-R";
        options[1] = Integer.toString(data.classIndex() + 2);  //range of variables to make numeric

        convert.setOptions(options);
        convert.setInputFormat(data);

        Instances newData = Filter.useFilter(data, convert);*/
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

        FileWriter informe = new FileWriter("src/clustering/informe.txt");
        String SeedInf = "Seed : " + clusterer.getSeed();
        informe.write(SeedInf);
        informe.write("\n");
        informe.write(eval.clusterResultsToString());
        informe.close();
        // Clasificador clasificar = new Clasificador();
        // clasificar.ClasificadorCluster(informe, SeedInf);
    }

}
