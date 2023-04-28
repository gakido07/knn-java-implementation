package org.csc.knn;

import org.csc.loader.DatasetLoader;
import org.csc.models.IrisFlower;
import org.csc.models.UnknownIrisFlower;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

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
//  private double calculateEuclideanDistance(double x1, double y1, double x2, double y2) {
//    return Math.sqrt((y2 - y1) * (y2 - y1) + (x2 - x1) * (x2 - x1));
//  }


}
