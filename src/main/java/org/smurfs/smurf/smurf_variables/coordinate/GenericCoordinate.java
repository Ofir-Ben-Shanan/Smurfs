package org.smurfs.smurf.smurf_variables.coordinate;

public abstract class GenericCoordinate<T> {
    T x1;
    T x2;
    T x3;

    abstract void move(T x1,T x2, T x3);



}
