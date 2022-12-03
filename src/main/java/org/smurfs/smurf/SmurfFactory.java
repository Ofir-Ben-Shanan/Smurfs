package org.smurfs.smurf;

import com.google.inject.Inject;
import org.smurfs.smurf.smurf_variables.FirstNames;
import org.smurfs.smurf.smurf_variables.LastNames;
import org.smurfs.smurf.smurf_variables.coordinate.Coordinate;
import org.smurfs.smurf.smurf_variables.coordinate.CoordinateFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


public class SmurfFactory implements IFactory<List<Smurf>> {

    @Inject
    private IFactory<Coordinate>  coordinateFactory = new CoordinateFactory();

    @Inject
    private int smurfNumber=1;



    @Override
    public List<Smurf> create() {
        List<Smurf> smurfs = new ArrayList<>();
        for (int i = 0; i < smurfNumber; i++)
            smurfs.add(new Smurf(FirstNames.randomFirstName(), LastNames.randomFirstName(),
                    UUID.randomUUID(), coordinateFactory.create()));
        return smurfs;
    }
}
