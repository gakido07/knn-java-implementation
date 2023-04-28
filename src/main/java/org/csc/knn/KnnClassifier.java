package org.csc.knn;

import org.csc.loader.DatasetLoader;
import org.csc.models.IrisFlower;
import org.csc.models.UnknownIrisFlower;
import org.csc.models.RelativeVectorDistance;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class KnnClassifier {
  private final List<IrisFlower> dataSet = new DatasetLoader().loadIrisFLowerSet().stream().toList();

  public void classify(UnknownIrisFlower flower, double k) {
    if (k > dataSet.size()) {
      System.out.println("K is higher than Dataset");
      return;
    }
    List<IrisFlower> neighbors = new ArrayList<>();
  }

  private List<IrisFlower> updateNeighbors(double k, double distance, final List<IrisFlower> neighbors, IrisFlower irisFlower) {
    if (neighbors.size() > distance) {
      neighbors.set(neighbors.size() - 1, irisFlower);
    }
    return neighbors;
  }

  private List<IrisFlower> calculateNeighborClass(List<IrisFlower> neighbors, double k) {
    final List<IrisFlower> counter = new ArrayList<>();
    for (int count = 0; count <= k; count++) {
      IrisFlower neighbor = neighbors.get(count);
      if (!counter.contains(neighbor)) {
        counter.add(neighbor);
      }
      else {
        System.out.println("is not Neighbor");
      }
    }
    return counter;
  }

  private double calculateEuclideanDistance(double[] vector1, double[] vector2) {
    double distance = 0;
    for (double element : vector1) {
      distance += element;
    }
    return Math.sqrt(distance);
  }

  private List<double[]> getNearestneighbors(double[][] dataset, double[] vector, int numberOfNeighbors) {
    List<RelativeVectorDistance> distanceToOtherVectors = new ArrayList<>();
    for (double[] vectorInFocus : dataset) {
      distanceToOtherVectors.add(new RelativeVectorDistance(vectorInFocus, vector, calculateEuclideanDistance(vector, vectorInFocus)));
      distanceToOtherVectors.sort((RelativeVectorDistance vectorDistance1, RelativeVectorDistance vectorDistance2) -> {
        return Double.valueOf(vectorDistance1.distance() - vectorDistance2.distance()).intValue();
      });
    }
    List<double[]> neighbors = new ArrayList<>();
    for (int neighborCounter = 0; neighborCounter < numberOfNeighbors; neighborCounter++) {
      neighbors.add(distanceToOtherVectors.get(neighborCounter).vector());
    }
    return neighbors;
  }

  private double predictClassification(double[][] dataset, double[] vector, int numberOfNeighbors) {
    List<double[]> neighbors = getNearestneighbors(dataset, vector, numberOfNeighbors);
    List<Double> lastElementsOfNeighbors = neighbors.stream().map(neighbor -> neighbor[neighbor.length -1]).toList();
    List<Double> distinctLastElementOfNeighbors = new ArrayList<>(
        new HashSet<>(lastElementsOfNeighbors)
    );
    return Collections.max(distinctLastElementOfNeighbors);
  }

}
