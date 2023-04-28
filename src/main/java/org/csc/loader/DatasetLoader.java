package org.csc.loader;

import lombok.NoArgsConstructor;
import org.csc.common.Specie;
import org.csc.lib.CsvUtil;
import org.csc.models.IrisFlower;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@NoArgsConstructor
public class DatasetLoader {
  private final CsvUtil csvUtil = new CsvUtil();
  /** This loads and transforms the data from the csv file into a collection of IrisFlowerSet Objects  */
  public Set<IrisFlower> loadIrisFLowerSet() {
    List<List<String>> irisFlowerSet = csvUtil.readCsv("/");
    return irisFlowerSet.stream().map(flower -> {
      Double sepal_length =  Double.parseDouble(flower.get(0));
      Double sepal_width = Double.parseDouble(flower.get(1));
      Double petal_length = Double.parseDouble(flower.get(2));
      Double petal_width = Double.parseDouble(flower.get(3));
      Specie specie = Specie.valueOf(flower.get(4));
      return new IrisFlower(sepal_length, sepal_width, petal_length, petal_width, specie);
    }).collect(Collectors.toSet());
  }

}
