package org.smurfs.smurf.smurf_variables.coordinate;

import org.smurfs.smurf.IFactory;

public class CoordinateFactory implements IFactory<Coordinate> {

    private enum Values {


        MIN_RADIUS(0.0),

        MAX_RADIUS(6371),

        MIN_THETA(0.0),

        MAX_THETA(Math.PI),

        MIN_PHI(0.0),

        MAX_PHI(Math.PI);
        private final double value;

        Values(double value) {
            this.value = value;
        }

        public double value() {
            return value;
        }
    }

    @Override
    public Coordinate create() {
        return new Coordinate(randomSingleCoordinate(Values.MIN_RADIUS.value(), Values.MAX_RADIUS.value()),
                randomSingleCoordinate(Values.MIN_THETA.value(), Values.MAX_THETA.value()),
                randomSingleCoordinate(Values.MIN_PHI.value(), Values.MAX_PHI.value()));    }

    private static double randomSingleCoordinate(double minValue, double maxValue) {

        return minValue + (Math.random() * ((maxValue - minValue) + 1));

    }
}
