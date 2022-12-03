package org.smurfs.smurf;

import org.smurfs.smurf.smurf_variables.FirstNames;
import org.smurfs.smurf.smurf_variables.LastNames;
import org.smurfs.smurf.smurf_variables.coordinate.Coordinate;

import java.time.Duration;
import java.time.OffsetDateTime;
import java.util.UUID;

public class Smurf {

    private static final long LIFE_EXPECTATION = 5;
    private OffsetDateTime creationTime;
    private OffsetDateTime lastChangeTime;
    private Duration lifeExpectation;
    private FirstNames firstName;
    private LastNames lastName;
    private UUID id;
    private Coordinate coordinate;


    public Smurf(FirstNames firstName, LastNames lastName, UUID id, Coordinate coordinate) {
        this.creationTime = OffsetDateTime.now();
        this.firstName = firstName;
        this.lastName = lastName;
        this.id = id;
        this.coordinate = coordinate;
        lifeExpectation = Duration.ofSeconds(LIFE_EXPECTATION);
        lastChangeTime = creationTime;

    }

    public Duration getLifeExpectation() {
        return lifeExpectation;
    }

    public Coordinate getCoordinate() {
        return coordinate;
    }

    public OffsetDateTime getCreationTime() {
        return creationTime;
    }

    public FirstNames getFirstName() {
        return firstName;
    }

    public LastNames getLastName() {
        return lastName;
    }

    public UUID getId() {
        return id;
    }

    public void setCreationTime(OffsetDateTime creationTime) {
        this.creationTime = creationTime;
    }

    public void setFirstName(FirstNames firstName) {
        this.firstName = firstName;
    }

    public void setLastChangeTime(OffsetDateTime lastChangeTime) {
        this.lastChangeTime = lastChangeTime;
    }

    public void setCoordinate(Coordinate coordinate) {
        this.coordinate = coordinate;
    }

    public void setLastName(LastNames lastName) {
        this.lastName = lastName;
    }

    public void setId(UUID id) {
        this.id = id;
    }


    public void setSmurf(Smurf smurf) {

        creationTime = smurf.getCreationTime();
        firstName = smurf.getFirstName();
        lastName = smurf.getLastName();
        id = smurf.getId();
        coordinate = smurf.getCoordinate();
        lifeExpectation = smurf.getLifeExpectation();
        lastChangeTime = smurf.getLastChangeTime();

    }

    private OffsetDateTime getLastChangeTime() {
        return lastChangeTime;
    }
}
