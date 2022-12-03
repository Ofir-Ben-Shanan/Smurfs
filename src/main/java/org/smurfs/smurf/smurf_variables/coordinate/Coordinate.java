package org.smurfs.smurf.smurf_variables.coordinate;

public class Coordinate extends GenericCoordinate<Double> {

    private double radius;
    private double theta;
    private double phi;


    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public double getTheta() {
        return theta;
    }

    public void setTheta(double theta) {
        this.theta = theta;
    }

    public double getPhi() {
        return phi;
    }

    public void setPhi(double phi) {
        this.phi = phi;
    }

    public Coordinate(double radius, double theta, double phi) {
        this.radius = radius;
        this.theta = theta;
        this.phi = phi;
    }

    @Override
    void move(Double x1, Double x2, Double x3) {
        this.radius = x1;
        this.phi = x2;
        this.theta = x3;
    }
}
