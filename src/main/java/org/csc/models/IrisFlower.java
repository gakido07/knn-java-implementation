package org.csc.models;

import lombok.Getter;
import org.csc.common.Specie;
import org.csc.common.interfaces.Flower;
import org.javatuples.Quartet;

@Getter
public class IrisFlower extends Flower {
  private final Specie specie;
  public IrisFlower(Double sepal_length, Double sepal_width, Double petal_length, Double petal_width, Specie specie) {
    super(sepal_length, sepal_width, petal_length, petal_width);
    this.specie = specie;
  }

  public Quartet<Double, Double, Double, Double> toVector() {
    return Quartet.with(getSepal_length(), getSepal_width(), getPetal_length(), getPetal_width());
  }

  public Double[] toVectorArray() {
    return (Double[]) toVector().toArray();
  }
}
