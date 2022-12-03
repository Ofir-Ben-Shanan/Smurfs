package org.smurfs.handler;

import com.google.inject.Inject;
import org.smurfs.json_streamer.IOStreamer;
import org.smurfs.json_streamer.JsonFilesIO;
import org.smurfs.smurf.Smurf;
import org.smurfs.smurf.SmurfFactory;
import org.smurfs.smurf.smurf_variables.FirstNames;
import org.smurfs.smurf.smurf_variables.LastNames;
import org.smurfs.smurf.smurf_variables.coordinate.CoordinateFactory;
import org.smurfs.utils.Constants;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;


public class SmurfsHandler implements Handler<Smurf> {

    private final IOStreamer ioStreamer;

    private final CoordinateFactory coordinateFactory;

    private final int samplingRate;

    @Inject
    public SmurfsHandler(IOStreamer ioStreamer, CoordinateFactory coordinateFactory,
                         int samplingRate) {
        this.samplingRate = samplingRate;
        this.coordinateFactory = coordinateFactory;
        this.ioStreamer = ioStreamer;


    }


    @Override
    public void handle(List<Smurf> object) {

        ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);
        executor.scheduleAtFixedRate(() -> object.parallelStream().forEach(smurf -> {
            if (smurf.getLifeExpectation().isZero() || smurf.getLifeExpectation().isNegative()) {
                smurf.setSmurf(new Smurf(FirstNames.randomFirstName(), LastNames.randomFirstName(),
                        UUID.randomUUID(), coordinateFactory.create()));
            } else {
                smurf.setCoordinate(coordinateFactory.create());
                smurf.setLastChangeTime(OffsetDateTime.now());
                smurf.getLifeExpectation().minusSeconds(samplingRate);
            }
            ioStreamer.write(Constants.JSON_FILE_PATH, object);


        }), 0, samplingRate, TimeUnit.SECONDS);


    }
}
