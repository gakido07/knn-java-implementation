package org.csc.models;

import org.csc.common.interfaces.Flower;

/** Represents the data model of an iris flower that is yet to be identified */
public class UnknownIrisFlower extends Flower {
  public UnknownIrisFlower(Double sepal_length, Double sepal_width, Double petal_length, Double petal_width) {
    super(sepal_length, sepal_width, petal_length, petal_width);
  }
}
