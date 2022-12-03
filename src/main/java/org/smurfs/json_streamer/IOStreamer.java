package org.smurfs.json_streamer;

import org.smurfs.smurf.Smurf;

import java.util.List;

public interface IOStreamer {

    void write(String path, List<Smurf> data);

    <T> T read(String path);
}
