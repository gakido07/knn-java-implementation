package org.csc;

import org.csc.knn.KnnClassifier;
import org.csc.loader.DatasetLoader;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        KnnClassifier knnClassifier = new KnnClassifier();
        final double[][] dataset = new DatasetLoader().loadIrisFLowerSet();
        for (double[] d: dataset) {
            System.out.println(Arrays.toString(d));
        }
        System.out.println(knnClassifier.classify(dataset, new double[]{5.2, 2.7, 3.9, 1.4}, 5));
    }
}
