package org.smurfs.launcher;

import com.google.inject.Inject;
import org.smurfs.handler.Handler;
import org.smurfs.smurf.Smurf;
import org.smurfs.smurf.SmurfFactory;

public class Core implements  Runnable {

    @Inject
    private SmurfFactory smurfFactory;

    @Inject

    private Handler<Smurf> smurfHandler;


    @Override
    public void run() {
        smurfHandler.handle(smurfFactory.create());
    }
}
