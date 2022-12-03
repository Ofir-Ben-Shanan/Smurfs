package org.smurfs.launcher;

import com.google.inject.Guice;
import com.google.inject.Injector;
import org.smurfs.guice_module.GuiceModule;
import org.smurfs.handler.SmurfsHandler;
import org.smurfs.json_streamer.JsonFilesIO;
import org.smurfs.smurf.Smurf;
import org.smurfs.smurf.SmurfFactory;
import org.smurfs.utils.Constants;

import java.io.IOException;
import java.time.OffsetDateTime;
import java.util.List;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

public class Launcher {

    public static void main(String[] args) {


        Injector injector = Guice.createInjector(new GuiceModule());
        Core core = injector.getInstance(Core.class);
        core.run();


//        SmurfFactory smurfFactory = new SmurfFactory();
//        List<Smurf> s =smurfFactory.create();
//
//
//        SmurfsHandler smurfsHandler= new SmurfsHandler();
//        smurfsHandler.handle(s);


    }
}
