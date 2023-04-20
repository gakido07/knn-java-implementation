package org.csc.models;

import lombok.AllArgsConstructor;
import org.csc.common.Specie;

@AllArgsConstructor
public class IrisFlower {
  private Double sepal_length;
  private Double sepal_width;
  private Double petal_length;
  private Double petal_width;
  private Specie specie;
}
