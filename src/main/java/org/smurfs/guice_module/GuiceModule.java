package org.smurfs.guice_module;

import com.google.inject.AbstractModule;
import com.google.inject.name.Named;
import jdk.jfr.Name;
import org.smurfs.json_streamer.IOStreamer;
import org.smurfs.json_streamer.JsonFilesIO;
import org.smurfs.smurf.IFactory;
import org.smurfs.smurf.SmurfFactory;
import org.smurfs.smurf.smurf_variables.coordinate.Coordinate;
import org.smurfs.smurf.smurf_variables.coordinate.GenericCoordinate;

import java.util.Optional;

public class GuiceModule extends AbstractModule {

    @Override
    protected void configure() {
        bind(IOStreamer.class).to(JsonFilesIO.class);
        bind(GenericCoordinate.class).to(Coordinate.class);






    }
}

