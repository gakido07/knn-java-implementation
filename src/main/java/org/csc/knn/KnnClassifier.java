package org.csc.knn;

import org.csc.models.RelativeVectorDistance;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class KnnClassifier {

  public double classify(double[][] dataset, double[] vector, int numberOfNeighbors) {
    return predictClassification(dataset, vector, numberOfNeighbors);
  }

  /**
   * This function is used the distance between two data points. Look up Euclidean distance
   */
  private double calculateEuclideanDistance(double[] vector1, double[] vector2) {
    double distance = 0;
    for (int count = 0; count < vector1.length; count++) {
      distance += Math.pow((vector1[count] - vector2[count]), 2);
    }
    return Math.sqrt(distance);
  }


  /**
   * This functions finds the distance between all datapoints in the dataset to the target datapoint
   * and returns a list with a length equal to the number of neighbors defined
   */
  private List<double[]> getNearestNeighbors(
    double[][] dataset, double[] vector, int numberOfNeighbors
  ) {
    List<RelativeVectorDistance> distanceToOtherVectors = new ArrayList<>();
    for (double[] vectorInFocus : dataset) {
      distanceToOtherVectors.add(new RelativeVectorDistance(vectorInFocus,
        vector,
        calculateEuclideanDistance(vector, vectorInFocus)
      ));
      distanceToOtherVectors.sort((RelativeVectorDistance vectorDistance1, RelativeVectorDistance vectorDistance2) -> Double.valueOf(
        vectorDistance1.distance() - vectorDistance2.distance()).intValue());
    }
    List<double[]> neighbors = new ArrayList<>();
    for (int neighborCounter = 0; neighborCounter < numberOfNeighbors; neighborCounter++) {
      neighbors.add(distanceToOtherVectors.get(neighborCounter).vector());
    }
    return neighbors;
  }

  /**
   * Composed function to predict classification
   */
  private double predictClassification(double[][] dataset, double[] vector, int numberOfNeighbors) {
    List<double[]> neighbors = getNearestNeighbors(dataset, vector, numberOfNeighbors);
    List<Double> lastElementsOfNeighbors = neighbors.stream()
      .map(neighbor -> neighbor[neighbor.length - 1])
      .toList();
    return Collections.max(lastElementsOfNeighbors);
  }

}
