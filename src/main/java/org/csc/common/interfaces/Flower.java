package org.csc.common.interfaces;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.csc.common.Specie;

@Getter
public abstract class Flower {
  private final Double sepal_length;
  private final Double sepal_width;
  private final Double petal_length;
  private final Double petal_width;

  public Flower(Double sepal_length, Double sepal_width, Double petal_length, Double petal_width) {
    this.sepal_length = sepal_length;
    this.sepal_width = sepal_width;
    this.petal_length = petal_length;
    this.petal_width = petal_width;
  }
}
