package org.csc.loader;

import lombok.NoArgsConstructor;
import org.csc.common.Specie;
import org.csc.lib.CsvUtil;
import org.csc.models.IrisFlower;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@NoArgsConstructor
public class DatasetLoader {

  private final CsvUtil csvUtil = new CsvUtil();
  /** This loads and transforms the data from the csv file into a 2d array  */
  public double[][] loadIrisFLowerSet() {
    String datasetPath = Objects.requireNonNull(getClass().getClassLoader().getResource("IRIS.csv")).getPath();
    List<List<String>> irisFlowerSet = csvUtil.readCsv(datasetPath);
    double[][] dataset = new double[irisFlowerSet.size()][irisFlowerSet.get(0).size() - 1];
    for (int i = 0; i < irisFlowerSet.size(); i++) {
      List<String> datapoint = irisFlowerSet.get(i);
      for (int j = 0; j < datapoint.size(); j++) {
        String data = datapoint.get(j);
        if (i > 0 && j < 4) {
          dataset[i][j] = Double.parseDouble(data);
        }
      }
    }
    return dataset;
  }
}
