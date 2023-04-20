package org.csc.common;

public enum Specie {
  IRIS_VERSICOLOR, IRIS_VIRGINICA;

  public boolean isVersicolor(String value) {
    return value.equals("Iris-virginica");
  }
}
