package org.csc.models;


/** This is a record used to represent datapoints and their relative distance to a specific datapoint */
public record RelativeVectorDistance(double[] vector, double[] VectorInFocus, double distance) {
}
